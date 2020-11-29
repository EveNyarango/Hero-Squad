import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
public static void main (String[] args){
    staticFileLocation("/public");

    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
        port = Integer.parseInt(process.environment().get("PORT"));
    } else {
        port = 4567;
    }
    port(port);

    //get: index route for home page
    get("/", (req, res) -> {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "index.hbs");
    }, new HandlebarsTemplateEngine());

//        route for adding hero
//    get("/...",(request,response) ->{
//        Map<String, Object> model = new HashMap<>();
//        model.put("addHeroes", Hero.addHero());
//        return new ModelAndView(model, "hero.hbs");
//    },new HandlebarsTemplateEngine());

    //route to form to create squad
    get("/squadForm", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "squadForm.hbs");
    }, new HandlebarsTemplateEngine());

//    route for creating squad
    post("/success", (request, response) ->{
        String name = request.queryParams("name");
        int size = Integer.parseInt(request.queryParams("size"));
        String cause = request.queryParams("cause");

        Squad squad = new Squad(size, name, cause);

        Map<String, Object> model = new HashMap<>();
        model.put("squad", squad);
        return new ModelAndView(model, "success.hbs");
    }, new HandlebarsTemplateEngine());


    get("/newSquad", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("squad", Squad.getMembers());
        return new ModelAndView(model, "newSquad.hbs");
    }, new HandlebarsTemplateEngine());


}

}
