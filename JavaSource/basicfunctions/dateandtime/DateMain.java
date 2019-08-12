package basicfunctions.dateandtime;

import java.util.Date;

public class DateMain {

	public static void main(String[] args) {
		/**
		 * 引数なしでDateクラスをインスタンス化すると現在日時が格納される
		 */
		Date now = new Date();

		System.out.println(now);
		System.out.println(now.getTime());
		Date past = new Date(1316622225935L);
		System.out.println(past);
	}

}
