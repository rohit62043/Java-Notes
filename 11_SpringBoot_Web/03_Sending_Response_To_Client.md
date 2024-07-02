# Sending Responses with Servlets

## Introduction to Sending Responses

In servlets, sending responses back to clients is essential. Here’s how you can effectively send responses using servlets and understand the HTTP methods.

### Basic Response Sending

1. **Using `getWriter()` Method**:

   - To send a basic text response, retrieve the `PrintWriter` object from the `HttpServletResponse`.
   - Example:
     ```java
     resp.setContentType("text/plain"); // Set content type of the response
     PrintWriter out = resp.getWriter();
     out.println("Hello, World!"); // Send response content
     ```

2. **Sending HTML Content**:
   - For HTML responses, set the content type to `text/html`.
   - Example:
     ```java
     resp.setContentType("text/html");
     PrintWriter out = resp.getWriter();
     out.println("<html><body><h2>Hello, World!</h2></body></html>");
     ```

### Using `doGet()` Method

1. **Handling GET Requests**:
   - Override the `doGet()` method to handle GET requests specifically.
   - Example:
     ```java
     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
         PrintWriter out = resp.getWriter();
         out.println("<html><body><h2>Hello, World!</h2></body></html>");
     }
     ```

### Understanding HTTP Methods

1. **HTTP Methods Overview**:

   - **GET**: Used to retrieve data from the server.
   - **POST**: Used to submit data to be processed to the server.
   - **PUT**: Used to update a resource on the server.
   - **DELETE**: Used to delete a resource on the server.
   - Servlets can handle these methods using `doGet()`, `doPost()`, `doPut()`, `doDelete()` methods respectively.

2. **Specifying Method in Servlets**:
   - Use specific method annotations or override respective `doXxx()` methods based on the HTTP method you want to handle.

### Conclusion

Sending responses with servlets involves setting the content type and using `PrintWriter` to send content back to clients. Understanding HTTP methods helps in handling different types of requests effectively. In the next steps, we’ll explore more advanced topics such as MVC architecture with Spring Boot for scalable and maintainable web application development.
