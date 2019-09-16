package basicfunctions.dateandtime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Instant i1 = Instant.now();

		// Instantとlong値の相互変換
		Instant i2 = Instant.ofEpochMilli(319202911332L);
		long l = i2.toEpochMilli();

		// ZoneDateTimeの生成
		ZonedDateTime z1 = ZonedDateTime.now();
		ZonedDateTime z2 = ZonedDateTime
				.of(2014, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo"));

		// InstantとZonedDateTimeの相互変換
		Instant i3 = z2.toInstant();
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

	}

}
