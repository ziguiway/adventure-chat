package com.ziguiway.adventurechat.bean.vo;

import com.ziguiway.adventurechat.common.ResultCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultVo<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> ResultVo<T> success(T object) {
        ResultVo<T> r = new ResultVo<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> ResultVo<T> error(String msg, ResultCode resultCode) {
        ResultVo r = new ResultVo();
        r.msg = msg;
        r.code = resultCode.getCode();
        return r;
    }

    public ResultVo<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
