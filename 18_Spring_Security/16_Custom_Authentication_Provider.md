## Creating Custom Authentication Provider with Spring Security

### Introduction

In this section, we will create a custom authentication provider in Spring Security that connects with a PostgreSQL database for user authentication. We will configure a `DAOAuthenticationProvider` and a custom `UserDetailsService` to handle dynamic database connectivity.

### Implementing Custom Authentication Provider

1. **Create Authentication Provider Bean:**

   - Create a method to return an `AuthenticationProvider` bean:

     ```java
     @Configuration
     @EnableWebSecurity
     public class SecurityConfig extends WebSecurityConfigurerAdapter {

         @Autowired
         private UserDetailsService userDetailsService;

         @Bean
         public AuthenticationProvider authProvider() {
             DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
             provider.setUserDetailsService(userDetailsService);
             provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
             return provider;
         }

         // Other security configurations
     }
     ```

   - Explanation:
     - We configure a bean `authProvider` that returns a `DaoAuthenticationProvider`.
     - We set `userDetailsService` to handle user details retrieval.
     - `NoOpPasswordEncoder.getInstance()` disables password encoding for simplicity.

2. **Implement Custom UserDetailsService:**
   - Create a class that implements `UserDetailsService`:

     ```java
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

   - Explanation:
     - Implements `UserDetailsService` to fetch user details from the database using `UserRepository`.
     - Converts retrieved data into a `UserDetails` object.

### Conclusion

By following these steps, we have implemented a custom authentication provider in Spring Security. This provider connects with a PostgreSQL database through a custom `UserDetailsService` to authenticate users dynamically. This setup allows for flexible authentication handling with database-backed user details.
