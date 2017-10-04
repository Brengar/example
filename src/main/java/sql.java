import java.sql.*;
import java.util.List;

public class sql {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "7787";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static boolean check(List<String> arg) {

        boolean isCheck=true;

        String query = "select year, title, author from books where year="+arg.get(2)+" and author='"+arg.get(1)+"' and title='"+arg.get(0)+"'";

        try {
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            if (!rs.next()) isCheck=false;

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) {  }
            try { rs.close(); } catch(SQLException se) {  }
        }
        return isCheck;
    }

    public static void write(List<String> arg) {
        String query = "INSERT INTO test.books (title, author, year) \n" +
                " VALUES ('"+arg.get(0)+"', '"+arg.get(1)+"',"+arg.get(2)+");";

        try {
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) {  }
        }
    }

}