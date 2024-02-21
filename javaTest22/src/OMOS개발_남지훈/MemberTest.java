package test;

public class MemberTest {
    public static void main(String[] args) {
        //1. Member 클래스에 대한 객체 생성 후 이름은 ‘자바’, 아이디는 ‘java’, 비밀번호는 ‘abcd1234’, 나이는 ‘20’로 변경
        Member member = new Member();

        member.setInfo("자바", "java", "abcd1234", 20);
        //2. 생성한 객체의 모든 정보를 출력

        member.showInfo();
        //3) isLogin(“java”, “abcd1234”) 실행 시 결과로 ‘로그인 가능’이 출력 되어야 함
        member.isLogin("java", "abcd1234");
        member.isLogin("4654","54654");
    }
}
