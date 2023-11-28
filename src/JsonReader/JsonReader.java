package JsonReader;
import Model.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Класс для десериализации json файлов
 */
public class JsonReader {
    /**
     * Десериализует файл с данными о продажах
     * @param inputStream поток из файла с данными о продажах
     * @return список объектов Sale с данными о продажах
     * @throws IOException исключение при чтении из потока
     */
    public static List<Sale> readSales(FileInputStream inputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(inputStream, new TypeReference<>() {});
    }
    /**
     * Десериализует файл с данными о продавцах
     * @param inputStream поток из файла с данными о продавцах
     * @return список объектов Seller с данными о продавцах
     * @throws IOException исключение при чтении из потока
     */
    public static List<Seller> readSellers(FileInputStream inputStream) throws IOException  {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(inputStream, new TypeReference<>() {});
    }
}
