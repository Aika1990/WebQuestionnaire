package com.cit.rt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.cit.rt.controller")
public class WebMvcConfig  implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        mappingJackson2HttpMessageConverter.setPrettyPrint(true);
//        return mappingJackson2HttpMessageConverter;
//    }
//    @Bean
//    public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter() {
//        MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();
//        mappingJackson2XmlHttpMessageConverter.setPrettyPrint(true);
//        return mappingJackson2XmlHttpMessageConverter;
//    }
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter());
//        converters.add(mappingJackson2XmlHttpMessageConverter());
//    }
}
