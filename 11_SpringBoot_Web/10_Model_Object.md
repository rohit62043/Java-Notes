### Refactoring Controller Logic and Removing Dependency on HttpSession

#### Using Model Object Instead of HttpSession

In Spring MVC, you can use the `Model` object to transfer data between the controller and the view, eliminating the need for `HttpSession`.

1. **Refactored Controller Method**:

```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping("/add")
    public String addNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
        int sum = num1 + num2;
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("sum", sum);
        return "result";
    }
}
```

```jsp
<!-- result.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
    <h2>Result</h2>
    <p>Sum of <%= num1 %> and <%= num2 %> is <%= sum %>.</p>
</body>
</html>
```
