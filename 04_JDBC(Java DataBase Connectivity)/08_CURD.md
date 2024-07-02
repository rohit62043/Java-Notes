```java
import java.sql.*;

public class CRUDOperations {
    public static void main(String[] args) {
        try {
            // Load and register the driver (optional)
            Class.forName("org.postgresql.Driver");

            // Create a connection
            String url = "jdbc:postgresql://localhost:5432/demo";
            String username = "your_username";
            String password = "your_password";
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");

            // Create Operation
            String sqlInsert = "INSERT INTO student (sid, sname, sage) VALUES (?, ?, ?)";
            PreparedStatement pstInsert = con.prepareStatement(sqlInsert);
            pstInsert.setInt(1, 4);
            pstInsert.setString(2, "Alice");
            pstInsert.setInt(3, 20);
            int rowsInserted = pstInsert.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            // Read Operation
            String sqlSelect = "SELECT * FROM student";
            Statement stSelect = con.createStatement();
            ResultSet rs = stSelect.executeQuery(sqlSelect);
            while (rs.next()) {
                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Update Operation
            String sqlUpdate = "UPDATE student SET sname = ?, sage = ? WHERE sid = ?";
            PreparedStatement pstUpdate = con.prepareStatement(sqlUpdate);
            pstUpdate.setString(1, "Alicia");
            pstUpdate.setInt(2, 21);
            pstUpdate.setInt(3, 4);
            int rowsUpdated = pstUpdate.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated.");

            // Delete Operation
            String sqlDelete = "DELETE FROM student WHERE sid = ?";
            PreparedStatement pstDelete = con.prepareStatement(sqlDelete);
            pstDelete.setInt(1, 4);
            int rowsDeleted = pstDelete.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted.");

            // Close the connection
            con.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```
