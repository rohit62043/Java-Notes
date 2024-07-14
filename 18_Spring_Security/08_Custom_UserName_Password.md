## Configuring Custom Username and Password in Spring Security

### Introduction

In this section, we'll set up our own username and password for authentication in our Spring Security application.

### Setting Custom Credentials

1. **Problem Statement:**

   - Currently, the application generates a new password each time it's run, which can be inconvenient.

2. **Solution:**

   - Modify the application properties (`application.properties`) to define custom credentials:
     - Set `spring.security.user.name` to `telusko` (custom username).
     - Set `spring.security.user.password` to `1234` (custom password, for demonstration purposes).

3. **Implementation:**

   - Save the changes in `application.properties`.
   - Restart the application for the changes to take effect.

4. **Logging In:**
   - Access the application and log in using the custom credentials:
     - Username: `telusko`
     - Password: `1234`
   - Navigate to `/hello` and `/about` endpoints to confirm access.

### Drawbacks and Considerations

- **Security Concerns:**

  - Hard-coding credentials in the properties file is not recommended for production environments.
  - Storing passwords in plain text poses security risks.

- **Single User Credentials:**
  - Using a single username and password for the entire application is not scalable or secure for multi-user environments.
  - In real-world applications, user credentials are typically managed in a database with secure hashing and encryption.

### Future Considerations

- **Handling Authentication in REST APIs:**
  - Discuss transitioning from form-based login to authentication via REST API using tools like Postman or React.

### Conclusion

While configuring custom username and password in `application.properties` provides a quick setup for learning purposes, it's essential to implement secure authentication mechanisms in production environments.

Stay tuned for exploring REST API authentication in the upcoming video!
