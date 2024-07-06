# Fetching Specific Job Post by ID

## Introduction

This guide covers how to fetch a specific job post by its ID from the backend server using a REST API. We'll use a `Postman` query to demonstrate the process and handle potential issues.

## Steps to Fetch a Specific Job Post

### 1. Current Setup

- When you request `localhost:8080/jobpost`, you get all job posts.
- Example: Using Postman, sending a GET request to `localhost:8080/jobpost` returns all job posts.

### 2. Fetching a Specific Job Post

- To fetch a specific job post, modify the URL to include the job post ID.
- Example: To fetch job post with ID `3`, use `localhost:8080/jobpost/3`.

### 3. Handling 404 Not Found Error

- If the endpoint `localhost:8080/jobpost/3` returns a 404 error, it means the path is not found.
- The error occurs because the controller does not have a method to handle fetching a specific job post by ID.

### 4. Implementing the Controller Method

- Create a new controller method to handle fetching a job post by ID.
- Example:
  ```java
  @GetMapping("/jobpost/{postId}")
  public JobPost getJob(@PathVariable int postId) {
      return service.getJob(postId);
  }
  ```

### 5. Service Method

- In the service class, create a method to get a job post by ID.
- Example:

```java
public JobPost getJob(int postId) {
    return repo.getJob(postId);
}
```

### 6. Repository Method

- In the repository class, create a method to fetch a job post by ID.
- Example:

```java
public JobPost getJob(int postId) {
    for (JobPost job : jobs) {
        if (job.getPostId() == postId) {
            return job;
        }
    }
    return null;
}
```

### 7. Using Path Variables

- Use @PathVariable annotation to capture the ID from the URL.
- Example:

```java
@GetMapping("/jobpost/{postId}")
public JobPost getJob(@PathVariable("postId") int postId) {
    return service.getJob(postId);
}
```

### 8. Testing with Postman

- Relaunch the application and use Postman to test the endpoint.
- Example queries:
  - localhost:8080/jobpost/3 should return the job post with ID 3.
  - localhost:8080/jobpost/5 should return the job post with ID 5.
  - localhost:8080/jobpost/10 (if ID 10 does not exist) should return null or a 404 error.

## Conclusion

- By adding a controller method, service method, and repository method, we can fetch specific job posts by ID.
- Use @PathVariable to capture and handle dynamic path parameters in the URL.

## Next Steps

- In the next video, we will discuss how to send data to the server, as we have only fetched data so far.
