package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.dto.RangerOption;
import ke.co.safaricom.model.Ranger;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class RangerDao {

        private static final Sql2o sql2o = DatabaseConfig.getDatabase();


        public static void create(Ranger ranger) {

            try (Connection connection = sql2o.open()) {

                String query = "INSERT INTO rangers (name) VALUES (:name);";

                connection.createQuery( query )

                        .addParameter( "name", ranger.getName() )

                        .executeUpdate();

            } catch (Exception exception) {

                System.out.println( exception.getMessage() );

            }

        }


        public static List<RangerOption> getRangerOption() {

            try (Connection connection = sql2o.open()) {

                String query = "SELECT id,name as text from rangers";

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


