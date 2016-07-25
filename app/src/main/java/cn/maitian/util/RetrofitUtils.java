package cn.maitian.util;

import android.content.Context;

import com.litesuits.common.assist.Network;

import java.io.File;
import java.util.concurrent.TimeUnit;

import cn.maitian.BuildConfig;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitUtils {
    public static final String BASE_URL = BuildConfig.DEBUG_URL ? "http://112.74.132.249:8082/" : "http://112.74.132.249:8082/";

    public static Retrofit initClient(Context context) {
        // Define the interceptor, add authentication headers
        Interceptor headerInterceptor = chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("PLATFORM", "android")
                    .addHeader("APPLICATION_ID", BuildConfig.APPLICATION_ID)
                    .addHeader("FLAVOR", BuildConfig.FLAVOR)
                    .addHeader("VERSION_CODE", String.valueOf(BuildConfig.VERSION_CODE))
                    .addHeader("VERSION_NAME", BuildConfig.VERSION_NAME)
                    .build();
            return chain.proceed(newRequest);
        };

        //设置缓存
        final File dir = new File(context.getExternalCacheDir(), BuildConfig.APPLICATION_ID);
        final Cache cache = new Cache(dir, 1024 * 1024 * 50);

        final Interceptor cacheInterceptor = chain -> {
            Response response = chain.proceed(chain.request());
            if (Network.isConnected(context)) {
                int maxAge = 60; // read from cache for 1 minute
                return response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(cacheInterceptor)
                .cache(cache)
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


}