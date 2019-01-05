package conditional;

import org.springframework.stereotype.Component;

import annotations.Cold;
import annotations.Creamy;

@Component
@Creamy
@Cold
public class IceCream implements Dessert {

	@Override
	public void taste() {
		System.out.println("IceCream tastes");
	}

}
