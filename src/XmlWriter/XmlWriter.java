package XmlWriter;

import Model.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.*;

/**
 * Класс для сериализации данных в xml файлы
 */
public class XmlWriter {
    /**
     * Сериализует данные о датах
     * @param dateList список с датами
     * @param out файл, в которых будут записаны данные
     * @throws IOException исключение при выводе данных
     */
    public static void writeDates(List<Date> dateList, File out) throws IOException{
            XmlMapper xmlMapper = new XmlMapper();
            //Устанавливаем формат, в котором будут записаны даты
            xmlMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            FileWriter fileWriter = new FileWriter(out);

            //корневой элемент
            fileWriter.write("<Dates>");

            // запись в файл
            String xmlString;
            for(Date d: dateList) {
                xmlString = xmlMapper.writeValueAsString(d);
                fileWriter.write(xmlString);
            }
            fileWriter.write("</Dates>");

            fileWriter.close();
    }
    /**
     * Сериализует данные о продавцах
     * @param sellerList список с продавцами
     * @param out файл, в которых будут записаны данные
     * @throws IOException исключение при выводе данных
     */
    public static void writeSellers(List<Seller> sellerList, File out) throws IOException{

            XmlMapper xmlMapper = new XmlMapper();
            FileWriter fileWriter = new FileWriter(out);

            //корневой элемент
            fileWriter.write("<Sellers>");

            //запись в файл
            String xmlString;
            for(Seller s: sellerList) {
                xmlString = xmlMapper.writeValueAsString(s);
                fileWriter.write(xmlString);
            }
            fileWriter.write("</Sellers>");

            fileWriter.close();
    }
}
