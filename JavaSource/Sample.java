public class Sample{
    public static void main(String args[]){
        int array[] = new int[5];

        array[4] = 6;
        for (int i=0; i < array.length; i++) {
            System.out.printf("%d目の配列変数arrayの中身は%d\n", i, array[i]);
        }
    }
}