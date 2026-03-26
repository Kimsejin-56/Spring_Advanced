package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 인터페이스 없고, 구체 클래스만 있는 상황
 */
@Slf4j
public class ConcreteLogic {

    public String operation() {
        log.info("ConcreteLogic 실행");
        return "data";
    }
}
