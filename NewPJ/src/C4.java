public class C4 {
    class A{
        private int x;
        private int y;
    }
    class B extends A{
        private int x;
        private int y;
    }
    public class Work{
        public static void main(String[] args) {
            B bp = new B();
            B bp1 = new B(10);
            B bp2 = new B(10, 20);
            B bp3 = new B(10, 20, 30);
            B bp4 = new B(10, 20, 30, 40);



        }
    }
}
