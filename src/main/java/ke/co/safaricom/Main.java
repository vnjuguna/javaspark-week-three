package ke.co.safaricom;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class Main {

        public static void main(String[] args) {

            get("/animals", (request, response) -> {

                Map<String, Object> model = new HashMap<>();
                model.put("animals", "dummy");

                // Render the Handlebars template with the model data*/
                return new HandlebarsTemplateEngine().render(new ModelAndView(model, "animals.hbs"));
            });

            get("/sightings", (request, response) -> {

                return "Sighting reported successfully!";
            });
            get("/", (request, response) -> {

                return "Home Page!";
            });


        }
    }

