package dev.slapps.jte;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

  @GetMapping("/")
  public String root(final Model model) {
    System.out.println("RootController.root()");
    model.addAttribute("foo", "bar");
    System.out.println(model);
    return "root";
  }

}
