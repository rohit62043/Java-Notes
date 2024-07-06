# Welcome to the New Section

In this section, we will discuss how to work with REST APIs using Spring Boot.

## Overview of the Current Project

We have built an application for job seekers and employers:

- Job seekers can view all jobs.
- Employers can add new jobs.

The current project is a full-stack application:

- It includes both frontend and backend in a single project.
- Controllers accept requests and process data.
- Data is retrieved from a mocked database.
- JSP pages are used for the frontend.

## Current Architecture

- Client requests a page.
- The server formats data and returns a JSP page.
- The pages are functional but not very beautiful.
- Users interact with the application through these JSP pages.

## Evolution of Web Applications

In the past, web applications were accessed through browsers:

- Users opened a browser to interact with the web application.
- The server returned HTML pages.

Now, we have mobile applications:

- Users access services through mobile apps.
- Mobile apps require only data, not HTML pages.

## The Need for a Common Server

We need a server that:

- Returns data instead of HTML pages.
- Serves both web and mobile clients.

### Advantages of Separate Backend and Frontend

- The backend server handles data in JSON or XML format.
- The frontend can be built separately using technologies like React or Angular.
- The server communicates with clients using JSON.

## Building a REST API

To achieve this, we will:

- Remove JSP pages.
- Modify controllers to return data instead of pages.

## Understanding REST

- REST APIs return data in JSON or XML format.
- Communication between client and server uses JSON.

### Testing the Backend

- A React frontend will be used, but detailed React instruction is not provided.
- For backend testing, we will use a REST client like Postman.

## Next Steps

In the next video:

- We will discuss what REST is.
- We will focus on the frontend part.
- We will demonstrate how to connect the React frontend with the backend.
- We will introduce Postman for testing the REST API.

Stay tuned!
