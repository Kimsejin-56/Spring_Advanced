package hello.proxy.decorator;

import hello.proxy.decorator.code.Component;
import hello.proxy.decorator.code.DecoratorPatternClient;
import hello.proxy.decorator.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
