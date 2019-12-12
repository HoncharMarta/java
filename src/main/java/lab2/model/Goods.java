package lab2.model;

import java.io.Serializable;
import java.util.Objects;

public class Goods implements Serializable {
    private String name;

    private long code;

    private double price;

    private int amount;

    public static class Builder {
        private String name;

        private long code;

        private double price;

        private int amount;

        public Builder name(String goodName) {
            this.name = goodName;
            return this;
        }

        public Builder code(long goodCode) {
            this.code = goodCode;
            return this;
        }

        public Builder price(double goodPrice) {
            this.price = goodPrice;
            return this;
        }

        public Builder amount(int goodAmount) {
            this.amount = goodAmount;
            return this;
        }

        public Goods build() {
            Goods good = new Goods();

            good.name = this.name;

            good.code = this.code;

            good.price = this.price;

            good.amount = this.amount;

            return good;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return code == goods.code &&
                Double.compare(goods.price, price) == 0 &&
                amount == goods.amount &&
                name.equals(goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, price, amount);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

}
