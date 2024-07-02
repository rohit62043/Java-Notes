### Simplifying Controller Logic with @RequestParam in Spring MVC

#### Handling Parameters Directly with @RequestParam

In Spring MVC, you can simplify handling request parameters by directly mapping them to method parameters using the `@RequestParam` annotation.

1. **Creating the Controller Method**:

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @RequestMapping("/add")
    public ModelAndView addNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
       int result=num1+num2;
	session.setAttribute("result", result);

		return "result.jsp";
	}
}
```
