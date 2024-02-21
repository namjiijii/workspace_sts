import javax.print.attribute.standard.PrinterURI;
import java.sql.SQLOutput;

public class Calculate {

    int a;
    int b;
    int sum;
    int max;

    public void setNumber(int num1, int num2){
        this.a = num1;
        this.b = num2;
    }

    public int getSum(){
        sum = a + b;
        return sum;
    }

    public int getMax() {
        if (a > b) {
            max = a;
        }
        else {
            max = b;
        }
        return max;
    }

    public double getAvg(){
        int cnt = 0;
        sum = 0;
        if (a > b) {

            for (int i = b+1; i < a; i++) {
                sum = sum + i;
                cnt++;
            }
        }
        else {

            for (int i = a+1; i < b; i++) {
                sum = sum + i;
                cnt++;
            }
        }
            return (double) sum / cnt;
    }







}
