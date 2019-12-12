package lab4;

import lab4.model.Goods;
import org.testng.annotations.Test;

public class TestGoods {

    @Test(expectedExceptions = IllegalStateException.class)
    public void testBuilder() {
        Goods good = new Goods.Builder()
                .setAmount(2836249)
                .setPrice(199.6)
                .build();
    }

    @Test
    public void testMinBalanceValidator() {
        Goods card = new Goods.Builder()
                .setName("Bag")
                .setCode(44438732)
                .setPrice(850.5)
                .setAmount(11)
                .build();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testMinBalanceValidatorNegative() {
        Goods card = new Goods.Builder()
                .setName("Bag")
                .setCode(448732)
                .setPrice(-850.5)
                .setAmount(6)
                .build();
    }

}