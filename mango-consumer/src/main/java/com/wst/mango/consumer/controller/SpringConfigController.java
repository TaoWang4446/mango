package com.wst.mango.consumer.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我们发现返回结果并没有读取最新提交的内容，
 * 这是因为Spring Boot项目只有在启动的时候才会获取配置文件的内容，虽然GIT配置信息被修改了，
 * 但是客户端并没有重新去获取，所以导致读取的信息仍然是旧配置。
 * 那么该如何去解决这个问题呢？这就是我们后续要讲的Spring Cloud Bus。
 */
@RefreshScope
@RestController
class SpringConfigController {
    
    @Value("${dev}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
    
}