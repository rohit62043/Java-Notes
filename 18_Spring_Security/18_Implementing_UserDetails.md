## Implementing UserPrincipal for UserDetails

### Introduction

In this section, we'll create a `UserPrincipal` class that implements the `UserDetails` interface. This class will represent the current authenticated user in a Spring Security setup, providing essential user details for authentication and authorization.

### Creating UserPrincipal Class

1. **Create UserPrincipal Class:**
   - Create a new class `UserPrincipal` in the `model` package (or your designated package):

     ```java
     import org.springframework.security.core.GrantedAuthority;
     import org.springframework.security.core.authority.SimpleGrantedAuthority;
     import org.springframework.security.core.userdetails.UserDetails;
     import java.util.Collection;
     import java.util.Collections;

     public class UserPrincipal implements UserDetails {
         private User user;

         public UserPrincipal(User user) {
             this.user = user;
         }

         @Override
         public Collection<? extends GrantedAuthority> getAuthorities() {
             return Collections.singleton(new SimpleGrantedAuthority("USER"));
         }

         @Override
         public String getPassword() {
             return user.getPassword();
         }

         @Override
         public String getUsername() {
             return user.getUsername();
         }

         // Other methods like isEnabled, isAccountNonExpired, etc., can be implemented as needed.
         // For demonstration, we are assuming all users are enabled and non-expired.

         @Override
         public boolean isAccountNonExpired() {
             return true;
         }

         @Override
         public boolean isAccountNonLocked() {
             return true;
         }

         @Override
         public boolean isCredentialsNonExpired() {
             return true;
         }
     }
     ```

   - Explanation:
     - `UserPrincipal` implements `UserDetails` and accepts a `User` object in its constructor.
     - Methods like `getAuthorities`, `getPassword`, and `getUsername` retrieve user details from the `User` object.
     - For simplicity, we assume all accounts are enabled and non-expiring. Real implementations should handle these checks appropriately.

### Conclusion

The `UserPrincipal` class now serves as the representation of an authenticated user in Spring Security. It provides necessary user details required for authentication and authorization purposes within your application. This setup, coupled with the `UserRepo` and `User` entity, forms the foundation for integrating database-backed user authentication into your Spring Security configuration.

Next steps will involve configuring Spring Security to use `UserDetailsService` with `UserRepo` to authenticate users based on stored credentials. This will be covered in the following video tutorial.

If you have any questions or need further clarification, feel free to ask!
