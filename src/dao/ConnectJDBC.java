package dao;

import java.sql.*;

public class ConnectJDBC {

    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/xscj";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "123456");
        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }

    public static void close(Object... objects) {
        if (objects != null && objects.length > 0) {
            for (Object object : objects) {
                try {
                    if (object != null) {
                        if (object instanceof Connection) {
                            ((Connection) object).close();
                        }
                    }

                    if (object != null) {
                        if (object instanceof Statement) {
                            ((Statement) object).close();
                        }
                    }

                    if (object != null) {
                        if (object instanceof ResultSet) {
                            ((ResultSet) object).close();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
