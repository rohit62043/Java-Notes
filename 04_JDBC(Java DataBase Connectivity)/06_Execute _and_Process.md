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

           // Create a statement
            Statement st = con.createStatement();

            // Execute a statement
            String sql = "SELECT sname FROM student WHERE sid = 1";
            ResultSet rs = st.executeQuery(sql);

            // Process the results
            if (rs.next()) {
                String name = rs.getString("sname");
                System.out.println("Name of the student is: " + name);
            } else {
                System.out.println("No data found");
            }

            // Close the connection
            con.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
