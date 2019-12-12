package lab2;

import lab2.exception.ConvertException;
import lab2.model.Goods;
import lab2.converter.XmlConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestXmlConverter {

    private XmlConverter<Goods> goodsXmlConverter;
    private Goods goods;

    @BeforeTest
    public void beforeTest() {
        goodsXmlConverter = new XmlConverter<>(Goods.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        goods = new Goods.Builder()
                .name("Earrings")
                .code(2432)
                .price(235.75)
                .amount(100)
                .build();;
    }

    @Test
    public void serializeToStringTest() throws ConvertException {
        String expected = "<Goods><name>Earrings</name><code>2432</code><price>235.75</price><amount>100</amount></Goods>";
        String actual = goodsXmlConverter.serializeToString(goods);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeStringTest() throws ConvertException {
        String xmlString = "<Goods><name>Earrings</name><code>2432</code><price>235.75</price><amount>100</amount></Goods>";
        Goods actual = goodsXmlConverter.deserializeString(xmlString);
        Assert.assertEquals(actual, goods);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeStringTest() throws ConvertException {
        String xmlString = "<Goods><name>Earrings</name><code>2432.8</code><price>235.75</price><amount>100</amount></Goods>";
        goodsXmlConverter.deserializeString(xmlString);
    }

}