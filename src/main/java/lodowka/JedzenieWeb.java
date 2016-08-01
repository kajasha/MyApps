package lodowka;

import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JedzenieWeb {

    public static void main(String[] args) {

        Spark.staticFileLocation("/webfiles");

        String port = System.getenv("PORT");
        if (port != null) {
            int portInt = Integer.parseInt(port);
            Spark.port(portInt);
        }

        Spark.get(
                "/jedzenie",
                (request, response) -> {
                    // Początek kodu strony

                    String skladniki = request.queryParams("skladniki1");


                    List<Jedzenie> listaPasujacychPotraw = new ArrayList<>();
                    String  listaPasujacychPotrawJakoString = listaPasujacychPotraw.toString();

                    Map<String, Object> model = new HashMap();
                    model.put("result", listaPasujacychPotrawJakoString);

                    return new ModelAndView(model, "lista_pasujacych_potraw.ftl");
                    // Koniec kodu strony
                }, new FreeMarkerEngine());



    }
}
