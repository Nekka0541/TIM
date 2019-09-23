package basicfunctions.dateandtime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantandZonedDateTimeSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		// Instantの生成
		Instant i1 = Instant.now();

		// Instantとlong値の相互変換
		Instant i2 = Instant.ofEpochMilli(319202911332L);
		long l = i2.toEpochMilli();

		// ZoneDateTimeの生成
		// 現在日時を取得
		ZonedDateTime z1 = ZonedDateTime.now();
		ZonedDateTime z2 = ZonedDateTime
				.of(2014, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo"));

		// InstantとZonedDateTimeの相互変換
		Instant i3 = z2.toInstant();
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

		// ZonedDateTimeの利用
		System.out.println("東京:" + z2.getYear() + z2.getMonth()
				 + z2.getDayOfMonth());
		System.out.println("ロンドン:" + z3.getYear() + z3.getMonth()
				 + z3.getDayOfMonth());
		if(z2.isEqual(z3)) {
			System.out.println("これらは同じ瞬間を指しています。");
		}


	}
}
