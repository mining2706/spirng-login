package com.kaiser.login.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



// extends WebMvcConfigurerAdapter  는 deprecated 됨!
// WebMvcConfigurer와 WebMvcRegistrations 소스를 살펴보면 메서드들을 default 메서드로 선언했다.
// 필요한 메서드만 구현해서 사용하라는 의미다. Java7을 지원하는 스프링 부트 1.5 에서는
// default 메서드(https://goo.gl/A7CL31)가 없었기에 WebMvcConfigurer를 사용하려면 인터페이스에
// 선언된 메서드를 모두 구현해야 했다. 그런 불편함을 해소하고자 WebMvcConfigurerAdapter 추상 클래스를 제공했다.
//  이 추상 클래스를 상속받아 필요한 메서드만 오버라이드했다.
//
//  스프링 부트 2.0부터 Java8과 스프링 5.0을 사용하면서 WebMvcConfigurer 메서드에 default를 선언했다.
// 그 덕분에 WebMvcConfigurer를 구현하는 클래스에서 모든 메서드를 구현해야하는 강제력이 사라졌다.
// 쓰임새가 사라진 WebMvcConfigurerAdapter 클래스는 스프링 부트 2.0에서 제외(Deprecated)되었다.

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    Logger log = LoggerFactory.getLogger("WebMvcConfig.class");
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info("############################################# bCryptPasswordEncoder : "+ bCryptPasswordEncoder);
        return bCryptPasswordEncoder;
    }
}
