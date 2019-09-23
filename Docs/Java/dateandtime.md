# 目次
- [日付と時間の取り扱い](#日付と時間の取り扱い)
- [従来型APIが抱える課題](#従来型APIが抱える課題)
- [TimeAPI](#TimeAPI)


# 日付と時間の取り扱い
Java APIの中でもとりわけ利用頻度の高いクラスとして、日付や時間に関連するクラスが存在する。

- Dateクラス
	- Javaで時刻情報を取り扱う場合に標準的に利用される
	- java.utilパッケージに属している。
	- 内部にエポック（基準時刻である1970年元日〇時ちょうど）からの経過ミリ秒数をlong値で保持する。
	- newにて引数なしでインスタンス化すると、現在の日時情報が格納される。
	- newにてlong値を引数として渡しインスタンス化すると、指定時刻の情報が格納される。
	- getTime()やsetTime()を用いて、インスタンス内に保持するlong値を取得・設定できる。

プログラム例

```Java
package basicfunctions.dateandtime;

import java.util.Date;

public class DateMain {

	public static void main(String[] args) {
		// 引数なしでDateクラスをインスタンス化すると現在日時が格納される
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		Date past = new Date(1316622225935L);
		System.out.println(past);
	}
}
```

# 従来型APIが抱える課題

DateやCalenderクラスが抱えている代表的課題が二つある

- 使い方が紛らわしいAPIが存在する
- 並列処理で用いるとインスタンスの内容が壊れることがある

例えばCalenderを用いて「月」の情報を取得・設定する場合、1~12ではなく0~11で指定することになってたり。。。

> DateやCalenderの機能的な限界

- 最小でも「ミリ秒単位」でしか時間を扱えない
- 「あいまいな日時」を表せない
- 「時間の幅」を表せない

# TimeAPI

前項の「従来型APIが抱える課題」を克服するためJava8から新しいAPIがjava.timeパッケージとして加わった。

java8でjava.timeパッケージに加わった代表的なクラス

|クラス名|機能と役割|
| --- | --- |
| Instant | 世界における、ある「瞬間」の時刻を、ナノ秒単位で厳密に指し示し、保持する。|
| ZonedDateTime | |
| LocalDateTime | 日常的に使われる「曖昧な日時」を保持する。|
| Duration | ２つの異なる時刻や日付の期間を保持する。|
| Period | |


Instant,ZonedDateTimeクラス使用例

```Java
package basicfunctions.dateandtime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeMain {

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

```