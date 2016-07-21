package cn.maitian.api;

import cn.maitian.api.base.BaseResponse;

/**
 * Created by geng on 2016/7/21.
 */
public class Response<D> extends BaseResponse {
    public D data;

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

}
