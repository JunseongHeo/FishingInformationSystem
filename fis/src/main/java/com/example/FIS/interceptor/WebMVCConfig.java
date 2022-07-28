package com.example.FIS.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/board/createPost" );
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/board/getPost/{bno}/update" );
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/board/getPost/{bno}/delete" );
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/market/product/add" );
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/market/product/{p_id}/edit" );
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/market/product/{p_id}/delete" );
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/market/product/{p_id}/delivery" );
        registry.addInterceptor( new LoginInterceptor() ).addPathPatterns( "/login/myPage" );
    }
}
