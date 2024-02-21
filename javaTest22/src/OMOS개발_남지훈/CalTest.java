package test;

public class CalTest {
    public static void main(String[] args) {

        Calculate c1 = new Calculate();

        c1.setNumber(10,20);
        c1.getMax();

        System.out.println(c1.getSum());
        System.out.println(c1.getMax());
        System.out.println(c1.getAvg());
    }
}
