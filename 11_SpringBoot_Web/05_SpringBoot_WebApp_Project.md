# Creating a Web Application with Spring Boot

## Introduction to Spring Boot

Spring Boot simplifies web application development using the MVC (Model-View-Controller) pattern. It offers ease of setup and configuration compared to traditional Spring MVC.

### Getting Started with Spring Boot

1. **Setting Up the Project**:

   - Visit [Spring Initializr](https://start.spring.io/) to initialize your project.
   - Choose Maven Project, Java language, and specify the Spring Boot version (e.g., 3.2).
   - Group and artifact names are defined (e.g., com.telusko, SpringboardWeb1).
   - Select Jar packaging since we'll be using an embedded Tomcat server.

2. **Adding Dependencies**:

   - Search for "web" dependency to include Spring Web.
   - Optionally, choose Thymeleaf for templating if not using JSP.

3. **Generating the Project**:
   - Click on "Generate" to download the project zip file.

### Project Structure and Setup

1. **Unzipping and Importing into IntelliJ IDEA**:

   - Open IntelliJ IDEA, import the project by selecting the unzipped folder.

2. **Running the Application**:
   - Right-click on the main class and choose "Run" to start the embedded Tomcat server.
   - By default, Tomcat runs on port 8080.

### Accessing the Application

1. **Testing the Application**:
   - Open a browser and navigate to [http://localhost:8080](http://localhost:8080).
   - Initially, there won't be a mapped controller, so a 404 error might be displayed.

### Next Steps: Creating Controllers

1. **Adding a Controller**:

   - Create a new Java class to act as a controller.
   - Use annotations like `@Controller` and `@RequestMapping` to map URLs to controller methods.

2. **Returning Views**:
   - Create HTML or Thymeleaf templates in the `resources/templates` directory.
   - Controller methods can return the name of the template (without `.html` extension) to render it.

### Conclusion

Spring Boot provides an embedded Tomcat server and simplifies the setup of web applications using annotations and conventions. It's ideal for rapid development and prototyping. Next, we'll explore creating controllers to handle requests and generate dynamic content.

Stay tuned for the next video where we'll dive into creating controllers in Spring Boot!
