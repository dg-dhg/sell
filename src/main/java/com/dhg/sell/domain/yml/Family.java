package com.dhg.sell.domain.yml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//批量注入
@ConfigurationProperties(prefix = "family")
public class Family{
    private Father father;
    private Mother mother;
    private Child child;
    //单注入
//    @Value("${family.family-name}")
    private String familyName;
}
