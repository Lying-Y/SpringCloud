package cn.itcast.order.service;

import cn.itcast.feign.Client.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient; //Feign处理HTTP
    public Order queryOrderById(Long orderId) {
        // 1.查询订单

        Order order = orderMapper.findById(orderId);
        // 2.利用Feign发送请求
        //发送http请求，返回json
        User user= userClient.findById(order.getUserId());
        //3.封装user
        order.setUser(user);
        // 4.返回
        return order;
    }
//    @Autowired //restTemplate
//    private RestTemplate restTemplate;
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        // 2.利用RestTemplate发送请求
//        Order order = orderMapper.findById(orderId);
//        String url="http://userservice/user/"+order.getUserId();
//        //发送http请求，返回json
//        User user= restTemplate.getForObject(url, User.class);
//        //3.封装user
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
