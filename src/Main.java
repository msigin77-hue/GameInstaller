import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final String GAMES_PATH = "C://Games/";
    private static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        // Массивы директорий для создания
        String[] directories = {
                "src", "res", "savegames", "temp",
                "src/main", "src/test",
                "res/drawables", "res/vectors", "res/icons"
        };

        // Массивы файлов для создания
        String[] files = {
                "src/main/Main.java",
                "src/main/Utils.java"
        };

        // Создаем директории
        for (String dir : directories) {
            createItem(dir, true);
        }

        // Создаем файлы
        for (String file : files) {
            createItem(file, false);
        }

        // Записываем лог
        writeLog();
    }

    private static void createItem(String path, boolean isDirectory) {
        File item = new File(GAMES_PATH + path);
        try {
            boolean success;
            if (isDirectory) {
                success = item.mkdir();
                log.append(success ? "Создана директория: " : "Ошибка: ");
            } else {
                success = item.createNewFile();
                log.append(success ? "Создан файл: " : "Ошибка: ");
            }
            log.append(path).append("\n");
        } catch (IOException e) {
            log.append("Ошибка при создании ").append(path).append(": ").append(e.getMessage()).append("\n");
        }
    }

    private static void writeLog() {
        try (FileWriter writer = new FileWriter(GAMES_PATH + "temp/temp.txt")) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Ошибка записи лога: " + e.getMessage());
        }
    }
}
