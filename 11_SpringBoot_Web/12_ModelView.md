### Using Model and View in Spring MVC

In this video, we discussed using the `ModelAndView` object to handle data and view resolution in Spring MVC.

1. **Handling Static Resources (CSS)**:

   - Moved the CSS file to a separate folder (`static` or `webapp`) to ensure proper styling.
   - Recommended placing static resources like CSS files in the `static` folder within `resources` for better project structure.

2. **Introduction to ModelAndView**:

   - Previously, we used the `Model` object solely for passing data to the view (`result` in this case).
   - Introduced `ModelAndView` (abbreviated as `MV`) which encapsulates both data (model) and view name.

3. **Usage of ModelAndView**:

   - Instead of adding attributes to `Model` (`model.addAttribute("result", result)`), now use `ModelAndView`:
     ```java
     ModelAndView mv = new ModelAndView("result");
     mv.addObject("result", result);
     ```
   - Directly specifies the view name ("result") and adds the result as an attribute.

4. **Returning ModelAndView**:

   - Preferably return `ModelAndView` from controller methods instead of just the view name:
     ```java
     return mv;
     ```
   - Ensures clarity and simplicity, combining data and view resolution into a single object.

5. **Configuring ViewResolver**:

   - Configured `application.properties` to specify the view prefix and suffix:
     ```properties
     spring.mvc.view.prefix=/views/
     spring.mvc.view.suffix=.jsp
     ```
   - Ensures correct resolution of JSP views located in the `/views/` folder without explicitly specifying the `.jsp` extension.

6. **Testing and Deployment**:
   - Restarted the application to apply changes in configuration and tested functionality by submitting form data.
   - Ensured that both data passing (`Model`) and view resolution (`ViewResolver`) worked seamlessly together.

By leveraging `ModelAndView`, Spring MVC provides a streamlined approach to managing both data and views, enhancing maintainability and flexibility in web application development.

```java
@Controller
public class CalculatorController {

    @RequestMapping("/add")
    public ModelAndView addNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int sum = num1 + num2;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result"); // logical view name of result JSP
        mv.addObject("num1", num1);
        mv.addObject("num2", num2);
        mv.addObject("sum", sum);
        return mv;
    }
}
```
