package dev.slapps.web_security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class WebSecurityApplicationTests {

  @Autowired private ApplicationContext appContext;

  @Test
  void contextLoads() {
    System.out.println("WebSecurityApplicationTests.contextLoads()");
    System.out.println(appContext);
  }
}
