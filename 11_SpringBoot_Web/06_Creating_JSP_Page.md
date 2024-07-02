# Setting Up Homepage with JSP in Spring Boot

## Integrating JSP Support

- By default, Spring Boot does not support JSP pages out of the box. We need to add the Tomcat Jasper dependency to enable JSP support.

- Add the Tomcat Jasper dependency to your pom.xml:

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <version>${tomcat.version}</version>
</dependency>
```

## Creating a Homepage with JSP

When accessing `localhost:8080`, you're currently seeing a "404" error because there's no homepage configured yet. Let's set up an `index.jsp` as the homepage.

### Steps to Configure `index.jsp`

1. **Create `index.jsp`**:

   - In your project directory, create a new directory named `src/main/webapp`.
   - Inside `webapp`, create `index.jsp` with the following content:
     ```jsp
     <%@ page language="java" %>
     <html>
     <body>
         <h2>Hello World!</h2>
     </body>
     </html>
     ```
   - Save the file.

2. **Understanding JSP Configuration**:
   - The `<%@ page language="java" %>` directive tells Spring that this is a JSP page with Java code.
   - Basic HTML structure (`<html>`, `<body>`, `<h2>`) is used to display "Hello World!".

### Testing `index.jsp`

1. **Run Your Application**:

   - Start your Spring Boot application.
   - Ensure the application is running on `localhost:8080`.

2. **Access `index.jsp`**:
   - Open a web browser and go to [http://localhost:8080](http://localhost:8080).
   - Refresh the page to see "Hello World!" displayed.

### Understanding Controller in Spring Boot

1. **Controller Overview**:

   - In Spring Boot, controllers handle incoming requests and return appropriate responses.
   - They map specific URLs to methods that handle those requests.

2. **Creating a Controller**:
   - In the next video, we'll explore how to create a controller in Spring Boot.
   - Controllers are essential for routing requests and rendering views, such as our `index.jsp`.

### Conclusion

Setting up a basic homepage using `index.jsp` in Spring Boot involves creating a JSP file in the `src/main/webapp` directory and configuring its content. In the next steps, we'll delve into creating a controller to manage URLs and render views effectively.

Stay tuned for the next video where we'll cover creating controllers in Spring Boot!
