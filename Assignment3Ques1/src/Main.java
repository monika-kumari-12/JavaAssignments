import java.sql.*;

public class Main {
    public static final String DB_NAME = "test2.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/monika/Downloads/Sqlite/database/" + DB_NAME;

    public static final String TABLE_STUDENTS = "students";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ROLLNO = "rollno";
    public static final String COLUMN_MARKS = "marks";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_STUDENTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_STUDENTS +
                    " (" + COLUMN_ID + " integer, " + COLUMN_NAME + " text, " +
                    COLUMN_ROLLNO + " integer, " +
                    COLUMN_MARKS + " integer" +
                    ")");
              //insert
            insertStudent(statement,1,"Abhi", 6545678, 23);
            insertStudent(statement,2,"Nimy", 654678, 13);
            insertStudent(statement,3,"Timu", 654578, 43);
            insertStudent(statement,4,"Timo", 65678, 53);
            insertStudent(statement,5,"Tihhmo", 65767678, 53);


             //update
            statement.execute("UPDATE " + TABLE_STUDENTS + " SET " +
                    COLUMN_NAME + "='Monika', " + COLUMN_MARKS + "=78" +
                    " WHERE " + COLUMN_NAME + "='Timu'");
            //display



            statement.execute("DELETE FROM " +TABLE_STUDENTS +
                    " WHERE " + COLUMN_NAME + "='Timo'");

            //statement.execute("SELECT * FROM " + TABLE_STUDENTS + " ORDER BY " + COLUMN_NAME + " ASC");
           // statement.execute("SELECT AVG(" +COLUMN_MARKS+") FROM " + TABLE_STUDENTS );

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_STUDENTS + " ORDER BY " + COLUMN_NAME + " ASC");
            while(results.next()) {
                System.out.println(results.getInt(COLUMN_ID) + " " +results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_ROLLNO) + " " +
                        results.getInt(COLUMN_MARKS));
            }

            results.close();

//            ResultSet results1 = statement.executeQuery("SELECT AVG(" + COLUMN_MARKS + ")  FROM " + TABLE_STUDENTS);
//            while(results1.next()){
//                System.out.println(results1.getInt(COLUMN_MARKS));}
//
//            results1.close();

            statement.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertStudent(Statement statement, int id,String name, int rollno, int marks) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_STUDENTS +
                " (" + COLUMN_ID + ", " +
                COLUMN_NAME + ", " +COLUMN_ROLLNO + ", " +
                COLUMN_MARKS +
                " ) " +
                "VALUES(" + id + ",'" + name + "', " + rollno + ", " + marks + ")");
    }
}




















