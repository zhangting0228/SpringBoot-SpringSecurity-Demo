package com.zhangting.util;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description 自定义restful返回消息体
 */
@Data
@ToString
public class ResponseMsg {

    boolean status;
    Object data;
    int code;
    int total;

    /**
     * rest接口成功返回数据格式
     *
     * @param result
     * @return
     */
    public static ResponseMsg success(Object result) {
        ResponseMsg rest = new ResponseMsg();
        rest.status = true;
        rest.data = result;
        rest.code = 0;
        return rest;
    }

    /**
     * rest接口成功返回数据格式（带分页）
     *
     * @param result
     * @param total
     * @return
     */
    public static ResponseMsg success(Object result, int total) {
        ResponseMsg rest = new ResponseMsg();
        rest.status = true;
        rest.data = result;
        rest.total = total;
        rest.code = 0;
        return rest;
    }

    /**
     * rest接口失败返回数据格式
     *
     * @param code
     * @param comment
     * @return
     */
    public static ResponseMsg fail(int code, String comment) {
        ResponseMsg rest = new ResponseMsg();
        rest.status = false;
        rest.data = comment;
        rest.code = code;
        return rest;
    }

}
