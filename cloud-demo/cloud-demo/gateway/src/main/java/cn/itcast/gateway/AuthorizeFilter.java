package cn.itcast.gateway;

import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
//全局过滤器，自行编写的，不固定
//@order(-1)
@Component
public class AuthorizeFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求参数
        val request = exchange.getRequest();
        val queryParams = request.getQueryParams();
        //2.获取参数中的authorization参数
        val auth = queryParams.getFirst("authorization");
        //3.判断参数是否等于admin
        if ("admin".equals(auth)){
            //4是，放行
           return chain.filter(exchange); //调用下一个过滤器使用
        }
        //5否拦截
        //5.1设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//401 未登录
        //5.2拦截请求
        return  exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
