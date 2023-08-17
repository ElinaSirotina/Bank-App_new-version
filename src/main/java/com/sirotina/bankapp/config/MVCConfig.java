package com.sirotina.bankapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer { // Класс, который прописываем реакции на запросы - аналог контроллера, может выполнять и дополнительные функции

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login"); // Мапинг для формы login
        registry.addViewController("/register").setViewName("register"); // Мапинг для формы login
    }

}