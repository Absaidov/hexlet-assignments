package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
class App{
    public static void main(String[] args) throws IOException {
        User owner = new User(1, "Ivan", "P", 25);
// Вызываем автоматически сгенерированный геттер
        owner.getFirstName(); // "Ivan"
        Path path1 = Paths.get("/tmp/file1.json");
        Car car1 = new Car(1, "audi", "q3", "black", owner);
        App.save(path1, car1); // Сохраняет представление объекта в файл

    }
    public static void save(Path path, Car car) throws IOException {
        String result = car.serialize();
        Files.writeString(path, result);
    }
    public static Car extract(Path path) throws IOException {
        String result = Files.readString(path);
        Car newCar = Car.unserialize(result);
        return newCar;
    }
}
// END
