## Introduction to Cryptography

### Importance of Cryptography

- **Data Transmission**: Information sent between servers or from client to server over the internet can be intercepted and modified.
- **Man-in-the-Middle Attack**: An attacker can view and alter data during transmission.

### Cryptography Basics

- **Encryption and Decryption**:
  - **Encryption**: Converts normal text to cipher text using a key.
  - **Decryption**: Converts cipher text back to normal text using a key.

### Key Types

- **Symmetric Key Cryptography**:

  - **Same Key for Both Parties**: Both sender and receiver use the same key.
  - **Key Sharing**: The key must be shared securely before communication.
  - **Challenges**:
    - Key sharing needs a secure method.
    - Managing multiple keys in a network with many members.

- **Asymmetric Key Cryptography**:
  - **Two Keys**: Public key (known by everyone) and private key (known only by the owner).
  - **Opposite Keys for Encryption and Decryption**:
    - Encrypt with the public key, decrypt with the private key.
    - Encrypt with the private key, decrypt with the public key.

### Symmetric Key Cryptography

- **Algorithm Examples**: AES, DES.
- **Usage**:
  - Faster encryption and decryption.
  - Large key sizes for enhanced security.
- **Key Management Issue**:
  - Every unique communication pair needs a different key.

### Asymmetric Key Cryptography

- **Encryption Process**:
  - Sender uses the recipient's public key to encrypt data.
  - Recipient uses their private key to decrypt data.
- **Algorithm Examples**: RSA, ECC.
- **Benefits**:
  - No need to share private keys.
  - Public keys can be shared openly without security risks.

### Example Scenario

- **Secure Communication**:
  - Person A sends an encrypted message to Person B using B's public key.
  - B decrypts the message using their private key.
  - If an attacker (Person C) intercepts the message, they cannot decrypt it without B's private key.

### Problem with Identity Verification

- **Scenario**:
  - Attacker (C) intercepts and modifies a message, then re-encrypts it using B's public key.
  - B decrypts the message, but cannot verify if it was sent by A or C.
- **Solution**: Digital signatures, discussed in the next video.

### Summary

- **Cryptography** is essential for securing data transmission over the internet.
- **Symmetric Key Cryptography** uses the same key for both encryption and decryption, requiring secure key sharing.
- **Asymmetric Key Cryptography** uses a pair of public and private keys, enhancing security and eliminating the need for private key sharing.
- **Digital Signatures** will be introduced to ensure the authenticity of the sender in the next video.
