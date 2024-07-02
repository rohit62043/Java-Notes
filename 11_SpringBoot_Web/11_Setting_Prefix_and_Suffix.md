### Configuring ViewResolver in Spring MVC

To resolve the issue of locating JSP views in a different folder and removing the `.jsp` extension, we can configure a `ViewResolver` in `application.properties`.

1. **Configure ViewResolver in `application.properties`**:

```properties
# Configure ViewResolver for Spring MVC
spring.mvc.view.prefix=/views/
spring.mvc.view.suffix=.jsp
```

## Explanation:

- `spring.mvc.view.prefix`: Specifies the prefix where Spring MVC should look for view files. In this case, views are located in the /views/ folder relative to the application's root.
- `spring.mvc.view.suffix`: Specifies the suffix (extension) for the view files. Here, it's set to .jsp.

## Testing:

- Ensure these properties are set in your application.properties.
- Restart your Spring Boot application to apply the new configuration.
- Access the homepage (localhost:8080) in your browser.
- Enter values in the form and submit to verify that the result is displayed correctly without specifying the .jsp extension and from the views folder.

## Handling CSS and Static Resources:

- If CSS and static resources are not loading correctly after moving views, ensure that your folder structure and paths are correctly configured.
- Typically, static resources are served from the `src/main/resources/static` folder in a Spring Boot project. Ensure CSS files are accessible from the correct path relative to the root.

By configuring the ViewResolver with prefix and suffix, you enhance flexibility in managing views and ease maintenance when switching view technologies or relocating view files within your Spring MVC application.
