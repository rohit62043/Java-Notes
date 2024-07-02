# Working with Repository Layer in Spring Application

## Overview

In a Spring application, the repository layer is responsible for database interactions. It separates the business logic from database access, adhering to the principle of separation of concerns.All JDBC steps will be written here only.

### Repository Class

Let's create a `LaptopRepository` class in the `repo` package. This class will handle database operations related to the `Laptop` entity.

#### LaptopRepository Class

```java
package com.example.repo;

import com.example.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save(Laptop laptop) {
        // JDBC logic to save laptop in database
        System.out.println("Saved in database: " + laptop);
    }

    // Other CRUD operations can be defined here
}
```
