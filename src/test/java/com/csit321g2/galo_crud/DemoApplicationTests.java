package com.csit321g2.galo_crud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.csit321g2.galo_crud.controller.ItemController;
import com.csit321g2.galo_crud.repository.ItemRepository;
import com.csit321g2.galo_crud.service.ItemService;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(context.getBean(ItemController.class));
		assertNotNull(context.getBean(ItemService.class));
		assertNotNull(context.getBean(ItemRepository.class));
	}

}
