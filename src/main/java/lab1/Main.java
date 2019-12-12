package lab1;


public class Main {

    public static void main(String[] args) {
        Goods good1 = new Goods.Builder()
                .name("milk")
                .code(57657)
                .price(34.2)
                .amount(12)
                .build();

        Goods good2 = new Goods.Builder()
                .name("bread")
                .code(26643)
                .price(11.5)
                .amount(20)
                .build();

        Goods good3 = new Goods.Builder()
                .name("flour")
                .code(57640)
                .price(27.9)
                .amount(10)
                .build();
    }
}
