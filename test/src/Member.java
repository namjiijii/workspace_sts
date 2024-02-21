import java.sql.SQLOutput;

public class Member {
    private String name;
    private String id;
    private String pw;
    private int age;

    //1) void setInfo(String name, String id, String pw, int age) : 모든 필드의 값을 매개변수로 받은 값으로 변경하는 기
    //능
    public void setInfo(String name, String id, String pw, int age){
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.age = age;
    }



    //2) void showInfo() : 모든 변수의 값을 출력하는 기능
    public void showInfo(){
        System.out.println("이름 : " +name);
        System.out.println("아이디 : " +id);
        System.out.println("비밀번호 : " +pw);
        System.out.println("나이 : " +age);
    }

    boolean isLogin(String id, String pw){
        if (this.id.equals(id)&& this.pw.equals(pw)){
            System.out.println("로그인 가능");
            return true;
        }
        else {
            System.out.println("로그인 불가능");
            return false;
        }
    }


}
