## Implementing Bcrypt Password Encryption

### Registration and Authentication with Bcrypt

1. **Problem Overview**:

   - Currently, passwords are stored and transmitted in plain text.
   - We need to encode passwords using Bcrypt for better security.

2. **New User Registration**:

   - When registering a new user (e.g., user ID 4, username: avni, password: a@123), the password is stored in plain text.
   - Implementing Bcrypt will encode the password before storing it.

3. **Updating Existing Users**:

   - Example: Update Navin's password to a new Bcrypt encoded password.
   - Generate a Bcrypt hash for the new password using an online tool or Bcrypt library.
   - Update the password in the database with the Bcrypt hash.

   ```sql
   UPDATE users SET password='$2a$12$SomeBcryptHash' WHERE id=3;
   ```

### Creating Bcrypt Encoder:

- Use the `BCryptPasswordEncoder` from Spring Security.
- Set the strength to 12 rounds for encoding.

```java
// UserService or UserController
private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set to 12 rounds
```

### Registering a New User:

- Encode the plain text password before saving the user.

```java
// Example in UserService
public User register(User user) {
    String encodedPassword = encoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    System.out.println("Encoded Password: " + encodedPassword); // For learning purposes
    return userRepository.save(user);
}
```

### Testing Registration:

- Use Postman to send a registration request.
- Verify the encoded password in the database.

### Final Steps:

- Ensure the encoding process is used during both registration and authentication.
- Verify the encoded passwords and authentication process in the application.

### Conclusion

- Implementing Bcrypt ensures that passwords are securely stored using irreversible hashing techniques, significantly enhancing application security by protecting user credentials from unauthorized access and data breaches.
