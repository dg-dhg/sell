package com.dhg.sell.domain.yml;

import lombok.Data;

import java.util.List;

@Data
class Child{
    private List<Friend> Friends;
    private String name;
    private String gender;
    private String hobby;
}
