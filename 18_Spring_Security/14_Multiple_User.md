## Configuring Multiple Users in Spring Security

### Introduction

In this section, we will configure multiple users in Spring Security. Although the users will eventually come from a database, we will start by hardcoding the username and password values in the code.

### Customizing `UserDetailsService`

Spring Security uses `UserDetailsService` to check for user credentials. By default, it checks the application properties, but we can define our own `UserDetailsService`.

### Implementation

1. **Creating a Custom `UserDetailsService`:**

   - Define a Bean that returns a `UserDetailsService` object.
   - Spring Security will use this object to get user data.

2. **Hardcoding User Details:**
   - Use `InMemoryUserDetailsManager` to manage user details in memory.
   - Specify users and their details within this manager.

### Code Example

```java
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("navin")
                .password("n@123")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin@789")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
            .formLogin(withDefaults())
            .httpBasic(withDefaults())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
```

md
Copy code

## Configuring Multiple Users in Spring Security

### Introduction

In this section, we will configure multiple users in Spring Security. Although the users will eventually come from a database, we will start by hardcoding the username and password values in the code.

### Customizing `UserDetailsService`

Spring Security uses `UserDetailsService` to check for user credentials. By default, it checks the application properties, but we can define our own `UserDetailsService`.

### Implementation

1. **Creating a Custom `UserDetailsService`:**

   - Define a Bean that returns a `UserDetailsService` object.
   - Spring Security will use this object to get user data.

2. **Hardcoding User Details:**
   - Use `InMemoryUserDetailsManager` to manage user details in memory.
   - Specify users and their details within this manager.

### Code Example

```java
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("navin")
                .password("n@123")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin@789")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
            .formLogin(withDefaults())
            .httpBasic(withDefaults())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
```

## Explanation

### 1.Custom UserDetailsService:

- `@Bean public UserDetailsService userDetailsService()` creates and returns an `InMemoryUserDetailsManager` with hardcoded users.

### 2.User Details:

- `User.withDefaultPasswordEncoder()` is used to create users with encoded passwords. This is for demonstration purposes only and should not be used in production.

### 3.Security Configuration:

- Disabling CSRF protection.
- Ensuring all requests are authenticated.
- Enabling form login and basic authentication.
- Configuring the session to be stateless.
- Testing the Configuration

### 4.Accessing Secure Resources:

- Open the browser in incognito mode to ensure no session is cached.
- Access the URL localhost:8080.

### Expected Behavior:

- The browser should prompt for login with the specified username and password.
- Using incorrect credentials will fail, while correct credentials will succeed.

### Conclusion

By defining our own UserDetailsService, we can manage user details more flexibly. While the current implementation uses hardcoded values, the next step is to fetch user details from a database. This setup helps understand the flow and configuration before moving to database-backed user management.
