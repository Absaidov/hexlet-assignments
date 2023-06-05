package exercise;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static void main(String[] args) {
//        Address address = new Address(null, "London", "1-st street", "7", "2");
//        List<String> notValidFields = Validator.validate(address);
//        System.out.println(notValidFields); // => [country]
//
//        Address address2 = new Address("England", null, null, "7", "2");
//        List<String> notValidFields2 = Validator.validate(address2);
//        System.out.println(notValidFields2); //
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
        System.out.println(notValidFields); // =>  {country=[length less than 4], street=[can not be null]}
//        Напишите тесты на метод advancedValidate()
//        Статусы проверок:
//        Тесты ещё не запускались. Отправьте домашнее задание на проверку.
    }

    public static List<String> validate(Address address){
        List<String> nullString = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()){
            try {
                field.setAccessible(true);
                if (field.getAnnotation(NotNull.class) != null && field.get(address) == null){
                        nullString.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return nullString;
    }
    public static Map<String, List<String>> advancedValidate(Address address){
        Map <String , List<String>> errorValid = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()){
            try {
                field.setAccessible(true);
                if (field.getAnnotation(NotNull.class) != null && field.get(address) == null){
                    errorValid.put(field.getName(),  List.of("can not be null"));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return errorValid;
    }
}
// END
