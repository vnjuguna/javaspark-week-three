package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class AnimalDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();


    public static void create(Animal animal){
        try(Connection connection = sql2o.open()) {
            String query = " insert into animal (name, endangered, age, health) VALUES (:name,:endangered, :age. :health);";
            connection.createQuery(query)
                    .addParameter("name", animal.getName())
                    .addParameter("endangered", animal.getEndangered())
                    .addParameter("age", animal.getAge())
                    .addParameter("health", animal.getHealth())
                    .executeUpdate();
        } catch(Exception exception){
            System.out.println(exception.getMessage());
        }



    }
    /*public static void create(Animal animal) {
        try (Connection connection = sql2o.open()) {
            // Implementation for creating an animal
            // For example, you can execute an INSERT query
            String insertQuery = "INSERT INTO animals (name, endangered, age, health) " +
                    "VALUES (:name, :endangered, :age, :health)";
            connection.createQuery(insertQuery)
                    .addParameter("name", animal.getName())
                    .addParameter("endangered", animal.isEndangered())
                    .addParameter("age", animal.getAge())
                    .addParameter("health", animal.getHealth())
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static List<Animal> getAllAnimals() {
        try (Connection connection = sql2o.open()) {
            // Implementation for retrieving all animals
            String queryAnimals = "SELECT * FROM animals;";
            return connection.createQuery(queryAnimals)
                    .executeAndFetch(Animal.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }  */

    }


