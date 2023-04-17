package Lambda_Functional_Programming_01;

import java.util.ArrayList;
import java.util.List;

public class Fp01 {
    /*
    1) Lambda (Functional Programming) Java 8 ile kullanima girdi
    2) Functional Programming`de "ne yapilacak" uzerine yogunlasilir
     Structured programming`te ise "nasil yapilacak" uzerine yogunlasilir
    3) Functional Programming Arrays ve Collections ile kullanilir.
    4) entrySet() methodu ile map de functional programming`te kullanilabilir
    5)
     */

    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste); // [8, 9, 131, 10, 9, 10, 2, 8]

    // Ardisik list elementlerini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun(Structured)
        listElemanYazdirStructured(liste); // 8 9 131 10 9 10 2 8
        System.out.println("");

        // functional
        listElemanYazdirFunctional(liste); // 8 9 131 10 9 10 2 8
        System.out.println("");

        //Cift list elemanlarini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun(Structured)
        listElemanYazdirCiftStructured(liste); // 8 10 10 2 8
        System.out.println("");

        // functional
        listElemanYazdirCiftFunctional(liste); // 8 10 10 2 8
        System.out.println();

        // Listedeki tek elemanlari yazdiralim
        liste.stream().filter(t->t%2==1).map(t->t*t).forEach(t-> System.out.print(t + " ")); // map gecici degistirir
        // 81 17161 81
        System.out.println(liste); // [8, 9, 131, 10, 9, 10, 2, 8]

        // Tek list elemanlarinin kuplerini tekrarsiz olarak yazdirin
        liste.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t + " "));
        // 729 2248091  == distinct tekrarsiz hale getirir
        System.out.println();

        // Tekrarsiz cift elemanlarin karelerin toplamini bulalim
        Integer toplam =liste.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.println(toplam); // 168
        // reduce: t=0, t+=v; gibi dusunebiliriz, tum listi toplar

    }

    private static void listElemanYazdirCiftFunctional(List<Integer> liste) {
        liste.stream().filter(t->t%2==0).forEach(t-> System.out.print(t + " "));

    }

    public static void listElemanYazdirCiftStructured(List<Integer> liste) {
        for (Integer each : liste
             ) {
            if (each%2==0) {
                System.out.print(each + " ");
            }
        }
    }

    public static void listElemanYazdirFunctional(List<Integer> liste) {
        liste.stream().forEach(t -> System.out.print(t + " "));
    }



    public static void listElemanYazdirStructured(List<Integer> liste) {
        for (Integer each : liste
             ) {
            System.out.print(each + " ");
        }

    }
}
