package com.dhg.sell.domain.ajax;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AjaxResponse{
    private boolean isOk;
    private String message;
    private int code;
    private Object data;

    public static AjaxResponse success() {
        /*Builder方法是静态的*/
        return AjaxResponse.builder().isOk(true).code(200).message("success").build();
    }

    public static AjaxResponse success(Object data) {
        return AjaxResponse.builder().isOk(true).code(200).message("success").data(data).build();
    }
}
