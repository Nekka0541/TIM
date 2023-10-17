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
   1. 0が表示される
   2. １０が表示される
   3. コンパイルエラーが発生する
   4. 実行時に例外がスローされる
- Answer
  - 3. コンパイルエラーが発生する
- 結果

```PowerShell
PS E:\Users\akira\Documents\TIM\Docs\Java\Silver\Part1> javac .\Q5.java
PS E:\Users\akira\Documents\TIM\Docs\Java\Silver\Part1> java .\Q5.java 
エラー: クラスにmain(String[])メソッドが見つかりません: Q5
PS E:\Users\akira\Documents\TIM\Docs\Java\Silver\Part1> javac .\Q5Impl.java
.\Q5Impl.java:2: エラー: シンボルを見つけられません
public class Q5Impl extends Q5{
                            ^  
  シンボル: クラス Q5
.\Q5Impl.java:4: エラー: シンボルを見つけられません
        System.out.println(num);
                           ^    
  シンボル:   変数 num
  場所: クラス Q5Impl
エラー2個

```
- 解説
  - パッケージとクラスのアクセス制御に関する問題
  - 無名パッケージ（パッケージ宣言しない）に属するクラスは、同じ無名パッケージに属するクラスからしかアクセスできません。
    例　同じ無名パッケージに属するPersonとOffice
    ```java
    class Person {}
    public class Office {
        Person p;
    }
    ```
    - 設問のように明示的にパッケージ宣言をしたクラスからは上記の無名パッケージのクラスを使えず、コンパイルエラーが起きる。