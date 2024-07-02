### Creating a Spring MVC Controller and `index.jsp`

#### 1. Create `HomeController` Class

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        System.out.println("Home method called");
        return "index"; // Return the logical view name of your JSP file without the .jsp extension
    }
}
```

## Explanation:

- `@Controller`: Indicates that this class serves the role of a controller in Spring MVC.
- `@GetMapping("/")`: Specifies that the home() method should handle GET requests for the root URL ("/").
- `home()`: This method returns "index", which is the logical view name. Spring will look for a file named index.jsp (or index.jsp based on your configuration) in the configured view resolver to render.
