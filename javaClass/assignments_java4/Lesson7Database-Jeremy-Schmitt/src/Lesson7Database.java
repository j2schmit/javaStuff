import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;

// Note this uses the Embedded Driver and
// assumes the derby database has been created
// in the current directory with the name COREJAVA
// A single argument is expected, which should be
// the filename that contains the SQL commands

public class Lesson7Database {

    public static void main(String[] args) throws SQLException, IOException {
        String sqlFile = args[0];
        String url = "jdbc:derby:COREJAVA";
        List<String> sqlCmds = getSQLCommands(sqlFile);
        executeCommands(url, sqlCmds);
    }

    public static void executeCommands(String url, List<String> sqlCmds) throws SQLException {
        System.out.println("Database Connection info: URL " + url + ", Using Embedded Derby Driver");

        Connection connection = DriverManager.getConnection(url);
        System.out.println("Connecting to the database: Done.");

        Statement statement = connection.createStatement();

        String tableName = null;
        for (String cmd : sqlCmds) {
            // only executing non-empty lines
            if ( cmd.length() > 0 ) {
                // get table name
                if ( cmd.contains("CREATE TABLE")) {
                    tableName = cmd.split(" ")[2];
                }
                // execute, but first remove ;
                statement.executeUpdate(cmd.replace(";", ""));
            }
        }
        System.out.println("Populating the database: Done.");


        System.out.println("Query of Lessons table results:");

        // get all rows from the table
        String queryColumns = "SELECT * FROM " + tableName;
        ResultSet results = statement.executeQuery(queryColumns);

        // get column names and form header
        int numColumns = results.getMetaData().getColumnCount();
        String header = "";
        for (int i = 1; i < numColumns; i++) {
            header += results.getMetaData().getColumnName(i);
            header += ", ";
        }
        header += results.getMetaData().getColumnName(numColumns);
        System.out.println(header);

        int lessonNum;
        String lessonName = null;
        while (results.next()) {
            lessonNum = results.getInt("Lesson_Num");
            lessonName = results.getString("Title");
            System.out.println(lessonNum + ", " + lessonName);
        }
        // clean-up and delete table
        statement.executeUpdate("DROP TABLE " + tableName);

    }

    public static List<String> getSQLCommands(String sqlFile) throws IOException {
        List<String> sqlCmds = Files.readAllLines(Paths.get(sqlFile));
        return sqlCmds;
    }
}
