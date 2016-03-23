package charan.example.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import charan.example.domain.Product;
import charan.example.repositories.ProductRepository;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;

	private Logger log = Logger.getLogger(ProductLoader.class);

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Product shirt = new Product();
		shirt.setDescription("T-Shirt");
		shirt.setPrice(new BigDecimal("18.95"));
		shirt.setImageUrl("https://blahblah/");
		shirt.setProductId("235268845711068308");
		productRepository.save(shirt);

		log.info("Saved Shirt - id: " + shirt.getId());

		Product mug = new Product();
		mug.setDescription("Coffee Mug");
		mug.setImageUrl("https://asdasd.asd/");
		mug.setProductId("168639393495335947");
		mug.setPrice(new BigDecimal("11.95"));
		productRepository.save(mug);

		log.info("Saved Mug - id:" + mug.getId());
	}
}
