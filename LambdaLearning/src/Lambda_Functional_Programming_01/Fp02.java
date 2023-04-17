package Lambda_Functional_Programming_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp02 {
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

        // tekrarsiz cift elemanlarin kupunun carpimini bulun
        Integer carpim = liste.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        System.out.println(carpim); // 4096000

        // List elemanlari arasindan en buyuk olani bulun
        // 1. yol
        Integer buyuk = liste.stream().distinct().reduce(liste.get(0),(t,u)->t>u?t:u);
        System.out.println(buyuk); // 131

        // 2. yol
        buyuk = liste.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
        System.out.println(buyuk); // 131

        //List elemanlari arasindan 7`den buyuk , cift en kucuk degeri bulun
        // 1. yol
        buyuk = liste.stream().distinct().sorted().reduce(liste.get(0),(t,u)->t>u?t:u);
        Integer kucuk = liste.stream().distinct().filter(t->t%2==0).filter(t->t>7).reduce(Integer.MAX_VALUE,(t,u)->t>u?u:t);
        System.out.println(kucuk); // 8
        // 2. yol
        kucuk = liste.stream().distinct().filter(t->t%2==0).filter(t->t>7)
                .sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t,u)->u);
        System.out.println(kucuk); // 8 -- Comparator.reverseOrder() tersten siralatti
    }
}
