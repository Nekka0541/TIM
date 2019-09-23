package basicfunctions.dateandtime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		// LocalDateTimeの生成方法
		LocalDateTime l1 = LocalDateTime.now();
		LocalDateTime l2 = LocalDateTime.of(2014, 1,1,9,5,0,0);

		// LocalDateTimeとZonedDateTimeの相互変換
		ZonedDateTime z1 = l2.atZone(ZoneId.of("Europe/London"));
		LocalDateTime l3 = z1.toLocalDateTime();

		// ZonedDateTimeの相互変換前と比較してタイムゾーン情報があるナシを確認
		System.out.println(z1);
		System.out.println(l3);
	}

}
