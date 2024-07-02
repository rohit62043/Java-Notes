# Connecting a Java Application with PostgreSQL

## Steps

1. **Import the Package**
2. **Load and Register the Driver** (Optional)
3. **Create Connection**
4. **Create a Statement**
5. **Execute the Statement**
6. **Process the Results**
7. **Close the Connection**

## Implementation

1. **Create a Java File**

   Create a Java file in the `src` folder. Name it `DemoJdbc.java`.

   ```java
   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.SQLException;

   public class DemoJdbc {
       public static void main(String[] args) throws Exception {
           // Step 1: Import the package
           // Done above with import statements

           // Step 2: Load and register the driver (Optional)
           Class.forName("org.postgresql.Driver");

           // Step 3: Create a connection
           String url = "jdbc:postgresql://localhost:5432/demo";
           String username = "postgres";
           String password = "0000";

           Connection con = DriverManager.getConnection(url, username, password);
           System.out.println("Connection established.");

           // Close the connection
           con.close();
       }
   }
   ```
