import FindTopFive.FindTopFive;
import XmlWriter.XmlWriter;
import Model.*;
import JsonReader.*;

import java.io.*;
import java.util.*;

/**
 * Класс с итоговым ДЗ
 * @author Levina Alina
 *
 * Задание 1: Вывести в файл топ 5 продавцов, продавших наибольшее количество товаров
 * Задание 2: Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров
 * Входные данные: JSON
 * ВЫходные данные: XML
 */
public class Main {
    /**
     * Выполняет задания 1 и 2
     * @param args
     */
    public static void main(String[] args) {

        //Десериализация данных
        //файл с продажами
        FileInputStream inputStream;
        List<Sale> saleList = null;
        try {
            inputStream = new FileInputStream("./Data/Sales.json");
            saleList = JsonReader.readSales(inputStream);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println(e);
        }

        //файл с продавцами
        List<Seller> sellerList =null;
        try {
            inputStream = new FileInputStream("./Data/Sellers.json");
            sellerList = JsonReader.readSellers(inputStream);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println(e);
        }

        //Задание 1: Вывести в файл топ 5 продавцов, продавших наибольшее количество товаров
        List<Seller> topSellers = FindTopFive.topFiveSellers(saleList,sellerList);  //получаем топ 5
        File file = new File("./Data/TopFiveSellers.xml");  //файл для вывода данных
        try {
            XmlWriter.writeSellers(topSellers, file);   //сериализуем
        } catch(IOException e){
            System.out.println("Exception: "+e);
        }

        //Задание 2: Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров
        List<Date> topDates = FindTopFive.topFiveDates(saleList);   //получаем топ 5
        file = new File("./Data/TopFiveDates.xml");   //файл для вывода данных
        try {
            XmlWriter.writeDates(topDates, file);   //сериализуем
        } catch (IOException e){
            System.out.println("Exception: "+e);
        }

    }

}