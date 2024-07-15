# What is JWT?

## Definition

- **JWT**: JSON Web Token.
- **Standard**: Open, industry-standard, defined in RFC 7519.
- **Purpose**: Securely transfer data between two parties.

## Token Formats

- Tokens can be in various formats like XML or JSON.
- XML tends to be lengthy and complex to encrypt.
- JSON is more compact but can still be lengthy.
- JWT provides an efficient format for secure data transfer.

## Structure of JWT

- JWT is encoded and appears as an alphanumeric string.
- JWT has three sections:
  1. **Header**: Contains the type of token and the signing algorithm.
  2. **Payload**: Contains the data being transferred.
  3. **Signature**: Ensures the token has not been altered.

### Header

- Contains:
  - Algorithm used (e.g., HS256 for HMACSHA-256).
  - Type of token (JWT).

### Payload

- Contains:
  - Subject (user identifier).
  - Name.
  - Issuance time.
  - Expiration time (optional).
- Additional data can be included but should be kept minimal.

### Signature

- Created using the algorithm specified in the header.
- Ensures token integrity and authenticity.
- Uses:
  - Symmetric keys (e.g., HMACSHA-256).
  - Asymmetric keys (e.g., RSA).

## How JWT Works

1. **Login Process**:
   - Client sends username and password to the server.
   - Server verifies credentials.
   - Server issues a JWT to the client.
2. **Using the Token**:
   - Client stores the JWT.
   - For each subsequent request, the client includes the JWT.
   - Server verifies the JWT before processing the request.

## Security Considerations

- JWT is signed, not encrypted by default.
- The payload can be viewed but not modified without invalidating the signature.
- Do not include sensitive information (e.g., passwords, personal identifiers) in the payload.

## Implementing JWT

- **Step 1**: Client sends login credentials to the server.
- **Step 2**: Server verifies credentials and issues a JWT.
- **Step 3**: Client stores the JWT.
- **Step 4**: Client sends the JWT with each subsequent request.
- **Step 5**: Server verifies the JWT and processes the request if valid.

### Practical Implementation

1. **Create JWT**: Server creates a JWT upon successful login.
2. **Send JWT**: Server sends the JWT to the client.
3. **Verify JWT**: For each request, the server verifies the JWT.

### Tools and Libraries

- Use libraries to handle JWT creation and verification.
- Libraries simplify the implementation process.

## Conclusion

- JWT provides a secure, scalable way to handle authentication.
- The next steps involve practical implementation with code examples.
