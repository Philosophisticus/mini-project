package com.at.config;

import com.at.converter.StringToDateTimeConverter;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Properties;


@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = {
        "com.at.service",
        "com.at.export",
        "com.at.exception",
        "com.at.helper",
        "com.at.validator",
        "com.at.constants",
        "com.at.dto.factory"})
@Import({DatabaseConfig.class, SecurityConfig.class})
public class AppConfig
{

    private static final String VELOCITY_RESOURCE_LOADER = "class";
    private static final String VELOCITY_RESOURCE_LOADER_CLASS = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";

    @Bean
    ReloadableResourceBundleMessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:i18n/applicationErrors", "classpath:i18n/emailMessage",
                "classpath:i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.toString());
        return messageSource;
    }


    @Bean
    ConversionService conversionService()
    {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        factoryBean.setConverters(Collections.singleton(stringToDateTimeConverter()));
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Bean
    StringToDateTimeConverter stringToDateTimeConverter()
    {
        return new StringToDateTimeConverter();
    }

    @Bean
    MultipartResolver multipartResolver()
    {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5242880);
        return multipartResolver;
    }

    @Bean
    RequestContextListener requestContextListener()
    {
        return new RequestContextListener();
    }

    @Bean
    VelocityEngine velocityEngine()
            throws VelocityException, IOException
    {
        VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
        Properties props = new Properties();
        props.put("resource.loader", VELOCITY_RESOURCE_LOADER);
        props.put("class.resource.loader.class", VELOCITY_RESOURCE_LOADER_CLASS);
        factory.setVelocityProperties(props);

        return factory.createVelocityEngine();
    }

}