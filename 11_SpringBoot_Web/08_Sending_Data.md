### Building a Simple Calculator Functionality with Spring MVC

#### 1. Creating the Form for Adding Numbers

First, let's create a simple HTML form where users can input two numbers and submit them to the server.

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Calculator</title>
    <link rel="stylesheet" href="style.css" />
    <!-- Linking external CSS -->
  </head>
  <body>
    <h2>Calculator</h2>
    <form action="/add" method="get">
      <label for="num1">Enter the first number:</label>
      <input type="text" id="num1" name="num1" /><br /><br />
      <label for="num2">Enter the second number:</label>
      <input type="text" id="num2" name="num2" /><br /><br />
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
```

## 2. Styling the Form with CSS

- Let's apply some basic styling to make the form look more presentable. Create a style.css file and link it to your HTML file.

```css
/* style.css */
body {
  font-family: "Arial", sans-serif;
  background-color: #f0f0f0;
  margin: 20px;
  padding: 20px;
  width: 300px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

h2 {
  color: #333;
  text-align: center;
}

form {
  background-color: #fff;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

label {
  display: block;
  margin-bottom: 10px;
}

input[type="text"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

input[type="submit"] {
  background-color: #4caf50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 100%;
}

input[type="submit"]:hover {
  background-color: #45a049;
}
```

## 3. Handling the Form Submission with Spring MVC

Now, let's create a controller that will handle the form submission and perform the addition operation.

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

   @RequestMapping("add")
	public String add(HttpServletRequest req,HttpSession session) {

int num1=Integer.parseInt(req.getParameter("num1"));
int num2=Integer.parseInt(req.getParameter("num2"));
int result=num1+num2;
	session.setAttribute("result", result);

		return "result.jsp";
	}
}
```

## 4. Creating the Result JSP Page

Finally, create a result.jsp page to display the result of the addition operation.

```jsp
<!-- result.jsp -->
<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>

<!--     using plain Java -->
        <h2>Result is:<%= session.getAttribute("result") %></h2>


       <!--  using jstl tags -->
        <h2>Result is: ${result}  </h2>

    </body>
</html>
```

## 5. Explanation

- `Form Submission`: When the user submits the form, it sends a GET request to /add with parameters num1 and num2.
- `Controller`: CalculatorController handles the /add request, performs addition, and returns a ModelAndView with the logical view name result.
- `Result Page`: result.jsp is rendered with the sum of the two numbers.
- This setup allows users to add two numbers via a form, submit the data to the server, perform an operation (addition in this case), and display the result using Spring MVC.
