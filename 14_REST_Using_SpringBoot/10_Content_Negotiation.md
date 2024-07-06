# Content Negotiation in Spring Boot

## Introduction

In this video, we will discuss content negotiation in Spring Boot. Content negotiation allows clients to specify the format in which they want to receive data, such as JSON or XML.

## Sending Requests with Postman

When sending requests via Postman, we typically receive data in JSON format by default. However, we can also request data in XML format.

### Setting Headers in Postman

To request XML data:

1. Go to the **Headers** section in Postman.
2. Add a header with the key `Accept` and the value `application/xml`.

### Handling Unsupported Media Types

If the server does not support XML, you will receive a `406 Not Acceptable` error. This is because the default Jackson library only supports JSON. To support XML, an additional library is required.

## Adding XML Support

To enable XML support:

1. Add the Jackson XML library to your project.
2. Open `pom.xml`.
3. Search for `jackson-dataformat-xml` in the MVN Repository.
4. Add the dependency to your `pom.xml`.

Example dependency:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
    <version>2.15.3</version>
</dependency>
```

### Restarting the Application

- After adding the library, restart your application. You should now be able to request XML data successfully.

### Specifying Response Formats

- To restrict the format of the response, use the produces attribute in your controller methods.

- Example:

```java
@GetMapping(path = "/jobpost", produces = "application/json")
public List<JobPost> getJobPosts() {
    return jobPostService.getAllJobPosts();
}
```

- By specifying produces = "application/json", the method will only return JSON data. If a client requests XML, they will receive a 406 Not Acceptable error.

### Specifying Request Formats

- Similarly, you can specify the format for incoming data using the consumes attribute.

- Example:

```java
@PostMapping(path = "/jobpost", consumes = "application/xml")
public JobPost createJobPost(@RequestBody JobPost jobPost) {
    return jobPostService.createJobPost(jobPost);
}
```

- By specifying consumes = "application/xml", the method will only accept XML data. If a client sends JSON data, they will receive a 415 Unsupported Media Type error.

### Practical Example

- Set up a POST request in Postman with a JSON body.
- Add a header Content-Type: application/json.
- On the server side, set the consumes attribute to application/xml.
- When sending the request, you will receive a 415 Unsupported Media Type error because the server only accepts XML.

### Conclusion

- Content negotiation allows you to specify the format for both incoming and outgoing data using produces and consumes attributes. By default, Spring Boot supports JSON. To support XML, add the Jackson XML library. This ensures your application can handle different data formats as required.

### Library Required

- jackson-dataformat-xml
- Note: Always ensure to pick the correct version of the library that matches the existing Jackson core version in your project.
