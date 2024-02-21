import java.util.*;

public class TestStudent {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student stu1 = new Student("김자바", 60 , 80);
        Student stu2 = new Student("박자바", 70 , 90);
        Student stu3 = new Student("최자바", 80 , 100);

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        System.out.println("모든 학생 정보 : ");
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }

        System.out.println("총점이 150점 이상인 학생 : ");
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getTotalScore()>=150){
                System.out.println(students.get(i));
            }
        }

        System.out.println("모든 학생에 대한 평균 점수를 출력 : ");
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < students.size(); i++){
            sum = sum + students.get(i).getTotalScore();
            cnt++;
        }
            System.out.println((double)sum / cnt);


        int max = 0;
        int a = 0;
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getTotalScore() > max){
                max = students.get(i).getTotalScore();
                a = i;
            }
        }
        System.out.println("총점이 1등인 학생의 모든 정보를 출력 : " + students.get(a));
    }
}
