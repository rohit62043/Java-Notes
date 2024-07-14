## Creating User Repository and User Entity for Authentication

### Introduction

In this section, we will create a `UserRepo` interface using Spring Data JPA and define a `User` entity class. These components will enable us to interact with a PostgreSQL database for user authentication within a Spring Security setup.

### Implementing UserRepo Interface

1. **Create UserRepo Interface:**

   - Define an interface `UserRepo` that extends `JpaRepository` to manage user data:

     ```java
     import org.springframework.data.jpa.repository.JpaRepository;
     import org.springframework.stereotype.Repository;

     @Repository
     public interface UserRepo extends JpaRepository<User, Integer> {
         User findByUsername(String username);
     }
     ```

   - Explanation:
     - `UserRepo` extends `JpaRepository` and specifies `User` as the entity type and `Integer` as the primary key type.
     - Added a method `findByUsername` to query users by username.

### Implementing User Entity

2. **Create User Entity Class:**

   - Define a `User` entity class with necessary fields mapped to database columns:

     ```java
     import lombok.Data;
     import javax.persistence.*;

     @Entity
     @Table(name = "users")
     @Data
     public class User {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private int id;

         @Column(unique = true, nullable = false)
         private String username;

         @Column(nullable = false)
         private String password;
     }
     ```

   - Explanation:
     - Annotated `User` class with `@Entity` and `@Table` to map to the `users` table in the database.
     - Defined fields for `id`, `username`, and `password` with appropriate annotations (`@Id`, `@GeneratedValue`, `@Column`).

### UserDetailsService

```Java
package com.telusko.springsecdemo.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private User user;

	public UserPrincipal(User user) {
this.user=user;
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

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}

}
```

### Conclusion

With these implementations, we have set up the `UserRepo` interface to manage database operations for users using Spring Data JPA. Additionally, the `User` entity class provides a representation of user data stored in the PostgreSQL database. These components are essential for integrating database-backed user authentication into our Spring Security configuration.
