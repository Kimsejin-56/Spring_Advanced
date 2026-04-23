package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ObjectProvider(Provider), ApplicationContext를 사용해서 지연(LAZY) 조회
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV2 {
//    private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callServiceV2Provider;

    public void external() {
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceV2Provider.getObject(); //Spring Container 빈 조회
        log.info("call external");
        callServiceV2.internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
