package ke.co.safaricom;

import static spark.Spark.*;
public class Main {

        public static void main(String[] args) {

            get("/animals", (request, response) -> {

                return "Here are the animals in the forest!";
            });

            post("/sightings", (request, response) -> {

                return "Sighting reported successfully!";
            });


        }
    }

}