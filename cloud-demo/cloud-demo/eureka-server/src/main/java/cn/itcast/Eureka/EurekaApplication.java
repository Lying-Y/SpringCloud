package cn.itcast.Eureka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //开关 , 必须更改jdk为8,File | Settings | Build, Execution, Deployment | Compiler | Java Compiler
@SpringBootApplication
//先执行Eureka
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
