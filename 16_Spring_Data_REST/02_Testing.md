# Testing Spring Data REST Functionality

## Running the Application

Let's see if our setup works by running the application.

### 1. Start the Application

Navigate to the main application class and run it. Ensure that no other applications are using the same port.

### 2. Application Startup

Monitor the console for any errors during startup. You should see a message indicating that Tomcat has started successfully.

### 3. Accessing the API

Since we don't have custom controllers, we need to rely on the default URLs provided by Spring Data REST.

### 4. Using Postman

Open Postman to test the endpoints.

#### Get All Job Posts

Send a GET request to `/jobPosts`:

- URL: `http://localhost:8080/jobPosts`
- Expected Response: A list of all job posts.
  ```json
  [
    {
      "id": 1,
      "title": "Java Developer",
      "description": "Job description for Java Developer",
      "location": "Location for Java Developer",
      "_links": {
        "self": {
          "href": "http://localhost:8080/jobPosts/1"
        },
        "jobPost": {
          "href": "http://localhost:8080/jobPosts/1"
        }
      }
    },
    {
      "id": 2,
      "title": "Python Developer",
      "description": "Job description for Python Developer",
      "location": "Location for Python Developer",
      "_links": {
        "self": {
          "href": "http://localhost:8080/jobPosts/2"
        },
        "jobPost": {
          "href": "http://localhost:8080/jobPosts/2"
        }
      }
    }
    // ...more job posts
  ]
  ```

### Get a Specific Job Post

- Send a GET request to` /jobPosts/{id}:`

- URL: `http://localhost:8080/jobPosts/1`
- Expected Response: Details of the job post with ID 1.

```json
{
  "id": 1,
  "title": "Java Developer",
  "description": "Job description for Java Developer",
  "location": "Location for Java Developer",
  "_links": {
    "self": {
      "href": "http://localhost:8080/jobPosts/1"
    },
    "jobPost": {
      "href": "http://localhost:8080/jobPosts/1"
    }
  }
}
```

## 5. Hypermedia as the Engine of Application State (HATEOAS)

- Spring Data REST supports HATEOAS, which provides links to related resources in the response.

- Each job post includes links to itself and related resources.
  You can navigate to specific job posts using these links.

### 6. Next Steps

- In the next video, we'll explore how to perform addition, update, and deletion of job posts using the Spring Data REST endpoints.
