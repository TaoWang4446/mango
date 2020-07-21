package com.wst.mango.zuul;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 实现该接口有两个方法：一个是getRoute()，用于指定熔断器功能应用于哪些路由的服务；另一个方法是fallbackResponse()，
 * 为进入熔断器功能时执行的逻辑。
 * 创建MyFallbackProvider类，getRoute()方法返回"mango-consumer"，只针对consumer服务进行熔断。
 * 如果需要所有的路由服务都加熔断功能，需要在getRoute()方法上返回" * "匹配符。
 * getBody()方法返回发送熔断时的反馈信息，这里在发送熔断时返回信息"Sorry, the service is unavailable now."。
 */
@Component
public class MyFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        return "mango-consumer";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        System.out.println("route:"+route);
        System.out.println("exception:"+cause.getMessage());
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("Sorry, the service is unavailable now.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}