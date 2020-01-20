package com.dhg.sell.domain.yml;

import com.dhg.sell.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @see javax.validation.constraints
 * 这个包下存放的是校验的规则的注解
 */
@Data
@Component
//批量注入
@ConfigurationProperties(prefix = "family")
//校验
@Validated
@PropertySource(value = "classpath:family.yml",factory = MixPropertySourceFactory.class)
public class Family{
    private Father father;
    private Mother mother;
    private Child child;
    //单注入
//    @Value("${family.family-name}")
    @NotEmpty
    private String familyName;
}
