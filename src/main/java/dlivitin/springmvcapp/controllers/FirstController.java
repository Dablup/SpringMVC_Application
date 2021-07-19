package dlivitin.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// We use @RequestMapping before class when we want to have some part in URL before every mapping
// For example, localhost/first/hello
//              localhost/first/goodbye
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(){
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
