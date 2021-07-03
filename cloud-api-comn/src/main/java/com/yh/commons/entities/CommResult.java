package com.yh.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
