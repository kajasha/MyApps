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

                    Jedzenie result;
                    Jedzenie result1;
                    Jedzenie result2;


                    result = new Jedzenie ("Leczo", "Kiełbasa, Papryka, Ziemniaki, Cebula, Pomidory");
                    result1 = new Jedzenie("Kotlety mielone", "Mięso mielone");
                    result2 = new Jedzenie("Spaghetti", "Makaron, Mięso, Pomidory, Cebula");


                    List<Jedzenie> listaPasujacychPotraw = new ArrayList<>();

                    listaPasujacychPotraw.add(result);
                    listaPasujacychPotraw.add(result1);
                    listaPasujacychPotraw.add(result2);

                    System.out.println(listaPasujacychPotraw);

                    String  listaPasujacychPotrawJakoString = listaPasujacychPotraw.toString();

                    for (Jedzenie jedzenie: listaPasujacychPotraw) {
                        if (jedzenie.skladniki.contains(skladniki)) {
                            listaPasujacychPotraw.add(jedzenie);
                        }
                        System.out.println(listaPasujacychPotraw);
                    }

                    Map<String, Object> model = new HashMap();
                    model.put("result", listaPasujacychPotrawJakoString);

                    return new ModelAndView(model, "lista_pasujacych_potraw.ftl");
                    // Koniec kodu strony
                }, new FreeMarkerEngine());



    }
}
