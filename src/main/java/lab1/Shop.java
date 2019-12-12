package lab1;


import java.util.List;
import java.util.Objects;


public class Shop {
    private String city;

    private String address;

    private List<Goods> goods;

    private String manager;

    private int number_of_employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return number_of_employees == shop.number_of_employees &&
                Objects.equals(city, shop.city) &&
                Objects.equals(address, shop.address) &&
                Objects.equals(goods, shop.goods) &&
                Objects.equals(manager, shop.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, address, goods, manager, number_of_employees);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "city='" + city + '\'' +
                ", adress='" + address + '\'' +
                ", goods=" + goods +
                ", manager='" + manager + '\'' +
                ", number_of_employees=" + number_of_employees +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getNumber_of_employees() {
        return number_of_employees;
    }

    public void setNumber_of_employees(int number_of_employees) {
        this.number_of_employees = number_of_employees;
    }

}
