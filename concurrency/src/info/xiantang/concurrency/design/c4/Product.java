package info.xiantang.concurrency.design.c4;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 15:33
 */
public final class Product {
    private final String no;
    private final String name;
    private final double price;

    public Product(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
