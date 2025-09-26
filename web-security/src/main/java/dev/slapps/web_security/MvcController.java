// Copyright 2025 Qvalent Pty. Ltd.
package dev.slapps.web_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

  @GetMapping({"/", "/home"})
  public String home() {
    System.out.println("HomeController.home()");
    return "home";
  }

  @GetMapping("/hello")
  public String hello() {
    System.out.println("HomeController.hello()");
    return "hello";
  }

//   @GetMapping("/login")
//   public String login() {
//     System.out.println("HomeController.login()");
//     return "login";
//   }
}
