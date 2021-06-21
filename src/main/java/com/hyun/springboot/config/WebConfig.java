package com.hyun.springboot.config;

import com.hyun.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

<<<<<<< HEAD
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        //HandlerMethodArgumentResolver 는 항상 WebMvcConfigurer의 addArgumentResolvers()를 통해 추가해야 함.
=======
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
>>>>>>> origin/master
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
