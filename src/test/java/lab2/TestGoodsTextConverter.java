package lab2;

import lab2.exception.ConvertException;
import lab2.model.Goods;
import lab2.converter.GoodsTextConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestGoodsTextConverter {

    private GoodsTextConverter GoodsTextConverter;
    private Goods goods;

    {
        GoodsTextConverter = new GoodsTextConverter();
    }

    @BeforeMethod
    public void beforeMethod() {
        goods = new Goods.Builder()
                .name("Earrings")
                .code(2432)
                .price(235.75)
                .amount(100)
                .build();
    }

    @Test
    public void serializeToStringTest() throws ConvertException {
        String expected = "Earrings,2432,235.75,100";
        String actual = GoodsTextConverter.serializeToString(goods);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeStringTest() throws ConvertException {
        String serialized = "Earrings,2432,235.75,100";
        Goods actual = GoodsTextConverter.deserializeString(serialized);
        Assert.assertEquals(actual, goods);
    }


    @DataProvider
    public Object[][] negativeDeserializeStringDataProvider() {
        return new Object[][]{
                {"Earrings,2432,235.75,100.2"},
                {"Earrings,2432.4,235.75,100"},
                {"Earrings,2432,235.75"}
        };
    }

    @Test(expectedExceptions = ConvertException.class, dataProvider = "negativeDeserializeStringDataProvider")
    public void negativeDeserializeStringTest(String serializedString) throws ConvertException {
        GoodsTextConverter.deserializeString(serializedString);
    }
}