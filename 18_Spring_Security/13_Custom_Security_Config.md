## Custom Security Configuration in Spring Security

### Introduction

In this section, we'll explore how to create a custom security configuration in Spring Security by defining a configuration class and disabling the CSRF token.

### Steps to Disable CSRF Token

1. **Default Configuration:**

   - By default, Spring Security provides a set of configurations, including CSRF protection, login forms, and session management.
   - The only change we've made so far is specifying a custom username and password.

2. **Creating a Custom Configuration Class:**

   - To disable the CSRF token, we need to define our own security configuration.
   - Create a configuration class named `SecurityConfig`.

3. **Annotate the Configuration Class:**

   - Use `@Configuration` to mark the class as a configuration class.
   - Use `@EnableWebSecurity` to enable web security in the application.

4. **Define a Security Filter Chain:**

   - In Spring 6, the security configuration involves returning an object of `SecurityFilterChain`.
   - Create a method that returns a `SecurityFilterChain` object and annotate it with `@Bean`.

5. **Configure HTTP Security:**

   - Use the `HttpSecurity` object to define custom security configurations.
   - Call `http.build()` to return the `SecurityFilterChain` object.

6. **Handling Exceptions:**
   - The `http.build()` method might throw an exception, so add `throws Exception` to the method signature.

### Implementation

```java
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.csrf(csrf -> csrf.disable())  // Disable CSRF protection
            .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())  // Authenticate all requests
            .formLogin(Customizer.withDefaults())  // Enable form login with default settings
            .httpBasic(Customizer.withDefaults())  // Enable basic authentication with default settings
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));  // Make session stateless

        return http.build();
    }
}
```

### Disabling CSRF:

- `http.csrf(csrf -> csrf.disable())` disables CSRF protection.

### Authorizing Requests:

- `http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated())` ensures that all requests are authenticated.

### Form Login and Basic Authentication:

- `http.formLogin(Customizer.withDefaults())` enables form login with default settings.
- `http.httpBasic(Customizer.withDefaults())` enables basic authentication with default settings.

### Session Management:

- `http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))` configures the session to be stateless, meaning a new session is created for each request.

## Testing the Configuration

### Accessing Secure Resources:

- Open the browser in incognito mode to ensure no session is cached.
- Access the URL localhost:8080/hello.

### Expected Behavior:

- The browser should prompt for a login form since CSRF protection is disabled and custom security settings are applied.
- Using Postman, sending requests should work without requiring a CSRF token, and each request should create a new session.

### Conclusion

The Lambda approach offers a concise way to configure Spring Security settings. By disabling CSRF protection, enabling form login and basic authentication, and making the session stateless, we ensure secure and efficient handling of requests. In the next section, we'll explore the Imperative approach for a deeper understanding of these configurations.
