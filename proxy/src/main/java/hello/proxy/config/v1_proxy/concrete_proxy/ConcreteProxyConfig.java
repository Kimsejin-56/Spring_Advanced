package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {
    @Bean
    public OrderControllerV2 orderController(LogTrace trace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderService(trace));
        return new OrderControllerConcreteProxy(controllerImpl, trace);
    }

    @Bean
    public OrderServiceV2 orderService(LogTrace trace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepository(trace));
        return new OrderServiceConcreteProxy(serviceImpl, trace);
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace trace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, trace);
    }
}
