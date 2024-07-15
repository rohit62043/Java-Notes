# JWT: JSON Web Token

## Introduction

- JWT stands for JSON Web Token.
- It is used for securely transmitting information between parties as a JSON object.

## Real-Life Example

- **Scenario**: Daily coffee routine.
  - You go to a cafe every day and pay $1 for coffee.
  - You propose a monthly membership for $20 to save money.
  - The cafe agrees, and you become a regular customer.

### Challenges with Recognition

- **Problem**: The cafe staff may change, and new staff may not recognize you.
- **Solution**:
  - The cafe keeps an entry in a book with your membership details.
  - You receive an ID (e.g., 102) to reference your membership.

### Scaling Issue

- **Problem**: The cafe has multiple branches in different cities.
  - Your membership details are not available in other branches.
- **Solution**:
  - Instead of a book entry, you receive a physical pass.
  - The pass states your membership and validity period.
  - This pass can be used at any branch.

### Verification

- **Problem**: Others may forge a similar pass.
- **Solution**:
  - The pass is signed by the manager or stamped by the company.
  - Digital signatures can be used for online passes.

## JWT in the IT World

- **Client-Server Interaction**:
  - Client requests a resource from the server.
  - Server needs to verify the user's identity.
- **Session Management**:
  - After login, the server issues a session ID (e.g., JSESSIONID) stored in cookies.
  - For each request, the session ID is used to maintain the user session.

### Scaling with Multiple Servers

- **Problem**: Managing sessions across multiple servers.
- **Solution**:
  - Servers share the same database or cache for session IDs.
  - Load balancers direct requests to the appropriate server.

## JWT Implementation

- **Token Concept**:
  - Instead of server-side sessions, the server issues a signed pass (JWT).
  - The client presents this pass for subsequent requests.
- **Security**:
  - The JWT is signed to prevent forgery.

### Benefits of JWT

- **Stateless Authentication**:
  - The server does not need to store session data.
  - Each JWT contains all necessary information, including user identity and expiration time.
- **Scalability**:
  - JWTs can be used across multiple servers without centralized session storage.

## Conclusion

- JWT provides a scalable and secure way to handle authentication.
- It works similarly to a physical pass with digital signatures to prevent misuse.

**Next Video**:

- We will explore the structure and implementation of JWTs.
