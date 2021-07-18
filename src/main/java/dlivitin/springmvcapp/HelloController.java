package dlivitin.springmvcapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // Controller will use this method when user will request localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String sayHello(){

        // We will return hello_world.html page from WEB-INF/views/
        return "hello_wolrd";
    }
}
