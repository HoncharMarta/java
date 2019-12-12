package lab4.model;

import lab4.validation.MinPrice;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;;

import java.util.HashSet;
import java.util.Objects;
import javax.validation.constraints.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.io.Serializable;
import java.util.Set;

@JsonDeserialize(builder = Goods.Builder.class)
public class Goods implements Serializable {

    @NotNull(message = "must be not null")
    @Size(min = 1, max = 20, message = "must be not empty")
    private String name;

    @NotNull(message = "must be not null")
    @Digits(integer = 8, fraction = 0, message = "code should have 8 digits")
    private long code;

    @NotNull(message = "must be not null")
    @MinPrice(value = 0, message = "price can't be negative")
    private double price;

    @NotNull(message = "must be not null")
    @Min(value = 0, message = "can't be negative")
    private int amount;

    private Goods() {}

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

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        Goods good;

        public Builder() {
            good = new Goods();
        }

        public Builder setName(String goodName) {
            good.name = goodName;
            return this;
        }

        public Builder setCode(long goodCode) {
            good.code = goodCode;
            return this;
        }

        public Builder setPrice(double goodPrice) {
            good.price = goodPrice;
            return this;
        }

        public Builder setAmount(int goodAmount) {
            good.amount = goodAmount;
            return this;
        }

        public Goods build() throws IllegalStateException {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Goods>> constraintViolations = validator.validate(good);

            if (constraintViolations.size() > 0) {
                Set<String> exceptionDetails = new HashSet<>();
                for (ConstraintViolation<Goods> violation : constraintViolations) {
                    exceptionDetails.add(violation.getPropertyPath().toString() + " " + violation.getMessage());
                }
                throw new IllegalStateException(exceptionDetails.toString());
            }
            return good;
        }
    }

}
