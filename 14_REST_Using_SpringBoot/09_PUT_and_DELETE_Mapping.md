# API Request Methods: PUT and DELETE

## Overview

In this video, we discuss how to handle PUT and DELETE requests using Postman. We start by revisiting GET and POST requests, then move on to updating and deleting objects.

## Prerequisites

Ensure your server is running before making requests.

## PUT Request: Update an Object

1. **Get the Current Data**:

   - Perform a GET request to retrieve the list of objects.
   - Note the IDs of the objects (e.g., 1, 2, 3, 4, 5).

2. **Objective**:

   - Update the profile of a Frontend developer to a React developer.
   - Change the required experience from 3 to 2 years.

3. **Modify the Data**:

   - Copy the existing data object.
   - Change "Frontend developer" to "React developer".
   - Update the required experience from 3 to 2 years.

4. **Perform the PUT Request**:

   - Set the method to PUT.
   - Use the URL `/jobpost`.
   - Paste the modified data into the body.

5. **Code Changes**:

   - **Controller**:
     ```java
     @PutMapping("/jobpost")
     public JobPost updateJob(@RequestBody JobPost jobPost) {
         return service.updateJob(jobPost);
     }
     ```
   - **Service**:
     ```java
     public JobPost updateJob(JobPost jobPost) {
         for (JobPost jp : jobs) {
             if (jp.getPostId().equals(jobPost.getPostId())) {
                 jp.setProfile(jobPost.getProfile());
                 jp.setDescription(jobPost.getDescription());
                 jp.setExperience(jobPost.getExperience());
                 jp.setTechStack(jobPost.getTechStack());
             }
         }
         return jobPost;
     }
     ```

6. **Testing**:
   - Send the PUT request.
   - Verify the update by performing another GET request.

## DELETE Request: Delete an Object

1. **Objective**:

   - Delete the object with a specific ID (e.g., ID 3).

2. **Perform the DELETE Request**:

   - Set the method to DELETE.
   - Use the URL `/jobpost/{id}` (e.g., `/jobpost/3`).

3. **Code Changes**:

   - **Controller**:
     ```java
     @DeleteMapping("/jobpost/{postId}")
     public String deleteJob(@PathVariable int postId) {
         service.deleteJob(postId);
         return "Deleted";
     }
     ```
   - **Service**:
     ```java
     public void deleteJob(int postId) {
         jobs.removeIf(jobPost -> jobPost.getPostId() == postId);
     }
     ```

4. **Testing**:
   - Send the DELETE request.
   - Verify the deletion by performing another GET request.

## Error Handling

- **ConcurrentModificationException**:
  - Ensure that modifications to the list are handled properly.
  - Check for exceptions and handle them accordingly.

## Conclusion

The PUT and DELETE methods are essential for updating and removing resources in a REST API. Properly handling these requests ensures the integrity and consistency of your data.
