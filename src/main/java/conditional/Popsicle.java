package conditional;

import org.springframework.stereotype.Component;

import annotations.Cold;
import annotations.Fruity;

@Component
@Cold
@Fruity
public class Popsicle implements Dessert {

	@Override
	public void taste() {
		System.out.println("Popsicle tastes");
	}

}
