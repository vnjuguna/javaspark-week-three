package ke.co.safaricom.config;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static Sql2o getDatabase() {
        return new Sql2o("jdbc:postgresql://localhost:5432/wildlifesigthings", "postgres", "Pumk1n");

        }
    }


