package com.dhg.sell.domain.ajax;

import lombok.Builder;

@Builder
public class AjaxResponse{
    private boolean ok;
    private String msg;
    private int code;
    private Object data;

    private AjaxResponse() {
    }

    public static AjaxResponse success() {
        /*Builder方法是静态的*/
        return AjaxResponse.builder().ok(true).code(200).msg("success").build();
    }

    public static AjaxResponse success(Object data) {
        return AjaxResponse.builder().ok(true).code(200).msg("success").data(data).build();
    }
}
