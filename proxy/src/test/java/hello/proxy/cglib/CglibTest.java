package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * JDK 동적 프록시 - 인터페이스 구현을 통해서 프록시 생성
 * CGLIB - 구체 클래스 상속을 통해서 프록시 생성
 */
@Slf4j
public class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class); //어떤 구체클래스 상속 받을지 지정
        enhancer.setCallback(new TimeMethodInterceptor(target)); //프록시에 적용할 실행 로직
        ConcreteService proxy = (ConcreteService) enhancer.create(); //프록시 생성
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();
    }
}
