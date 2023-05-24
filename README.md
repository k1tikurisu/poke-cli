# Poke CLI - ポケモン攻略
<p align="center">
  <img src="https://github.com/Wakayama-SocSEL/si-seminar-2023-poke-cli/assets/67625825/42dfb7c1-c1e6-4191-8abe-366a3fe8fa5d" width="80%" />
</p>


## 🌻 サービス概要

Poke CLIは，あたかも勉強しているような真っ黒な画面で，ポケモン攻略を進めることができます．

<br>

### 📖 機能
---

`poke get 数字`
- ポケモンの名前を数字分リスト表示します

`poke status　ポケモン名`
- 指定されたポケモンの種族値を表示します

<br>

## 🛠️ 使ってみる
Web上のツールで動作します．Googleアカウントが必要です．

1. エディタを開く  
https://shell.cloud.google.com/?hl=ja  
にアクセスし，ご自身のGoogleアカウントでログインし，下記の画面になるまで待ってください．
<img width="1920" alt="スクリーンショット 2023-05-24 13 48 32" src="https://github.com/Wakayama-SocSEL/si-seminar-2023-poke-cli/assets/67625825/92b50f1c-40fd-493f-ad22-06b14136dda5">

2. ソースコードをダウンロードする  

<br>

## 📚 課題の例
1つでもチャレンジしてみてください！この例以外でもなんでもOKです

- 日本語名に対応させる （`src/main/resources/locales.json`）を使用してください．
- Poke CLIの使用方法を表示するコマンド， `poke help`　を作成する
- 対応していないコマンド入力があった時にヘルプを表示する
  - 出力例: `poke gaga`と入力された時
  - `poke: 'gaga' is not a poke command. See 'poke help'.`
- コマンド出力をいい感じにする
  - `poke get`コマンドの出力を複数列で表示する
  - 色をおしゃれにする
- コマンドの引数のデフォルト値を用意する
- エラーに対して適切なエラーメッセージを表示させる
- リファクタリング
- その他，あなたがポケモン対戦で欲しい機能/コマンド

<br>

## 📂 フォルダ構成
課題に取り組む人は参考にしてください

```sh
src/main
    ├── resources
    │   └── locales.json # 日英対応のjsonファイル
    └── java/cli
             ├── commands # コマンドごとにフォルダ分け (コマンドが打たれた時に対応するコマンドが実行される)
             │   ├── get
             │   ├── hello # 簡単なコマンドの作り方は，HelloCommand.javaを参考にしてください
             │   └── status
             ├── utils
             │   ├── Logger.java # System.out.printに色をつけるメソッドを提供
             │   └── HttpRequest.java # ポケモンのデータを取得するメソッド
             ├── App.java # CLI.javaを実行する
             └── CLI.java # コマンドの引数によって処理を分岐させる
```

