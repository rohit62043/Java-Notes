# Updating and Deleting Resources with Spring Data REST

In this section, we will explore how to update and delete resources using Spring Data REST. We will use Postman to test these operations.

## Updating a Resource

To update a resource, we will use the `PUT` method.

### Steps:

1. **Retrieve the Resource:**

   - First, send a `GET` request to retrieve the resource you want to update.
   - URL: `http://localhost:8080/jobPosts/3`
   - Response:
     ```json
     {
       "id": 3,
       "title": "React Developer",
       "description": "Job description for React Developer",
       "location": "Location for React Developer",
       "_links": {
         "self": {
           "href": "http://localhost:8080/jobPosts/3"
         },
         "jobPost": {
           "href": "http://localhost:8080/jobPosts/3"
         }
       }
     }
     ```

2. **Prepare the Update:**

   - Copy the JSON response and remove the `_links` section.
   - Modify the fields you want to update. For example, change the title to "Front End Developer" and experience to "1".
     ```json
     {
       "id": 3,
       "title": "Front End Developer",
       "description": "Job description for React Developer",
       "location": "Location for React Developer",
       "experience": "1"
     }
     ```

3. **Send the PUT Request:**

   - Set the method to `PUT` in Postman.
   - URL: `http://localhost:8080/jobPosts/3`
   - Body: Paste the modified JSON data.
   - Click `Send`.

4. **Verify the Update:**
   - Check the response to ensure the update was successful.
   - Verify the update in the database.
   - SQL Query:
     ```sql
     SELECT * FROM job_post WHERE id = 3;
     ```

## Deleting a Resource

To delete a resource, we will use the `DELETE` method.

### Steps:

1. **Send the DELETE Request:**

   - Set the method to `DELETE` in Postman.
   - URL: `http://localhost:8080/jobPosts/3`
   - Click `Send`.

2. **Verify the Deletion:**
   - Check the response to ensure the deletion was successful.
   - Verify the deletion in the database.
   - SQL Query:
     ```sql
     SELECT * FROM job_post WHERE id = 3;
     ```

## Summary

With Spring Data REST, you can easily create, read, update, and delete resources using the repository layer. The framework automatically generates the necessary endpoints for you, significantly reducing the amount of code you need to write.

### Project Structure:

- **Repository Layer:** Contains the JPA repository interfaces.
- **Model Layer:** Contains the entity classes.

By leveraging Spring Data REST, we have simplified the process of building RESTful web services, allowing you to focus on other aspects of your application.
