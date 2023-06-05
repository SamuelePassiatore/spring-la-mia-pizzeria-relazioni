package org.example.pizzeria;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.example.pizzeria.pojo.Pizza;
import org.example.pizzeria.pojo.SpecialOffer;
import org.example.pizzeria.serv.PizzaService;
import org.example.pizzeria.serv.SpecialOfferServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private SpecialOfferServ specialOfferServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("Margherita", "Pomodoro, mozzarella e basilico.", "https://static.cookist.it/wp-content/uploads/sites/21/2018/04/pizza-margherita-fatta-in-casa.jpg", 6.00);
		Pizza p2 = new Pizza("Diavola", "Pomodoro, Mozzarella e salame piccante.", "https://i1.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2017/06/3236_Pizza.jpg?resize=895%2C616&ssl=1", 8.00);
		Pizza p3 = new Pizza("Quattro formaggi", "Pomodoro, mozzarella, gorgonzola, taleggio, parmigiano e groviera.", "https://cdn.ilclubdellericette.it/wp-content/uploads/2020/04/pizza-ai-quattro-formaggi-fatta-in-casa-1280x720.jpg", 7.00);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		
		List<Pizza> pizze = pizzaService.findAll();
		System.out.println(pizze);
		
		SpecialOffer so1 = new SpecialOffer(LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-30"), "Offerta speciale 1", 5, p1);
		SpecialOffer so2 = new SpecialOffer(LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-30"), "Offerta speciale 2",  10, p2);
		SpecialOffer so3 = new SpecialOffer(LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-30"), "Offerta speciale 3", 15, p3);
		SpecialOffer so4 = new SpecialOffer(LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-30"), "Offerta speciale 4", 20, p1);
		SpecialOffer so5 = new SpecialOffer(LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-30"), "Offerta speciale 5", 25, p2);
		
		specialOfferServ.save(so1);
		specialOfferServ.save(so2);
		specialOfferServ.save(so3);
		specialOfferServ.save(so4);
		specialOfferServ.save(so5);
		
		for(Pizza pizza : pizze) {

			Optional<Pizza> optPizzaOffer = pizzaService.findByIdWithSpecialOffer(pizza.getId());
			Pizza pizzaOffer = optPizzaOffer.get();
			System.out.println(pizzaOffer.getSpecialOffers());

		}
	}

	
	

}
