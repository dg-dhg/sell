package com.dhg.sell.domain;

import lombok.Data;

import java.util.List;

@Data
public class CategoryProduct{
    /**
     * id : 1
     * name : lism
     * user : [{"id":2,"name":"hello"}]
     */

    private int id;
    private String name;
    private List<UserBean> user;

    @Data
    public static class UserBean{
        /**
         * id : 2
         * name : hello
         */

        private int id;
        private String name;

    }
}
