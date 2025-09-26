package dev.slapps.jte;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

  public record RootModel(String foo, String bar) {
    public String blah() {
      return "blah!";
    }
  }

  @GetMapping("/")
  public String root(final Model model) {
    System.out.println("RootController.root()");
    System.out.println(model);

    final RootModel rootModel = new RootModel("foo1", "bar1");
    System.out.println(rootModel);

    model.addAttribute("model", rootModel);
    return "root";
  }
}
