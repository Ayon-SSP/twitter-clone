package tech.codingclub.database;

import tech.codingclub.utility.SysProperties;

import java.sql.SQLException;

public class DatabaseUtil {
    private static DatabaseConnectionPool databaseConnectionPool;

    static {
        try {
            databaseConnectionPool = new DatabaseConnectionPool(
                    "jdbc:postgresql://127.0.0.1:5432/twitter", SysProperties.getPropertyValue("DB_USERNAME"),"postgres" , 350, 350);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnectionPool getDataseBaseConnectionPool() {
        return databaseConnectionPool;
    }
}