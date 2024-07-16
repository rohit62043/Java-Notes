# Authentication Flow in Spring Security

In a Spring Boot application, when a request is made to a secured endpoint, it goes through a series of security checks to ensure authentication and authorization. Here's an overview of the process, focusing on the authentication manager and the DaoAuthenticationProvider.

## Authentication Flow

1. **Request Interception**:

   - When a request is made to a secured endpoint, it is intercepted by the Spring Security filter chain.

2. **Authentication Manager**:

   - The intercepted request is then passed to the **Authentication Manager**. The Authentication Manager coordinates the authentication process.

3. **Authentication Provider**:
   - The Authentication Manager delegates the authentication process to one or more **Authentication Providers**. Each Authentication Provider handles a specific type of authentication.
   - In our case, we use the **DaoAuthenticationProvider**.

### DaoAuthenticationProvider

The DaoAuthenticationProvider is a built-in implementation of an Authentication Provider that uses a **UserDetailsService** to retrieve user information from a database. Here's how it works:

1. **Retrieving User Details**:

   - The DaoAuthenticationProvider calls the `UserDetailsService` to load user details by username.
   - The `UserDetailsService` interacts with the database to fetch user details.

2. **Password Verification**:

   - The DaoAuthenticationProvider compares the provided password with the stored password. Typically, the stored password is hashed using an encoder such as BCrypt.

3. **Successful Authentication**:

   - If the user details are found and the password matches, the user is authenticated.
   - An `Authentication` object is created and returned, containing the user’s authorities (roles and permissions).

4. **Failure Handling**:
   - If the user details are not found or the password does not match, authentication fails, and an exception is thrown.

### Diagram of the Flow

```plaintext
Request -> Authentication Manager -> DaoAuthenticationProvider -> UserDetailsService -> Database
```
