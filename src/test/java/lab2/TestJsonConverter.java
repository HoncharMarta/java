package lab2;

import lab2.model.Goods;
import lab2.converter.JsonConverter;
import lab2.exception.ConvertException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  TestJsonConverter {
    private JsonConverter<Goods> goodsJsonConverter;
    private Goods goods;

    @BeforeTest
    public void BeforeTest() {
        goodsJsonConverter = new JsonConverter<Goods>(Goods.class);
    }

    @BeforeMethod
    public void BeforeMethod() {
        goods = new Goods.Builder()
                .name("Earrings")
                .code(2432)
                .price(235.75)
                .amount(100)
                .build();
    }

    @Test
    public void serializeToString() throws ConvertException {
        String jsonString = "{\"name\":\"Earrings\",\"code\":2432,\"price\":235.75,\"amount\":100}";
        String jsonExpected = goodsJsonConverter.serializeToString(goods);
        Assert.assertEquals(jsonString, jsonExpected);
    }

    @Test
    public void deserializeString() throws ConvertException {
        String jsonString = "{\"name\":\"Earrings\",\"code\":2432,\"price\":235.75,\"amount\":100}";
        Goods goodsExpected = goodsJsonConverter.deserializeString(jsonString);
        Assert.assertEquals(goods, goodsExpected);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeString() throws ConvertException {
        String jsonString = "{\"name\":\"Earrings\",\"code\":,\"price\":235.75,\"amount\":100}";
        goodsJsonConverter.deserializeString(jsonString);
    }
}