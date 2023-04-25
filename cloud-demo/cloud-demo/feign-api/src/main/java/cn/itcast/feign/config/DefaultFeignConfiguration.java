package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;


public class DefaultFeignConfiguration {
    //加注解在启动类或者具体类上，具体类时注解内容不同
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }

}
