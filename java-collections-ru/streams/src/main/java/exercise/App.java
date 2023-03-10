package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

// BEGIN
 class App {
    public static void main(String[] args) {
        String[] emails = {
                "info@gmail.com",
                "info@yandex.ru",
                "mk@host.com",
                "support@hexlet.io",
                "info@hotmail.com",
                "support.yandex.ru@host.com"
        };

        List<String> emailsList = Arrays.asList(emails);
        System.out.println(App.getCountOfFreeEmails(emailsList));
//        System.out.println(emailsList);


    }
         public static long getCountOfFreeEmails(List<String> emailList2){
         long jamal = emailList2.stream()
                 .filter(email -> email.endsWith("gmail.com") || email.endsWith("yandex.ru") || email.endsWith("hotmail.com"))
                 .count();
         return jamal;
     }
}
// END
