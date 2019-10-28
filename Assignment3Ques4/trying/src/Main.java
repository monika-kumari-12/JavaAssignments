

import java.sql.*;

public class Main {
    public static final String DB_NAME = "client.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/monika/Downloads/Sqlite/database/" + DB_NAME;

    public static final String TABLE_CLIENTS = "clients";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MESSAGE_LENGTH = "len";


    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CLIENTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CLIENTS +
                    " ("  + COLUMN_NAME + " text, " +
                    COLUMN_MESSAGE_LENGTH + " integer" + ")");
            //insert
            insertClient(statement,"Client1", 23);
            insertClient(statement,"Client2", 13);
            insertClient(statement,"Client3", 43);
            insertClient(statement,"Client4", 53);
            insertClient(statement,"Client5", 73);










            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CLIENTS );
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_MESSAGE_LENGTH) );
            }

            results.close();
            statement.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }



        private static void insertClient(Statement statement,String name,  int len) throws SQLException {
            statement.execute("INSERT INTO " + TABLE_CLIENTS +
                    " (" + COLUMN_NAME + ", " +
                    COLUMN_MESSAGE_LENGTH +
                    " ) " +
                    "VALUES('" + name + "', " + len + ")");
    }
}





















