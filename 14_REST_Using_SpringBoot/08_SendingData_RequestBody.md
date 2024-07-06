# Sending Data to the Server with POST Request

## Introduction

This guide demonstrates how to send data to the server using a POST request. We will utilize Postman to send data and validate the functionality.

## Steps to Send Data to the Server

### 1. Current Setup

- We have methods to fetch and add job posts in the repository (`addJob` method).
- We need to create a controller method to handle adding a new job post.

### 2. Creating the Controller Method

- Add a new method in the controller to handle POST requests.
- Example:
  ```java
  @PostMapping("/jobPost")
  public JobPost addJob(@RequestBody JobPost jobPost) {
      service.addJob(jobPost);
      return jobPost;
  }
  ```
- Annotations:
  - **_@PostMapping_**: Indicates that this method handles POST requests.
  - **_@RequestBody_**: Binds the incoming JSON data to the JobPost object.

### 3. Service Method

- Ensure the service class has a method to add a job post.
- Example:

```java
public void addJob(JobPost jobPost) {
    repo.addJob(jobPost);
}
```

### 4. Repository Method

- Ensure the repository class has a method to add a job post.
- Example:

```java
public void addJob(JobPost jobPost) {
    jobs.add(jobPost);
}
```

### 5. Testing with Postman

- Launch the application and open Postman.
- Fetch All Records:
  - URL: http://localhost:8080/jobPost
- Method: GET
  - Verify the response contains all job posts.
  - Send Data:
  - URL: http://localhost:8080/jobPost
- Method: POST
  - Body:
  - Select raw and JSON.
  - Example JSON:
  - json
  ```json
  {
    "postId": 6,
    "title": "iOS Developer",
    "description": "Experience in mobile development for iOS",
    "experience": "2 years",
    "location": "Remote"
  }
  ```
  - Click Send and verify a 200 OK response.

### 6. Verifying Data Addition

- Fetch all records again to ensure the new job post is added.
- Example:
- Send a GET request to http://localhost:8080/jobPost and verify the new job post with ID 6 is in the response.

### 7. Additional Improvements

- Return Added Job Post:
- Modify the controller method to return the added job post.
- Example:

```java
@PostMapping("/jobPost")
public JobPost addJob(@RequestBody JobPost jobPost) {
    service.addJob(jobPost);
    return jobPost;
}
```

- Fetch and Return the Added Job Post:
- To confirm the data is stored, fetch and return the added job post.
- Example:

```java
@PostMapping("/jobPost")
public JobPost addJob(@RequestBody JobPost jobPost) {
    service.addJob(jobPost);
    return service.getJob(jobPost.getPostId());
}
```

### 8. Testing the Changes

- Relaunch the application.
- Use Postman to send a POST request with new job post data.
- Verify the response includes the added job post details.

## Conclusion

- We successfully created a method to handle POST requests for adding job posts.
- We tested the functionality using Postman.
- We ensured the data is stored and can be retrieved as needed.

## Next Steps

- In the next tutorial, we will discuss how to connect with a database for persistent storage of job posts.
