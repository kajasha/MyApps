package lodowka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public interface Przepisy {
    }

    public static void main(String[] args) throws Exception {
        Jedzenie posiłek1;
        Jedzenie posiłek2;
        Jedzenie posiłek3;

        posiłek1 = new Jedzenie("Leczo", "Kiełbasa, Papryka, Ziemniaki, Cebula, Pomidory");
        posiłek2 = new Jedzenie("Kotlety mielone", "Mięso mielone");
        posiłek3 = new Jedzenie("Spaghetti", "Makaron, Mięso, Pomidory, Cebula");

        List<Jedzenie> listaPotraw = new ArrayList<>();
        listaPotraw.add(posiłek1);
        listaPotraw.add(posiłek2);
        listaPotraw.add(posiłek3);

        System.out.println(listaPotraw);

        Scanner wejscie = new Scanner(System.in);

        System.out.println("Co masz dobrego w lodowce?");

        String skladniki = wejscie.nextLine();

        List<Jedzenie> listaPasujacychPotraw = new ArrayList<>();
        for (Jedzenie jedzenie : listaPotraw) {
            if (jedzenie.skladniki.contains(skladniki)) {
                listaPasujacychPotraw.add(jedzenie);
            }
        }
        if (listaPasujacychPotraw.size() == 0) {

            throw new BrakPasujacychPotrawException();
        }


        System.out.println(listaPasujacychPotraw);
    }


}
