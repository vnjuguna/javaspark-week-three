package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.dto.RangerOption;
import ke.co.safaricom.model.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


public class AnimalDao {


    private static final Sql2o sql2o = DatabaseConfig.getDatabase();
    public static void create(Animal animal){
        try(Connection connection = sql2o.open()){
            String query = "INSERT INTO animals (name, health,age,endangered) VALUES (:name, :health, :age,:endangered);";
            connection.createQuery(query)
                    .addParameter("name", animal.getName())
                    .addParameter("health", animal.getHealth())
                    .addParameter("age", animal.getAge())
                    .addParameter("endangered", animal.isEndangered())
                    .executeUpdate();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static RangerOption findAnimalById(int id){

        try(Connection connection =  sql2o.open()){
            String query = "SELECT * FROM animals WHERE not deleted AND id = animalId;";
            connection.createQuery(query)
                    .addParameter("id",id)
                    .executeAndFetch( Animal.class );

            System.out.println(id);
            return null;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }

    }
    public static List<RangerOption> getAnimalOption() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT id,name as text from animals";
            List<RangerOption> listOption = connection.createQuery( query )
                    .executeAndFetch( RangerOption.class );
            System.out.println( listOption );
            return listOption;
        } catch (Exception exception) {
            System.out.println( exception.getMessage() );
            return null;
        }


    }


}


