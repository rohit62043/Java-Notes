# Understanding HTTP Methods

## Introduction to HTTP

- **HTTP** stands for **Hypertext Transfer Protocol**.
- HTTP is the protocol used for transferring data over the web.

## Common HTTP Methods

### GET

- **GET** is used to **retrieve** data from the server.
- Example use case: Fetching job details.
- In Spring Boot: `@GetMapping`

### POST

- **POST** is used to **create** a new resource on the server.
- Example use case: Adding a new job.
- In Spring Boot: `@PostMapping`
- Can also be used for sending data to update resources, though not as commonly.

### PUT

- **PUT** is used to **update** an existing resource on the server.
- Example use case: Updating job details.
- In Spring Boot: `@PutMapping`

### DELETE

- **DELETE** is used to **remove** a resource from the server.
- Example use case: Deleting a job.
- In Spring Boot: `@DeleteMapping`

## Using HTTP Methods in REST APIs

- URLs in REST APIs use nouns, not verbs.
  - Example: `/job` is used for adding, retrieving, updating, and deleting jobs.
- The HTTP method determines the action:
  - **POST** to create a job: `/job`
  - **GET** to retrieve a job: `/job`
  - **PUT** to update a job: `/job`
  - **DELETE** to delete a job: `/job`

## Client-Side Implementation

- In browsers, a URL defaults to a **GET** request.
- For **POST** requests, forms are used in HTML.
- For testing other methods (POST, PUT, DELETE), use tools like **Postman**.
- Postman allows you to test APIs by specifying the HTTP method and URL.

## Next Steps

- Explore how to use Postman for testing different HTTP methods.
- Build the backend to handle these methods using Spring Boot.
