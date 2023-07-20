package utils;

import java.sql.*;

public class DBUtil {
    static Connection connection = null;
    static Statement statement = null;

    // connect to DB
    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/spotify", "root", "Rakuzan123!");
            statement = connection.createStatement();
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database!");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // close DB connection
    public static void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from the database!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // select all records from a table
    public static ResultSet selectAll(String tableName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName);
        return statement.executeQuery();
    }

    // select top N records from a table based on a column
    public static ResultSet selectTopN(String tableName, String columnName, int n) throws SQLException {
        String query = "SELECT * FROM " + tableName + " ORDER BY " + columnName + " DESC LIMIT " + n;
        return statement.executeQuery(query);

    }

    // select records from a table based on a filter
    public static ResultSet selectFiltered(String tableName, String columnName, String filter) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE '%" + filter + "%'";
        return statement.executeQuery(query);
    }

    public static boolean insert(String tableName, String name, String artist, String release, int length, int popularity) {
        // create query
        String query = "INSERT INTO " + tableName + " (name, artist, release_date, length, popularity) VALUES ('" + name + "', '" + artist + "', '" + release + "', " + length + ", " + popularity + ")";
        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(String tableName, String name, String artist, String release, int length, int popularity) {
        String query = "UPDATE " + tableName + " SET name='" + name + "', artist='" + artist + "', release_date='" + release + "', length=" + length + ", popularity=" + popularity + " WHERE name='" + name + "'";

        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean delete(String tableName, String name) {
        String query = "DELETE FROM " + tableName + " WHERE name = '" + name + "'";
        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet selectUser(String email, String password) throws SQLException {
        return statement.executeQuery("SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "'");
    }

    public static boolean registerUser(String email, String password) {
        // Check if user already exists
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email='" + email + "'");
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Insert new user
        String query = "INSERT INTO users (email, password) VALUES ('" + email + "', '" + password + "')";
        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet selectAdmin(String email, String password) throws SQLException {
        return statement.executeQuery("SELECT * FROM admin WHERE email='" + email + "' AND password='" + password + "'");
    }

    public static boolean registerAdmin(String email, String password) {
        // Check if admin already exists
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin WHERE email='" + email + "'");
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Insert new admin
        String query = "INSERT INTO admin (email, password) VALUES ('" + email + "', '" + password + "')";
        try {
            if (statement.executeUpdate(query) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
