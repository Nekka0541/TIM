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