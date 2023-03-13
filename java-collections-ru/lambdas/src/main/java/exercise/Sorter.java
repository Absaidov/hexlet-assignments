package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static void main(String[] args) {
        List<Map<String, String>> users = List.of(
                Map.of("name", "Vladimir Nikolaev", "birthday", "1990-12-27", "gender", "male"),
                Map.of("name", "Andrey Petrov", "birthday", "1989-11-23", "gender", "male"),
                Map.of("name", "Anna Sidorova", "birthday", "1996-09-09", "gender", "female"),
                Map.of("name", "John Smith", "birthday", "1989-03-11", "gender", "male"),
                Map.of("name", "Vanessa Vulf", "birthday", "1985-11-16", "gender", "female"),
                Map.of("name", "Alice Lucas", "birthday", "1986-01-01", "gender", "female"),
                Map.of("name", "Elsa Oscar", "birthday", "1970-03-10", "gender", "female")
        );

        List<String> men = Sorter.takeOldestMans(users);
        System.out.println(men); // ["John Smith", "Andrey Petrov", "Vladimir Nikolaev"]
//        System.out.println(LocalDate);
    }

    public static List<String> takeOldestMans(List<Map<String, String>> users) {
            return users.stream()
                    .filter(user -> user.get("gender") == "male")
                    .sorted((user1, user2) -> {
                        LocalDate date1 = LocalDate.parse(user1.get("birthday"));
                        LocalDate date2 = LocalDate.parse(user2.get("birthday"));
                        return date1.compareTo(date2);
                    })
                    .map(user -> user.get("name"))
                    .collect(Collectors.toList());
        }
}
// END
