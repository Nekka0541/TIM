public class Huga {
    public static void main(String[] args){
        Hoge hoge = new Hoge();
        String str = hoge.hogehoge("test");
        System.out.println("コンストラクタで生成:" + hoge.piyo);
        System.out.println("staticメソッドで生成:" + str);
    }
}
