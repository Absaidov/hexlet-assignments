package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result); // =>


        CharSequence text = new ReversedSequence("abcdef");
        String jama1 = text.toString(); // "fedcba"
        System.out.println(jama1);
        System.out.println(text.charAt(1));; // 'e'
        System.out.println(text.length()); // 6
        System.out.println(text.subSequence(1, 4).toString()); // "edc"
    }
    public static List<String> buildApartmentsList(List<Home> list, int number){
        return list.stream()
                .sorted(Comparator.comparing(x -> x.getArea()))
                .limit(number)
                .map(newString -> newString.toString())
                .collect(Collectors.toList());
    }
}
// END
