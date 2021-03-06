package com.dhg.sell.domain.ajax;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AjaxResponse{
    private boolean isOk;
    private String msg;
    private int code;
    private Object data;

    public static AjaxResponse success() {
        /*Builder方法是静态的*/
        return AjaxResponse.builder().isOk(true).code(200).msg("success").build();
    }

    public static AjaxResponse success(Object data) {
        return AjaxResponse.builder().isOk(true).code(200).msg("success").data(data).build();
    }
}
