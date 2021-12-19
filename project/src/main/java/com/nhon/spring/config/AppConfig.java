package com.nhon.spring.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.nhon.spring.models.User;
import com.nhon.spring.repository.ProductRepository;
import com.nhon.spring.repository.ProductRepositoryImpl;
import com.nhon.spring.repository.UserRepository;
import com.nhon.spring.repository.UserRepositoryImpl;
import com.nhon.spring.service.ProductService;
import com.nhon.spring.service.ProductServiceImpl;
import com.nhon.spring.service.UserService;
import com.nhon.spring.service.UserServiceImpl;




@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.nhon.spring"
})
public class AppConfig implements WebMvcConfigurer {

	
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public UserRepository  userRepository(){
        return new UserRepositoryImpl();
    }
    
}