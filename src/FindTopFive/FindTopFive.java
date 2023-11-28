package FindTopFive;

import Model.Sale;
import Model.Seller;

import java.util.*;

/**
 * Класс для выполнения заданий 1, 2 по поиску топа 5
 */
public class FindTopFive {
    /**
     * Метод для поиска топа 5 продавцов, продавших наибольшее количество товаров.
     * @param saleList список всех продаж
     * @param sellerList список всех продавцов
     * @return список топа 5 продавцов
     */
    public static List<Seller> topFiveSellers(List<Sale> saleList, List<Seller> sellerList){

        //Считаем сумму продаж для каждого продавца и заносим в HashMap
        var sellerSales = new HashMap<Integer, Integer>(); //(sellerId, amount)
        for(Sale s: saleList) {
            int sellerId = s.getSellerId();
            int amount = s.getAmount();
            if(sellerSales.containsKey(sellerId)){
                amount += sellerSales.get(sellerId);
            }
            sellerSales.put(sellerId, amount);
        }

        //Ищем топ 5 и собираем в topSellers
        List<Seller> topSellers = new ArrayList<>();
        sellerSales.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEachOrdered(
                        x -> topSellers.add(Seller.getBySellerId(sellerList, x.getKey()))
                );

        return topSellers;
    }
    /**
     * Метод для поиска топа 5 дат, в которые было продано наибольшее количество товаров.
     * @param saleList список всех продаж
     * @return список топа 5 дат
     */
    public static List<Date> topFiveDates(List<Sale> saleList){

        //Сумма проданных товаров для каждой даты
        var dateSales = new HashMap<Date, Integer>(); //(Date, amount)
        for(Sale s: saleList) {
            Date date = s.getSaleDate();
            int amount = s.getAmount();
            if(dateSales.containsKey(date)){
                amount += dateSales.get(date);
            }
            dateSales.put(date, amount);
        }

        //Топ 5 дат
        var topDates = new ArrayList<Date>();
        dateSales.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEachOrdered(
                        x -> topDates.add(x.getKey())
                );

        return topDates;
    }
}
