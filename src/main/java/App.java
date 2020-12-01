import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

public static void main (String[] args) {
    staticFileLocation("/public");
    port(getHerokuAssignedPort());

    //get: index route for home page
    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "index.hbs");
    }, new HandlebarsTemplateEngine());

//        route for adding hero
    get("/heroForm", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "heroForm.hbs");
    }, new HandlebarsTemplateEngine());


    post("/addHero1", (request, response) -> {

        Map<String, Object> model = new HashMap<>();
        String name = request.queryParams("name");
        int age = Integer.parseInt(request.queryParams("age"));
        String power = request.queryParams("power");
        String weakness = request.queryParams("weakness");

        Hero hero = new Hero(name, age, power, weakness);

        model.put("hero", hero);
        return new ModelAndView(model, "successHero.hbs");
    }, new HandlebarsTemplateEngine());

//retreives data from above for new hero
    get("/hero", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("addHeroes", Hero.getAll()); //displays hero
        return new ModelAndView(model, "hero.hbs");
    }, new HandlebarsTemplateEngine());



    //route to form to create squad
    get("/squadForm", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "squadForm.hbs");
    }, new HandlebarsTemplateEngine());

//    route for creating squad
    post("/success", (request, response) -> {

        Map<String, Object> model = new HashMap<>();
        String name = request.queryParams("name");
        int size = Integer.parseInt(request.queryParams("size"));
        String cause = request.queryParams("cause");

        Squad squad = new Squad(size, name, cause);

        model.put("squad", squad);
        return new ModelAndView(model, "successSquad.hbs");
    }, new HandlebarsTemplateEngine());

//retreives data from above for new squad
    get("/newSquad", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("squad", Squad.getMembers()); //displays squad created
        return new ModelAndView(model, "newSquad.hbs");
    }, new HandlebarsTemplateEngine());


}
}
