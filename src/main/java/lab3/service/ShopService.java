package lab3.service;

import lab3.model.Goods;
import lab3.model.Shop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class ShopService {
    private Shop shop;

    public  ShopService(Shop shop) {
        this.shop = shop;
    }

    public SortedSet<Goods> getGoodsByName(String goodName) {
        SortedSet<Goods> sortedGoods = new TreeSet<>();
        Shop result = new Shop();
        shop.getGood().stream()
                .filter(c -> c.getName().equals(goodName))
                .forEach(result::addGood);

        sortedGoods.addAll(shop.getGood());
        return sortedGoods;
    }

    public SortedSet<Goods> sortGoodsByCode() {
        SortedSet<Goods> sortedGoods = new TreeSet<>((a, b) -> b.compareTo(a));
        sortedGoods.addAll(shop.getGood());
        return sortedGoods;
    }

    public SortedSet<Goods> sortGoodsByAmount() {
        SortedSet<Goods> sortedGoods = new TreeSet<>(Comparator.comparing(Goods::getAmount));
        sortedGoods.addAll(shop.getGood());
        return sortedGoods;
    }

}
