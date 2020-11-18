package com.richard.intercorp.demo;

import com.richard.intercorp.demo.models.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Spy
	List<String> spyList = new ArrayList<String>();

	@Test
	void contextLoads() {
	}

	@Test
	void clients() {
		List<Cliente> list = new ArrayList<Cliente>();

		List<Cliente> spyList = Mockito.spy(list);
	}

}
