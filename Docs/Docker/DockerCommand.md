# Dockerコマンド
イメージの操作や、コンテナ起動、停止とかを以下のコマンドにて

## Dockerイメージの操作
- [docker image pull（イメージのダウンロード）](#docker_imege_pull)
- [docker image ls（イメージの一覧表示）](#docker_image_ls)
- [docker image inspect（イメージの詳細確認）](#docker_image_inspect)
### docker image pull（イメージのダウンロード）
構文

```sh
# docker image [オプション] イメージ名[:タグ名]

$ docker image pull centos:7

# タグ名省略で最新版(latest)
$ docker image pull centos

# -aオプションで全てのタグ取得
$ docker imege pull -a centos

# イメージ名にURL指定
$ docker image pull gcr.io/tensorflow/tensorflow
```

### docker image ls（イメージの一覧表示）

構文

```sh
# docker image ls [オプション] [レポジトリ名]

```


### docker image inspect（イメージの詳細確認）

構文

```

```

