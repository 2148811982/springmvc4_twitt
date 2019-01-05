package conditional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import annotations.Cold;
import annotations.Creamy;

@Component
@Creamy
@Cold
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IceCream2 implements Dessert2 {

}
