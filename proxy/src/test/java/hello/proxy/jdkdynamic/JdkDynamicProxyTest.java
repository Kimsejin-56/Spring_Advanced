package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * JDK 동적 프록시
 *  - 인터페이스 기반으로 동적 프록시 생성, 인터페이스 필수
 *  동적으로 런타임 시에 개발자 대신 프록시를 생성하고,
 *  개발자는 핸들러 로직에 프록시가 처리할 공통 로직을 정의
 */
@Slf4j
public class JdkDynamicProxyTest {
    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target); //동적 프록시에 적용할 핸들러 로직
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target); //동적 프록시에 적용할 핸들러 로직
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
