# Connecting React Application with Backend

## Introduction

This guide will walk you through connecting a React application to a backend server. We will address common issues such as Cross-Origin Resource Sharing (CORS) and ensure data is fetched correctly.

## Steps to Connect React Application with Backend

### 1. Changing the Backend URL

- Initially, the React application uses data from a mock database (`db.json`).
- To fetch data from the actual backend, change the URL in the React application to point to the backend server.
- Save the changes.

### 2. Restarting the Server

- After changing the URL, restart the React server to apply the changes:
  ```bash
  npm start
  ```

### 3. Handling Network Errors

- If you encounter a Network Error, it is likely due to CORS issues.
- CORS issues arise because the frontend and backend are on different origins.

### 4. Solving CORS Issues

- To allow the frontend to communicate with the backend, you need to configure the backend server to accept requests from the frontend origin.

### 5. Adding Cross-Origin Annotation

- In your backend controller, add the CrossOrigin annotation:

```java
@CrossOrigin(origins = "http://localhost:3000")
```

- Replace http://localhost:3000 with the URL of your frontend application.
- This annotation allows requests from the specified origin.

### 6. Refreshing the Application

- After adding the CrossOrigin annotation, refresh or relaunch the React application.
- Verify that the React application is fetching data from the backend server.
- If successful, you should see the data from the backend in your React application.

### 7. Next Steps

- Once the connection is established and data is fetched correctly, you can proceed to add more features.
- For example, adding a new post or creating a new job post.

### Conclusion

- By following these steps, you can successfully connect your React application to a backend server.
- The key issue resolved here is the Cross-Origin request, handled by adding the CrossOrigin annotation in the backend controller.

### Upcoming

- In the next video, we will learn how to add a post or create a new job post.
