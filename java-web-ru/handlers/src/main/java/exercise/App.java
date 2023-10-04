package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        // Создаем приложение
        var app = Javalin.create(config -> {
            // Включаем логгирование при разработке
            config.plugins.enableDevLogging();
        });
        // Получаем список телефонов
        List<String> phones = Data.getPhones();

// Получаем список доменных имен
        List<String> domains = Data.getDomains();
        app.get("/users", ctx -> ctx.json(phones));
        app.get("/domains", ctx -> ctx.json(domains));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
