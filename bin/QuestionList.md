# 問題集

1. 次のうちクラス宣言に含めることができるものを選びなさい（３つ選択）
   1. メソッド
   2. フィールド
   3. インポート宣言
   4. パッケージ宣言
   5. コンストラクタ

2. パッケージに関する説明として正しいものを３つ選択
   1. 名前空間を提供する
   2. パッケージ名にはドメイン名を逆にしたものを使用しなければならない
   3. アクセス制御を提供する
   4. クラスの分類を可能にする
   5. パッケージに属さないクラスもある

3. 以下の中から、パッケージ宣言が正しく記述されているコードを選べ
    ```java
    A
    import java.io.*;
    package aaa;
    public class Sample{}
    B
    package aaa;
    import java.io.*;
    public class Sample{}
    C
    import java.io.*;
    package aaa {
        public class Sample {}
    };
    D
    import java.io.*;
    package aaa (
        public class Sample{}
    );

    ```
    Bっぽ

4. 次のうちインポート宣言をしなくても自動的にインポートされるものはどれか、正しいものを２つ選べ
   1. java.langパッケージに属するクラス
   2. java.langパッケージのうち、StringクラスとSystemクラスの二つだけ
   3. 同じパッケージに属するクラス
   4. サブパッケージに属するクラス

5. 次のプログラムをコンパイル、実行したときの結果として、正しいものを一つ選べ
```java
public class Q5{
    protected int num = 10;
}
package ex5;
public class Q5Impl extends Q5{
    public static void main(String[] args){
        System.out.println(num);
    }
}

```