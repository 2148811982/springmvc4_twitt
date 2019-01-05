package twitt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import annotations.Cold;
import annotations.Creamy;
import annotations.Fruity;
import conditional.Dessert;
import conditional.Dessert2;
import twitt.confiuration.SoundSystemConfig;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class DessertTest {

	@Autowired
	@Cold
	@Creamy
	private Dessert icecream;
	
	@Autowired
	@Cold
	@Creamy
	private Dessert icecream1;
	
	@Autowired
	@Cold
	@Creamy
	private Dessert2 icecream2;
	
	@Autowired
	@Cold
	@Creamy
	private Dessert2 icecream3;
	
	@Autowired
	@Cold
	@Fruity
	private Dessert popsicle;
	
	@Test
	public void icecreamNotEqualsPopsicle() {
		assertNotSame(icecream, popsicle);
	}
	
	
	@Test
	public void prototype() {
		assertSame(icecream, icecream1);
		assertNotSame(icecream2, icecream3);
	}
}
