## Connecting to Database in Spring Security

### Introduction

In this section, we will connect Spring Security to a PostgreSQL database to fetch user details. Although any SQL or NoSQL database can be used, we will focus on PostgreSQL. The following steps outline the process of setting up the database and configuring Spring Security to use it.

### Setting Up PostgreSQL

1. **Install PostgreSQL:**

   - Ensure PostgreSQL is installed on your machine.
   - Default credentials: `username: postgres`, `password: 0000`.

2. **Create Database and Table:**

   - Open PostgreSQL and create a database named `telusko`.
   - Create a table `users` with the following schema:
     ```sql
     CREATE TABLE users (
         id INTEGER PRIMARY KEY,
         username TEXT,
         password TEXT
     );
     ```

3. **Insert Sample Data:**
   - Insert some sample data into the `users` table:
     ```sql
     INSERT INTO users (id, username, password) VALUES
     (1, 'Navin1', 'n@789'),
     (2, 'Harsh', 'h@123');
     ```

### Configuring Spring Application

1. **Application Properties:**

   - Configure the database connection in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/telusko
     spring.datasource.username=postgres
     spring.datasource.password=0000
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

2. **Dependencies:**
   - Add dependencies for PostgreSQL and JPA in `pom.xml`:
     ```xml
     <dependencies>
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-data-jpa</artifactId>
         </dependency>
         <dependency>
             <groupId>org.postgresql</groupId>
             <artifactId>postgresql</artifactId>
         </dependency>
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-security</artifactId>
         </dependency>
     </dependencies>
     ```

### Implementing UserDetailsService with Database

1. **Entity Class:**

   - Create an entity class for the `users` table:

     ```java
     package com.example.model;

     import javax.persistence.Entity;
     import javax.persistence.Id;

     @Entity
     public class User {
         @Id
         private Integer id;
         private String username;
         private String password;

         // Getters and setters
     }
     ```

2. **Repository Interface:**

   - Create a repository interface for the `User` entity:

     ```java
     package com.example.repository;

     import org.springframework.data.jpa.repository.JpaRepository;
     import com.example.model.User;

     public interface UserRepository extends JpaRepository<User, Integer> {
         User findByUsername(String username);
     }
     ```

3. **Custom UserDetailsService:**

   - Implement a custom `UserDetailsService` to fetch user details from the database:

     ```java
     package com.example.service;

     import com.example.model.User;
     import com.example.repository.UserRepository;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.security.core.userdetails.UserDetails;
     import org.springframework.security.core.userdetails.UserDetailsService;
     import org.springframework.security.core.userdetails.UsernameNotFoundException;
     import org.springframework.security.core.userdetails.User;
     import org.springframework.stereotype.Service;

     @Service
     public class CustomUserDetailsService implements UserDetailsService {

         @Autowired
         private UserRepository userRepository;

         @Override
         public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             User user = userRepository.findByUsername(username);
             if (user == null) {
                 throw new UsernameNotFoundException("User not found");
             }
             return User.builder()
                         .username(user.getUsername())
                         .password(user.getPassword())
                         .roles("USER") // Adjust roles as needed
                         .build();
         }
     }
     ```

4. **Security Configuration:**

   - Configure Spring Security to use the custom `UserDetailsService`:

     ```java
     package com.example.config;

     import com.example.service.CustomUserDetailsService;
     import org.springframework.context.annotation.Bean;
     import org.springframework.context.annotation.Configuration;
     import org.springframework.security.config.annotation.web.builders.HttpSecurity;
     import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
     import org.springframework.security.core.userdetails.UserDetailsService;
     import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
     import org.springframework.security.crypto.password.PasswordEncoder;
     import org.springframework.security.web.SecurityFilterChain;

     @Configuration
     @EnableWebSecurity
     public class SecurityConfig {

         @Bean
         public UserDetailsService userDetailsService() {
             return new CustomUserDetailsService();
         }

         @Bean
         public PasswordEncoder passwordEncoder() {
             return new BCryptPasswordEncoder();
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

### Conclusion

By following these steps, we have configured Spring Security to fetch user details from a PostgreSQL database. This setup includes creating a database and table, inserting sample data, configuring the application properties, and implementing the necessary classes and interfaces to integrate with the database.
