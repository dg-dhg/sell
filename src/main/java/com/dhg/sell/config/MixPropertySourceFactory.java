package com.dhg.sell.config;


import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

public class MixPropertySourceFactory extends DefaultPropertySourceFactory{

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if(!resource.getResource().exists()) {
            return new PropertiesPropertySource(sourceName, new Properties());
        } else if(sourceName != null) {
            if(sourceName.endsWith("yaml") || sourceName.endsWith("yml")) {
                Properties propertiesFromYaml = loadYml(resource);
                return new PropertiesPropertySource(sourceName, propertiesFromYaml);
            }
        }
        return super.createPropertySource(name, resource);
    }

    private Properties loadYml(EncodedResource resource) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
