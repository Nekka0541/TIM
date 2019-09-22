package basicfunctions.collection;

import java.util.ArrayList;

public class CollectionMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Integer> points = new ArrayList<Integer>();
		points.add(10);
		points.add(80);
		points.add(75);
		for(int i : points) {
			System.out.println(i);
		}
	}

}
