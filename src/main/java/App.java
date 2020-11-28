import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
public static void main (String[] args){
    staticFileLocation("/public");


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




}

}
