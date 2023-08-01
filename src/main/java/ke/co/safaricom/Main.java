package ke.co.safaricom;

import ke.co.safaricom.configuration.Age;
import ke.co.safaricom.configuration.Health;
import ke.co.safaricom.dao.RangerDao;
import ke.co.safaricom.dao.SightingDao;
import ke.co.safaricom.model.Ranger;
import ke.co.safaricom.model.Sighting;
import ke.co.safaricom.dao.AnimalDao;
import ke.co.safaricom.model.Animal;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class Main {

        public static void main(String[] args) {

            port(4567);
            staticFiles.location("/public");
            staticFiles.expireTime(600L);
            staticFiles.registerMimeType("html", "text/html");
            staticFiles.registerMimeType("hbs", "text/html");
            staticFiles.externalLocation("src/main/resources");

            get("/ranger/add",(request, response) ->{
                return new ModelAndView( new HashMap<>(), "ranger.hbs");
            },new HandlebarsTemplateEngine());


            post("/create-ranger",(request, response) -> {
                String name = request.queryParams("ranger");
                Ranger ranger =new Ranger();

                ranger.setName( name );
                RangerDao.create( ranger);
                System.out.println(name );
                String alertScript = "<script>alert('successful added ranger "+name+"');</script>";
                return alertScript;
            });

            get("/",(request, response) ->{
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "index.hbs");
            },new HandlebarsTemplateEngine());

            get("/",(request, response) ->{
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "ranger.hbs");
            },new HandlebarsTemplateEngine());

            get("/",(request, response) ->{
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "sighting.hbs");
            },new HandlebarsTemplateEngine());

            get("/animal/add",(request, response) ->{
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "animal.hbs");
            },new HandlebarsTemplateEngine());


            post("/create-animal",(request, response) -> {
                String name = request.queryParams("animal");
                String health = request.queryParams("health");
                String age = request.queryParams("age");
                String endangered = request.queryParams("endangered");
                Animal animal =new Animal();
                animal.setAge( Age.valueOf( age ) );
                animal.setHealth( Health.valueOf( health ) );
                animal.setName( name );
                animal.setEndangered( endangered.equalsIgnoreCase( "yes" ));
                AnimalDao.create(animal);
                System.out.println(name + " " +age +health);
                String alertScript = "<script>alert('successful added animal "+name+"' );</script>";
                return alertScript;
            });
            get("/sighting/add",(request, response) ->{
                Map<String, Object> model = new HashMap<>();
                model.put("rangers", RangerDao.getRangerOption());
                model.put("animals", AnimalDao.getAnimalOption());
                return new ModelAndView(model, "sighting.hbs");
            },new HandlebarsTemplateEngine());


            post("/create-sighting",(request, response) -> {
                String location = request.queryParams("location");
                String health = request.queryParams("health");
                String animalId = request.queryParams("animalId");
                String rangerId = request.queryParams("rangerId");
                Sighting sighting =new Sighting();
                sighting.setLocation( location );
                sighting.setHealth( health );
                sighting.setTimestamp( LocalDateTime.now() );

                try {
                    sighting.setAnimal_id(Integer.parseInt(animalId));
                } catch (NumberFormatException e) {
                    return "<script>The animal ID must be a valid integer</script>";
                }
                sighting.setRanger_id( Integer.parseInt( rangerId) );

                SightingDao.create(sighting);

                System.out.println(location + " " +health);
                String alertScript = "<script>alert('successful added sighting "+sighting+"' );</script>";
                return alertScript;
            });


        }

}
            /* staticFileLocation("/public"); // Static files



            get("/animals/add", (request, response) -> {
                return SharedUtils.render(new HashMap<>(), "animals.hbs");
            });
            post("/add-animals", (request, response) -> {
                String name = request.queryParams("name");
                boolean endangered = Boolean.parseBoolean(request.queryParams("endangered"));
                int age = Integer.parseInt(request.queryParams("name"));
                String health = request.queryParams("health");

                Animal animal = new Animal();
                animal.setName(name);
                animal.setEndangered(endangered);
                animal.setAge(age);
                animal.setHealth(health);


                AnimalDao.create(animal);;

                response.redirect("/");
                return null;
            });
        }
    } */

