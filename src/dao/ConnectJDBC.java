package dao;

import dao.DO.ParmCon;

import java.sql.*;

public class ConnectJDBC {

    public static Connection getConnection() {
        Connection connection = null;
        String url = ParmCon.URL;
        try {
            Class.forName(ParmCon.DRIVER);
            connection = DriverManager.getConnection(url, ParmCon.USERNAME, ParmCon.PASSWORD);
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
