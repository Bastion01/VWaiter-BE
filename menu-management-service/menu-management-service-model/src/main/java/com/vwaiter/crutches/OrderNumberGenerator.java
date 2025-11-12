package com.vwaiter.crutches;

/**
 * Just for fun
 */
public class OrderNumberGenerator {
    private static OrderNumberGenerator orderNumberGenerator;
    private static int counter = 1;
    private OrderNumberGenerator(){}

    public static OrderNumberGenerator getOrderNumberGenerator() {
        if (orderNumberGenerator == null) {
            orderNumberGenerator = new OrderNumberGenerator();
        }
        return orderNumberGenerator;
    }

    public static void incrementInMemoryCounter() {
        counter++;
    }

    public int getOrderNumber() {
        return counter;
    }
}
