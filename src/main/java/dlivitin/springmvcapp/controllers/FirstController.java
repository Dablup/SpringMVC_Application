package dlivitin.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
// We use @RequestMapping before class when we want to have some part in URL before every mapping
// For example, localhost/first/hello
//              localhost/first/goodbye
@RequestMapping("/first")
public class FirstController {


    // FIRST way of getting parameters from the GET request
    //    @GetMapping("/hello")
    //    public String helloPage(HttpServletRequest request){
    //
    //        // We can get parameters of GET request(do not forget to specify HttpServletRequest in parameters of the method)
    //        // for example: localhost:8080/first/hello?name=Tom&surname=Jones
    //        // We will get name = Tom and surname = Jones
    //        String name = request.getParameter("name");
    //        String surname = request.getParameter("surname");
    //        System.out.println(name + " " + surname + " hello!");
    //        return "first/hello";
    //    }

    // SECOND way of getting parameters from the GET request
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name, @RequestParam("surname") String surname) {
        // "required = false" means that user can access the page without specifying parameter "name"

        // We can get parameters of GET request(do not forget to use @RequestParam in the parameters of the method)
        // for example: localhost:8080/first/hello?name=Tom&surname=Jones
        // We will get name = Tom and surname = Jones

        System.out.println(name + " " + surname + " hello!");
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
