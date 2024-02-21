import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 수 : ");
        int a = sc.nextInt();
        System.out.println("두 번째 수 : ");
        int b = sc.nextInt();
        System.out.println("연산자 : ");
        String c = sc.next();



        if (c.equals("+")){
            System.out.println(a + b);
        }
        else if(c.equals("*")){
            System.out.println(a * b);
        }
        else if(c.equals("-")){
            System.out.println(a - b);
        }
        else if(c.equals("/")){
            System.out.println(a / b);
        }
        else {
            System.out.println("연산자를 잘못 입력하였습니다.");
        }



    }
}
