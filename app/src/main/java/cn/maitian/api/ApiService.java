package cn.maitian.api;

import java.util.Map;

import cn.maitian.api.bean.UserBean;
import retrofit2.http.FieldMap;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by dandanba on 3/9/16.
 */
public interface ApiService {
    @POST("api/borrow/getborrowlistbyrobot")
    Observable<Response<UserBean>> getborrowlistbyrobot(@FieldMap Map<String, String> map, @Header("X-FANCY-TIMESTAMP") String timestamp, @Header("X-FANCY-SIGN") String sign);
}