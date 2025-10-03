// Copyright 2025 Qvalent Pty. Ltd.
package dev.slapps.web_security;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcController {

  @GetMapping({"/", "/home"})
  public String home() {
    System.out.println("HomeController.home()");
    return "home";
  }

  @GetMapping("/login")
  public String login() {
    System.out.println("HomeController.login()");
    return "login";
  }

  @GetMapping("/hello")
  public ModelAndView hello(final Principal user, final ModelAndView mav) {
    System.out.println("HomeController.hello()");
    // System.out.println("User: " + user);
    // System.out.println(user.getClass().getName());

    // if ( user instanceof UsernamePasswordAuthenticationToken token ) {
    // }

    mav.setViewName("hello");
    mav.addObject("user", user);
    mav.addObject("name", user.getName());
    return mav;
  }
}
