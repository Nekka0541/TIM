# コンテナ技術とDockerの概要
- [コンテナ技術の概要](#コンテナ技術の概要)
- [Dockerの概要](#Dockerの概要)
- [Dockerの機能](#Dockerの機能)
- [Dockerが動く仕組み](#Dockerが動く仕組み)

## コンテナ技術の概要
コンテナ技術の概要と歴史について

### コンテナ
コンテナとはホストOS上に論理的な区画を作り、アプリケーションを動作させるのに必要なライブラリやアプリケーションを一つにまとめ、あたかも個別サーバのように使えるようにしたもの

コンテナ技術を使用すると、OSやディレクトリ、IPアドレスなどのシステムリソースを、個々のアプリケーションをあたかも占有しているように見せることができる。

## Dockerの概要

### プログラマにとってのDocker
Webシステムの開発において、アプリケーションをプロダクション環境で稼働させるには次の要素が必要
> プロダクション環境：本番環境

- アプリケーションの実行モジュール
- ミドルウェアやライブラリ群
- OS／ネットワークなどのインフラ環境設定

Dockerではインフラ環境をコンテナとして管理する
- アプリケーションの実行に必要な全てのファイル、ディレクトリ群をコンテナとしてまと目てしまう
- このコンテナの元になるDockerイメージをDocker Hubなどのレポジトリで共有する

## Dockerの機能
Dockerには主に以下の三つの機能がある

- [Dockerイメージを作る機能（Build）](#Dockerイメージを作る機能（Build）)
- [Dockerイメージを共有する機能（Ship）](#Dockerイメージを共有する機能（Ship）)
- [Dockerコンテナを動かす機能（Run）](#Dockerコンテナを動かす機能（Run）)

### Dockerイメージを作る機能（Build）
Dockerは、アプリケーションの実行に必要なプログラム本体／ライブラリ／ミドルウェア／OS／ネットワークの設定などを一つにまとめてDockerイメージを作る。
> 一つのイメージには、一つのアプリケーションのみを入れておき、複数のコンテナを組み合わせてサービスを構築する手法が推奨されてる。

> このDockerイメージは実行環境で動くコンテナのもと（雛形）になる。

Dockerイメージの正体
- アプリケーションの実行に必要なファイル群が格納されたディレクトリ
- Dockerコマンドを使うとイメージをtarファイルに出力できる。

Dockerイメージの作成
- Dockerコマンドを使って手動で作る
- Dockerfileという設定ファイルを作ってそれを元に自動でイメージを作ることもできる。
    - コードによるインフラ構成管理を考えた時Dockerfileを使って管理することが望ましい。
    - Dockerイメージは積み重ねて使うことができる。
        - CentOS->WEBアプリケーションサーバ

### Dockerイメージを共有する機能（Ship）
Docker Hubイメージを共有できるよー

### Dockerコンテナを動かす機能（Run）
Dockerは、Linux上で、コンテナ単位でサーバを動かす。

- Dockerイメージさえあればどこでもコンテナを動かすことができる。
- Dockerイメージから複数のコンテナを動かすこともできる。
- コンテナの起動／停止／破棄はDockerコマンドを使う。

Dockerは一つのLinuxカーネルから複数のコンテナで共有してる。
- コンテナないで動作するプロセスを一つのグループとして管理してグループごとそれぞれにファイルシステムやホスト名／ネットワークなどを割り当てている。
- グループが異なればプロセスやファイルへのアクセスができない。
- この仕組みを使ってコンテナを独立した空間として管理している。
> これらを実現するためにLinuxカーネル機能（namespace,cgroups）が使われている。

### Dockerのコンポーネント
Dockerはいくつかのコンポーネントから構成されている。
基本的にCLI(コマンドライン)からの操作が中心
> さらっとコンポーネントの紹介

- Docker Engine
    - Dockerイメージの作成、コンテナ起動などのコア機能。Dockerコマンドの実行や、Dockerfileによるイメージ生成も行う。
- Docker Registry
    - コンテナのもとになるDockerイメージを公開／共有するためのレジストリ機能(Docker Hub)
- Docker Compose
    - 複数のコンテナの構成情報をコードで定義して、コマンドを実行することでアプリケーションの実行環境を構成するコンテナ群を一元管理するためのツール
- Docker Machine
    - ローカルホスト用のVirtual Boxはじめ,AWS,Azureなどのクラウド環境などにDockerの実行環境をコマンドで自動生成するためのツール
- Docker Swarm
    - 複数のDockerホストをクラスタ化するツール
    - Kubernetesも利用できる。

## Dockerが動く仕組み
Dockerのコア機能がどんな仕組みで動いてるのか

### コンテナを区画化する仕組み（namespace）
namespace=名前空間はまとまったデータに名前をつけて分割することで衝突の可能性を減らして、参照を容易に行う概念
名前に結びつけられた実体は、その名前がどの名前空間にあるのかで一意に定まるもの。

**名前空間が異なれば、同じ名前でも別の実体に対応づけることができる。**

Linuxカーネルのnamespace機能はLinuxのオブジェクトに名前をつけることで、次の6つの独立した環境をこうちくできる。

- PID namespace
    - Linuxで各プロセスに割り当てられたユニークなID
    - PID namespaceはPIDとプロセスを隔離します。
    - namespaceの異なるプロセス同士は、お互いにアクセスできない。

- Network namespace
    - ネットワークリソースを隔離されたnamespaceごとに独立して持つことができる。
    - この機能を使えば、ホストOS上で使用中のポートがあったとしても、コンテナ内で同じ番号のポートを使うことができる。

- UID namespace
    - UID（ユーザーID）,GID（グループID）をnamespaceごとに独立して持つことができる。
    - 例えば、namespace内ではUID/GIDが0であるrootユーザーを、ホストOS上では一般ユーザーとして扱うことができる。
        - namespace内の管理者アカウントは、ホストOSに対しては管理者権限を一切持たない

- MOUNT namespace
    - Linuxではファイルシステムを使うためには、マウントが必要になる。
        - マウントとはコンピュータに接続した機器や記憶装置をOSに認識させて、利用可能な状況にすること
- UTS namespace
- IPC namespace

### リソース管理の仕組み（cgroups）
- Dockerではリソースの割り当てをLinuxのカーネル機能のcgroups機能を使う。
- cgroupsはプロセス、スレッドをグループ化して、そのグループ内に存在するプロセス・スレッドに対して管理を行うための機能
