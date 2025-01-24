package com.tuya.visual.consumer;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回统一结构体
 *
 * @author 草薙
 * @since 2021/7/14
 */
@Data
public class ResultDO<T> implements Serializable {
    private static final long serialVersionUID = -8167373708539244445L;

    /**
     * 请求成功与否
     */
    private Boolean success;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 请求响应时间
     */
    private Long t;

    /**
     * 请求响应结果对象
     */
    private T data;

    public ResultDO() {
    }

    public ResultDO(Boolean success, T data) {
        this.success = success;
        this.data = data;
        this.t = System.currentTimeMillis();
    }

    public ResultDO(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
        this.t = System.currentTimeMillis();
    }

    public ResultDO(Boolean success) {
        this.success = success;
    }

    public static <T> ResultDO<T> ofSuccess(T result) {
        return new ResultDO<>(Boolean.TRUE, result);
    }

    public static <T> ResultDO<T> ofFail() {
        return ofFail(null);
    }

    public static <T> ResultDO<T> ofFail(String msg) {
        return new ResultDO<>(Boolean.FALSE, msg);
    }

    public static <T> ResultDO<T> ofFail(T result) {
        return new ResultDO<>(Boolean.FALSE, result);
    }

}
