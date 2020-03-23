package system.bl;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Util {
    private static final String BD_DRIVER = "org.postgresql.Driver";
    private static final String BD_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String BD_USERNAME = "postgres";
    private static final String BD_PASSWORD = "postgres";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(BD_DRIVER);
            connection = DriverManager.getConnection(BD_URL, BD_USERNAME, BD_PASSWORD);
            connection.setSchema("ann1221");
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Not Connected");
        }
        return connection;
    }

}
