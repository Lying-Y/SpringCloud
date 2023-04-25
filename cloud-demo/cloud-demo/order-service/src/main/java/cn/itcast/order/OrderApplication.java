package cn.itcast.order;

import cn.itcast.feign.Client.UserClient;
import cn.itcast.feign.config.DefaultFeignConfiguration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {UserClient.class},defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
/*
* 使用RestTemplate发送http请求
* */
    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate(){
    return new RestTemplate();
    }

//    @Bean //修改负载均衡的策略，查找user的方式
//    public IRule randomRule(){
//        return  new RandomRule();
//    }

}