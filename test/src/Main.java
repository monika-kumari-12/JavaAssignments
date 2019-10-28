
import java.sql.*;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter name:");
        String Name = s.nextLine();
        System.out.println("Please Enter message:");
        String Message = s.nextLine();

        Date date = new Date();


        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/monika/Downloads/Sqlite/database/testjsaa.db");

            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS clients " +
                    " (name TEXT, arrivalTime TEXT, message TEXT)");
//            statement.execute("INSERT INTO clients (name, arrivalTime, message) " +
//                              "VALUES('Joe', '4:50', 'HIII')");
            statement.execute("INSERT INTO clients (name, arrivalTime, message) " +
                            "VALUES(Name, String.valueOf(date), Message)");
//            String sql="insert into clients(name,arrivalTime,message) values(? , ?, ?)";
//            statement = conn.prepareStatement(sql);
//            ((PreparedStatement) statement).setString(1, Name);
//            ((PreparedStatement) statement).setString(2, String.valueOf(date));
//            ((PreparedStatement) statement).setString(3, Message);
//             statement.executeUpdate(sql);
            statement.execute("SELECT * FROM clients");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getString("arrivalTime") + " " +
                        results.getString("message"));
            }

            results.close();

            statement.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}