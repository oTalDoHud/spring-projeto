package com.example.aula01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.aula01.model.entities.Category;
import com.example.aula01.model.entities.Order;
import com.example.aula01.model.entities.Product;
import com.example.aula01.model.entities.User;
import com.example.aula01.model.entities.enums.OrderStatus;
import com.example.aula01.repositories.CategoryRepository;
import com.example.aula01.repositories.OrderRepository;
import com.example.aula01.repositories.ProductRepository;
import com.example.aula01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository OrderRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public void run(String... args) throws Exception {
		User hud = new User("Hudson", "Hudson@gmail.com", "11 932165604", "1234");

		User pp = new User("Peterson", "Peterson@gmail.com", "11 916572354", "abcde");

		userRepo.saveAll(Arrays.asList(hud, pp));
		
		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), 
				OrderStatus.PAID, hud); 
		
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"),
				OrderStatus.WAITING_PAYMENT, pp); 
		Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"),
				OrderStatus.WAITING_PAYMENT, hud); 
		
		OrderRepo.saveAll(Arrays.asList(o1, o2, o3));
		
		Category cat1 = new Category("Electronics"); 
		Category cat2 = new Category("Books"); 
		Category cat3 = new Category("Computers"); 
		
		categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", 
				"Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		
		Product p2 = new Product(null, "Smart TV", 
				"Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		
		Product p3 = new Product(null, "Macbook Pro",
				"Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		
		Product p4 = new Product(null, "PC Gamer",
				"Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		
		Product p5 = new Product(null, "Rails for Dummies", 
				"Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}

}
