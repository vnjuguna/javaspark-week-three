package ke.co.safaricom;

import ke.co.safaricom.utils.SharedUtils;
import ke.co.safaricom.dao.AnimalDao;
import ke.co.safaricom.models.animals;

import java.util.HashMap;

import static spark.Spark.*;
public class Main {

        public static void main(String[] args) {
            // root is 'src/main/resources', so put files in 'src/main/resources/public'
            staticFileLocation("/public"); // Static files

           /* get("/animals", (request, response) -> {

                Map<String, Object> model = new HashMap<>();
                model.put("animals", "dummy");

                try (Connection connection = DatabaseConfig.getConnection()) {
                    // Use the connection to interact with the database
                    // For example, you can fetch data from the database and put it in the model
                    // For demonstration, let's fetch a list of animals from the database
                    // and put it in the model
                    List<String> animalsFromDB = new ArrayList<>();
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT name FROM animals");
                    while (rs.next()) {
                        animalsFromDB.add(rs.getString("name"));
                    }
                    model.put("animalsFromDB", animalsFromDB);
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Handle database connection exceptions
                } */

                // Render the Handlebars template with the model data

               /* return new ModelAndView(model, "animals.hbs");

            }, new HandlebarsTemplateEngine());




            get("/sightings", (request, response) -> {

                    Map<String, Object> model = new HashMap<>();
                    model.put("sightings", "dummy");

                return new ModelAndView(new HashMap(), "sightings.hbs");
                    
                }, new HandlebarsTemplateEngine());

               //return "Sighting reported successfully!"

            get("/", (request, response) -> {

                return "Home Page!";
            }); */

            get("/animals/add", (request, response) -> {
                return SharedUtils.render(new HashMap<>(), "animals.hbs");
            });
            post("/add-animals", (request, response) -> {
                String name = request.queryParams("name");
                boolean endangered = Boolean.parseBoolean(request.queryParams("endangered"));
                int age = Integer.parseInt(request.queryParams("name"));
                String health = request.queryParams("health");

                Animals animals = new animals();
                animals.setName(name);
                animals.setEndangered(endangered);
                animals.setAge(age);
                animals.setHealth(health);


                AnimalDao.create(ke.co.safaricom.models.animals);

                response.redirect("/");
                return null;
            });
        }
    }

