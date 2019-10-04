# Dockerfile
Dockerではインフラの構成管理を「Dockerfile」で記述する。
## Dockerfileによる構成管理
### Dockerfileとは
Dockerfileはこのような、Docker上で動作させるコンテナの構成情報を記述するためのファイル。
そのため、次の情報が必要になる
- ベースになるDockerイメージ
- Dockerコンテナないで行った操作（コマンド）
- 環境変数などの設定
- Dockerコンテナ内で動作させておくデーモン実行

***docker build***コマンドは、Dockerfileに記述された構成情報を元にしてDockerイメージを作成します。

### Dockerfileの基本構文
- 「Dockerfile」という名前のテキストファイル
- 拡張子は必要ない
- 直接インフラの構成情報を記述していく
- ファイル名は必ずしも「Dockerfile」である必要はない
    - その場合はイメージをビルドする際に明示的にファイル名を指定する必要がある。

### Dockerfileの作成
Dockerfileでは、「DockerコンテナをどのDockerイメージから生成するか」の情報を、必ず記述する必要がある。
このイメージをベースイメージと呼ぶ、書式は次。

FROM命令
```dockerfile
FROM [イメージ名]
FROM [イメージ名]:[タグ名]
FROM [イメージ名]@[ダイジェスト]

# CentOS7をベースイメージにしたDockerfile
# ベースイメージの設定
FROM centos:centos7

# イメージを一意に特定するときは、ダイジェストを利用する。
# ダイジェストは、DockerHubにアップロードする際に自動で付与される識別子のこと
```

## Dockerfileのビルドとイメージレイヤー
Dockerファイルをビルドすることで、Dockerfileに定義された構成に基づくDockerイメージを作成できる。

### DockerfileからDockerイメージの作成

```sh
$ docker build -t [生成するイメージ名]:[タグ名] [Dockerfileの場所]
```

### Dockerイメージのレイヤー構造
DockerfileをビルドしてDockerイメージを作成すると、Dockerfileの命令ごとにイメージを作成する。
作成された複数のイメージはレイヤー構造になっている。

4つの命令を持つDockerfileの例

```dockerfile
# STEP:1 Ubuntu（ベースイメージ）
FROM ubuntu:latest

# STEP:2 Nginxのインストール
RUN apt-get update && apt-get install -y -q nginx

# STEP:3 ファイルのコピー
COPY index.html /usr/share/nginx/html/

# STEP:4 Nginxの起動
CMD ["nginx", "-g", "daemon off;"]
```

↑の内容のDockerfileと同じディレクトリに「index.html」を配置して、以下のdocker buildコマンドを叩く

```sh
$ docker build -t webap .
```

## マルチステージビルドによるアプリケーション開発
Dockerにはイメージとプロダクション環境（本番環境）で実際に動作させるDockerイメージを同時に作成できる機能がある。
> これを ***マルチステーとビルド***という

※省略　必要なときになったら以下のリンク参照

[Dockerのマルチステージビルドを使う](https://qiita.com/carimatics/items/01663d32bf9983cfbcfe)

## コマンド／デーモンの実行
Dockerfileでコマンドやデーモンの実行方法をまとめる

[Dockerfileのコマンド](https://qiita.com/kmats@github/items/27c09f34aa4d338d40fc)

