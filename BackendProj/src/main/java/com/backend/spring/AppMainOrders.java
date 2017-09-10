package com.backend.spring;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.backend.spring.configuration.AppConfig;
import com.backend.spring.model.Cart;
import com.backend.spring.model.Orders;
import com.backend.spring.model.Product;
import com.backend.spring.model.User;
import com.backend.spring.service.OrdersService;
import com.backend.spring.service.ProductService;

public class AppMainOrders {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrdersService service=(OrdersService)context.getBean("ordersService");
		
		User user=new User();
		user.setName("MansiSrivas");
		user.setPassword("pw");
		user.setPhoneno("9654081469");
		user.setState("UP");
		user.setCity("Gzb");
		user.setCountry("India");
		user.setEmail("email@mm.com");
		user.setHouseno("257");
		
		Cart cart=new Cart(user);
		
		Set<Product> pdts = new HashSet<Product>();
		
		Product product1=new Product();
		product1.setName("AAAA");
		product1.setPrice(12);
		product1.setDescription("Gut");
		product1.setQuantity(5);
		product1.setStatus("shipped");
		product1.setImagepath("nbsc/bx/nvcsz");
		
		Product product2=new Product();
		product2.setName("BBBB");
		product2.setPrice(13);
		product2.setDescription("Guss");
		product2.setQuantity(5);
		product2.setStatus("shipped");
		product2.setImagepath("nbsc/bx/nvcsz");
		
		pdts.add(product1);
		pdts.add(product2);
			
		Orders order=new Orders();
		order.setQuantity(2);
		order.setStatus("Shipping");
		order.setCart(cart);
		order.setProductset(pdts);
		
		service.saveOrders(order);
	}

}
