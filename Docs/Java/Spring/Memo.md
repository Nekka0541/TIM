# springのメモリスト

- [springのメモリスト](#springのメモリスト)
  - [ディレクトリ構成](#ディレクトリ構成)
  - [よく使う？アノテーション](#よく使うアノテーション)
    - [@RestController](#restcontroller)
    - [@GetMapping](#getmapping)
    - [@RequestParam](#requestparam)
    - [@PathVariable](#pathvariable)
    - [@PostMapping](#postmapping)
  - [Thymeleaf](#thymeleaf)

## ディレクトリ構成
- src/main/resources
  - static
    - CSSとか、内容が変化しな静的なファイルを格納するフォルダ
  - templates
    - 処理結果画面など、内容が動的に変化するファイルを格納するフォルダ
  - application.properties
    - DB接続情報など、プロジェクト全般にかかわる設定情報を記述するファイル。

## よく使う？アノテーション

### @RestController
- 「コントローラー クラス の メソッド で 処理 し た 結果 を、 そのまま レスポンス として ブラウザ へ 送信 する」 こと を 表す アノテーション
- 本来はJSON、XMLなどを返す「RESTインターフェース」で使う。
- テキストを返す機能としても流用できる。

### @GetMapping
- GETリクエストに対応するメソッドであることを示すアノテーション
- GETリクエストはサーバーへリクエストを送る方法の一つ。(例：http://localhost:8080/hello でサーバーにGETリクエストが送信される。)
- このアノテーションがついたメソッドの引数には処理対象とする「URLのパス名」を書くことで、対象のGETリクエストが送られてきたら自動的に呼び出される。
```java
	@GetMapping("/hello")
	public String sayHello() {
		return "みなさん　こんにちは!";
	}

// 引数{name}はURLパスから値として取り出す部分を指定するもの「URIテンプレート変数」
// ※この場合、URLパスが/hello3/Jamesなら、nameという名前で"James"を取り出す。
  @GetMapping("/hello/{name}")
	public String sayHello(@PathVariable("name")String name) {
		return "Hello, world!" + "こんにちは" + name + "さん！";
	}
```

### @RequestParam
- 引数で指定されたパラメータの値を、メソッド実行前にクエリ文字列から取得し、メソッド引数へセット（バインド）する。
- 引数はクエリ文字列のパラメータ名と一致させる必要がある。
```java
@RestController
public class Hello2Controller {
	@GetMapping("hello2")
	public String sayhello(@RequestParam("name") String name) {
		return "Hello World!" + "こんにちは" + name + "さん！";
	}
  // パラメータが複数ある時はその分メソッド引数を追加する。
  public String sayhello(@RequestParam("name") String name, @RequestParam("age") int age) {
  }
    // バインドさ荒れる引数名と@RequestParamの名称が同一の場合、アノテーションの記載は省略可能
  public String sayhello(@RequestParam("name") String name, @RequestParam("age") int age) {
  }
  ↓
  public String sayhello(String name, int age) {
  }
}
```

### @PathVariable
- URIテンプレート変数の値をメソッド引数にセット（バインド）する。
- PathVariableの値はURIテンプレート変数名と一致させる必要がある。
```java
	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable("name")String name) {
		return "Hello, world!" + "こんにちは" + name + "さん！";
	}
```

> Submitボタンは自分が属しているform要素に入力された内容をクエリ文字列形式にしてサーバーへ送信します

### @PostMapping
- POSTリクエストを処理するメソッドということを表す。
- フォームに入力された値はGETと同じくクエリ文字列形式（パラメータ名＝パラメータ値）の為、@RequestParamで受け取る
```java
	@PostMapping("hello4")
	public String sayHello(@RequestParam("name")String name) {
		return "Hello, world!" + "こんにちは" + name + "さん";
	}
```

## Thymeleaf
- htmlでの使い方
```html
<!-- hello.html -->
<!DOCTYPE html>
<!-- Thymeleaf使うよ！宣言（th:～属性をthymeleafとする。） -->
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
<!-- th:text　thymeleafがこの属性を見つけると、右辺の中に書かれている変数の値をタグのテキストに変換する。 -->
Hello,world!こんにちは<span th:text="${name}"></span>さん
</body>
</html>
```

- java
```java
// Thymeleafが処理したテンプレート（HTML）を返す際にはRestではなく,@Controllerを使う
@Controller
public class Hello5Controller {
	@GetMapping("/hello5")
	public ModelAndView sayHello(@RequestParam("name")String name, ModelAndView mv){
    // ModelAndViewオブジェクト：「モデル」と「ビュー名」を保持するクラス
    // ビュー名：次に表示する画面名、モデル：ビューで使用するデータ
    // setViewName()はビュー名を設定する。※Thymeleafは設定されたビュー名+拡張子".html"を追加したファイルをtemplates配下から探す。
		mv.setViewName("hello");
    // addObject()はオブジェクトに設定されたビューが使うデータを渡す。
    // 第一引数はThymeleafで設定された変数名、第二引数にはデータ
		mv.addObject("name", name);
    // 最後にビュー名とモデルをセットしたmvをreturnして、mvがthymeleafに渡されて、処理が実行される。
		return mv;
	}
}
```