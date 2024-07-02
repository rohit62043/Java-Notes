# Setting Up Embedded Tomcat with Servlets

## Introduction to Embedded Tomcat

Embedded Tomcat allows you to integrate Tomcat directly within your Java project, simplifying deployment and development processes. This setup negates the need for external Tomcat installations, making it convenient for development and testing purposes.

### Setting Up a Maven Project

1. **Create a Maven Project**:

   - Open your IDE and create a new Maven project.
   - Choose appropriate project details (e.g., group ID, artifact ID).

2. **Adding Dependencies**:

   - Open your `pom.xml` file and add the following dependencies:
     ```xml
     <dependencies>
         <!-- Servlet API -->
         <dependency>
             <groupId>javax.servlet</groupId>
             <artifactId>javax.servlet-api</artifactId>
             <version>4.0.1</version>
             <scope>provided</scope>
         </dependency>
         <!-- Embedded Tomcat -->
         <dependency>
             <groupId>org.apache.tomcat.embed</groupId>
             <artifactId>tomcat-embed-core</artifactId>
             <version>8.5.96</version>
         </dependency>
     </dependencies>
     ```
   - Save the `pom.xml` file and reload Maven dependencies.

3. **Understanding Dependencies**:
   - **Servlet API**: Provides servlet-related classes and interfaces.
   - **Embedded Tomcat**: Integrates Tomcat server within your application.

### Writing Your First Servlet

Now, let's proceed to create a simple servlet within your Maven project.

1. **Create a Servlet Class**:

   - Create a new Java class that extends `HttpServlet`.
   - Implement the `doGet()` method to handle HTTP GET requests.
   - Example:

     ```java
     import javax.servlet.ServletException;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;
     import java.io.IOException;

     public class HelloServlet extends HttpServlet {
         @Override
         protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             resp.getWriter().println("Hello, Servlet!");
         }
     }
     ```

2. **Configure Servlet Mapping**:
   - Define servlet mapping in `web.xml` (older approach) or use annotations (modern approach).
   - Example using annotations:

     ```java
     import javax.servlet.annotation.WebServlet;

     @WebServlet("/hello")
     public class HelloServlet extends HttpServlet {
         // doGet method implementation
     }
     ```

### Running Your Embedded Tomcat

1. **Run Your Application**:

   - Configure your IDE to run the main application class that initializes embedded Tomcat.
   - Example of initializing embedded Tomcat in a main class:

     ```java
     import org.apache.catalina.startup.Tomcat;

     public class EmbeddedTomcatApp {
         public static void main(String[] args) throws Exception {
             Tomcat tomcat = new Tomcat();
             tomcat.setPort(8080); // Set your desired port

             // Add your servlet to Tomcat
             tomcat.addServlet("", "helloServlet", new HelloServlet());
             tomcat.addServletMappingDecoded("/hello", "helloServlet");

             // Start Tomcat
             tomcat.start();
             tomcat.getServer().await();
         }
     }
     ```

2. **Access Your Servlet**:
   - Open a web browser and navigate to `http://localhost:8080/hello` to see your servlet response.

### Conclusion

Setting up embedded Tomcat with servlets allows you to develop and test web applications locally without external server dependencies. This approach streamlines development by integrating server capabilities directly into your Java project. In the next steps, we'll explore more advanced concepts, transitioning towards Spring MVC for scalable web application development.
