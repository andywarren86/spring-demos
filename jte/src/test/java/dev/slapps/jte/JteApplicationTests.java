package dev.slapps.jte;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@SpringBootTest
// @ExtendWith(SpringExtension.class)
class JteApplicationTests {

	@Autowired
	ApplicationContext ctx;

	@Test
	void contextLoads() {
		System.out.println("JteApplicationTests.contextLoads()");
		System.out.println(ctx);
		List.of(ctx.getBeanDefinitionNames())
			.forEach(b -> System.out.println(b));
	}

}
