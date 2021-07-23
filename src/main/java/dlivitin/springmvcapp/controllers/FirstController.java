package dlivitin.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String helloPage(@RequestParam(value = "name", required = false) String name, @RequestParam("surname") String surname, Model model) {
        // "required = false" means that user can access the page without specifying parameter "name"

        // We can get parameters of GET request(do not forget to use @RequestParam in the parameters of the method)
        // for example: localhost:8080/first/hello?name=Tom&surname=Jones
        // We will get name = Tom and surname = Jones

//        System.out.println(name + " " + surname + " hello!");
        model.addAttribute("message", name + " " + surname + " hello!");
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b, @RequestParam(value = "action") String action, Model model){

        // We can save parameters from GET request using Models( do not forget to add Model model in the parameters of the method)
        // We just add needed parameters in the model
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("action", action);
        double result;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
                break;
            }
            model.addAttribute("result", result);

        // To use data from the model on the html page we can use such code as: <p th:text="${a}"></p>
        return "first/calculator";

    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
