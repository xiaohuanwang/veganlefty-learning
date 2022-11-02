package com.veganlefty.java.enumexample;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/11/2 22:18
 */
public class Burrito {
    Spiciness spiciness;

    public Burrito(Spiciness spiciness) {
        this.spiciness = spiciness;
    }

    public static void main(String[] args) {
        Burrito plain = new Burrito(Spiciness.NOT),
                greenChile = new Burrito(Spiciness.MEDIUM),
                jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }

    public void describe() {
        System.out.println("This burrito is");
        switch (spiciness) {
            case HOT:
                System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot,");
                break;
            case FLAMING:
            default:
                System.out.println("maybe too hot.");
        }
    }
}
