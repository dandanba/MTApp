package cn.maitian.util;

import java.util.concurrent.TimeUnit;

import cn.maitian.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtils {
    public static final String BASE_URL = BuildConfig.DEBUG_URL ? "http://112.74.132.249:8082/" : "http://112.74.132.249:8082/";

    public static Retrofit getClient() {
        // Define the interceptor, add authentication headers
        Interceptor interceptor = chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("PLATFORM", "android")
                    .addHeader("APPLICATION_ID", BuildConfig.APPLICATION_ID)
                    .addHeader("FLAVOR", BuildConfig.FLAVOR)
                    .addHeader("VERSION_CODE", String.valueOf(BuildConfig.VERSION_CODE))
                    .addHeader("VERSION_NAME", BuildConfig.VERSION_NAME)
                    .build();
            return chain.proceed(newRequest);
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(null)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(JacksonUtil.getObjectMapper()))
                .client(client)
                .build();

        return retrofit;
    }

    public static void subscribe(Observable observable, Subscriber subscriber) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}