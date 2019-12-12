package lab2.converter;

import lab2.exception.ConvertException;
import lab2.model.Goods;
import lab2.converter.Converter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsTextConverter implements Converter<Goods> {

    private final String FIELDS_SEPARATOR = ",";
    private final Integer FIELDS_COUNT = 4;

    private Object[] getGoodsFields(Goods goods) {
        return new Object[]{
                goods.getName(), goods.getCode(), goods.getPrice(), goods.getAmount()
        };
    }

    @Override
    public String serializeToString(Goods goods) throws ConvertException {
        try {
            Object[] goodsFields = getGoodsFields(goods);

            List<String> stringFields = Arrays.stream(goodsFields)
                    .map(Object::toString)
                    .map(o -> o.replace(FIELDS_SEPARATOR, "\\" + FIELDS_SEPARATOR))
                    .collect(Collectors.toList());

            return String.join(FIELDS_SEPARATOR, stringFields);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    @Override
    public Goods deserializeString(String serializedString) throws ConvertException {
        try {
            String[] stringFields = serializedString.split("(?<!\\\\)" + FIELDS_SEPARATOR);

            if (stringFields.length != FIELDS_COUNT) {
                throw new Exception("Invalid format of string!");
            }

            Iterator<String> fieldsIterator = Arrays.stream(stringFields).map(s -> s.replace("\\" + FIELDS_SEPARATOR, FIELDS_SEPARATOR)).iterator();

            return new Goods.Builder()
                    .name(fieldsIterator.next())
                    .code(Long.parseLong(fieldsIterator.next()))
                    .price(Double.parseDouble(fieldsIterator.next()))
                    .amount(Integer.parseInt(fieldsIterator.next()))
                    .build();
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

}