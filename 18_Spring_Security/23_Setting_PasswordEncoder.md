## Implementing Bcrypt for Authentication

### Overview

Now that we've implemented Bcrypt for password encoding during registration, we'll extend this implementation to authentication. This ensures that passwords stored in the database are secure, and only encoded passwords are used for authentication.

### Authentication with Bcrypt

1. **Review of Registration**:

   - We have successfully encoded passwords during registration.
   - Passwords are stored in the database in an encoded format.

2. **Enhancing SecurityConfig**:

   - Replace the `NoOpPasswordEncoder` with `BCryptPasswordEncoder` in the `SecurityConfig`.

   ```java
   @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;


        @Bean
        public AuthenticationProvider authProvider() {
            DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsService);
            provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
            return provider;
        }

   }
   ```

````
### 3.Restarting the Application:

- Restart the Spring Boot application to apply the changes.
### 4.Testing Authentication:

- Use Postman to test authentication with different users.

### 5.Testing with New and Existing Users:

- New User (e.g., Avni):
- Use the encoded password for authentication.
- Request example:
```plaintext
Username: avni
Password: a@123
````

- Expected result: Authentication successful.
- Existing Users with Plain Text Passwords:
- Attempt authentication with plain text passwords (e.g., harsh, h@123).
- Expected result: Authentication fails since the passwords are not encoded.

### 6.Verifying Authentication:

- For Avni:

```plaintext
Username: avni
Password: a@123
```

- Result: Authentication should work as the password is encoded.
- For Harsh:

```plaintext
Username: harsh
Password: h@123
```

- Result: Authentication fails due to plain text password.

### Summary

- We have integrated Bcrypt for encoding passwords during registration and authentication.
- The SecurityConfig was updated to use BCryptPasswordEncoder.
- authentication while plain text passwords do not.
- Ensure the strength parameter in the BCryptPasswordEncoder remains consistent across registration and authentication.
- By following these steps, we've enhanced the security of our application's password handling, ensuring that passwords are stored in an encoded format and authenticated securely.
