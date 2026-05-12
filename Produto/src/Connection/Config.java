package Connection;

import java.io.FileNotFoundException;
import java.util.Properties;

public class Config {

    private static final Properties prop =
            new Properties();

    static {

        try (
                var input =
                        Config.class
                                .getClassLoader()
                                .getResourceAsStream("config.properties")
        ) {
            if (input == null) {
                throw new FileNotFoundException("config.properties não encontrado");
            }
            prop.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar config.properties", e);
        }
    }

    public static String getDbUrl() {
        return prop.getProperty("db.url");
    }
}