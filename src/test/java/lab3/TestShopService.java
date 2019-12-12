package lab3;

import lab3.model.*;
import lab3.service.ShopService;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class TestShopService {

    private ShopService shopService;
    private Shop shop;
    private Goods good1;
    private Goods good2;
    private Goods good3;
    private Goods good4;

    {
        good1 = new Goods.Builder()
                .name("Earrings")
                .code(2432)
                .price(235.75)
                .amount(100)
                .build();

        good2 = new Goods.Builder()
                .name("Phone")
                .code(3684)
                .price(2800)
                .amount(25)
                .build();

        good3 = new Goods.Builder()
                .name("Perfume")
                .code(2409)
                .price(230)
                .amount(50)
                .build();

        good4 = new Goods.Builder()
                .name("Glasses")
                .code(5384)
                .price(399.99)
                .amount(120)
                .build();
    }

    @BeforeMethod
    public void createShop() {
        shop = new Shop();
    }

    @BeforeMethod
    public void createShopService() {
       shopService = new ShopService(shop);
    }

    @Test
    public void sortGoodsByCode() {
        shop.addGood(good2);
        shop.addGood(good1);

        SortedSet<Goods> actual = shopService.sortGoodsByCode();
        SortedSet<Goods> expected = new TreeSet<>();
        expected.add(good1);
        expected.add(good2);

        Assert.assertEquals(expected, actual, "Goods aren't sorted");
    }

    @Test
    public void sortGoodsByCurrency() {
        shop.addGood(good3);
        shop.addGood(good4);

        SortedSet<Goods> actual = shopService.sortGoodsByAmount();
        SortedSet<Goods> expected = new TreeSet<>();
        expected.add(good3);
        expected.add(good4);
        Assert.assertEquals(expected, actual, "Goods aren't sorted");
    }

    @Test
    public void getGoodByTypeTest() {
        shop.addGood(good3);
       shop.addGood(good2);

        SortedSet<Goods> expected = new TreeSet<>();
        expected.add(good2);
        expected.add(good3);

        SortedSet<Goods> actual = shopService.getGoodsByName("Phone");
        Assert.assertEquals(expected, actual);
    }
}