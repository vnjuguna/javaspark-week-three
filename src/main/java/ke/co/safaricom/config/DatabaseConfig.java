package ke.co.safaricom.config;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static Sql2o getDatabase() {
        return new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "Pumk1n");

        }
    }


