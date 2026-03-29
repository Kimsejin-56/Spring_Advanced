package hello.proxy.config.v5_autoproxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 스프링이 제공하는 자동 프록시 생성기
 *  - AnnotationAwareAspectJAutoProxyCreator라는 빈 후처리기가 스프링 빈에 자동으로 등록
 *  - 이때 스프링 빈으로 등록된 Advisor들을 자동으로 찾아서 Advisor 안에 pointcut 이용
 *  - 등록된 스프링 빈에 클래스나 메서드 하나하나 pointcut 적용, 많은 메서드 중 1개라도 만족하면 프록시 생성 반환, 불만족 시 원복 객체 반환
 *
 *  pointcut 2가지 용도
 *   - 프록시 적용 대상 여부 체크(생성 단계)
 *   - 어드바이스 적용 대상 여부 체크(사용 단계)
 */
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AutoProxyConfig {
    @Bean
    public Advisor advisor1(LogTrace trace) {
        //pointcut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        //advice
        LogTraceAdvice advice = new LogTraceAdvice(trace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}


