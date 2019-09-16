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

プログラム例

```Java

```