package ke.co.safaricom;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class Main {

        public static void main(String[] args) {
            // root is 'src/main/resources', so put files in 'src/main/resources/public'
            staticFiles.location("/public"); // Static files

            get("/animals", (request, response) -> {

                Map<String, Object> model = new HashMap<>();
                model.put("animals", "dummy");

                // Render the Handlebars template with the model data*/

                return new ModelAndView(model, "animals.hbs");

            }, new HandlebarsTemplateEngine());


            get("/sightings", (request, response) -> {

                Map<String, Object> model = new HashMap<>();
                model.put("sightings", "placeholder");

                // Render the Handlebars template with the model data*/

                return new ModelAndView(model, "sightings.hbs");

                //return "Sighting reported successfully!";


            });
            get("/", (request, response) -> {

                return "Home Page!";
            });


        }
    }

