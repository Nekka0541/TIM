public class lesson {
    public static void main(String[] args){
        /**
         * 練習1-1
         * 1から100までの整数をカンマで連結した以下のような文字列sを生成するコードを作成してください
         * 1,2,3...99,100,
         * また、完成した文字列sをカンマで分割してString配列aに格納してください。
         */
        pl1();
    }
    public static void pl1(){
        // 文字列を作成するStringBuilderのインスタンスを作成する
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<100; i++){
            sb.append(i+1).append(",");
        }
        String s = sb.toString();
        System.out.println(s);
    }
}