# Poke CLI - ポケモン攻略ツール
<p align="center">
  <img src="https://github.com/Wakayama-SocSEL/si-seminar-2023-poke-cli/assets/67625825/42dfb7c1-c1e6-4191-8abe-366a3fe8fa5d" width="80%" />
</p>


## 🌻 サービス概要
勉強しなければいけないけれど，ポケモンをしたい．  
Poke CLIは，あたかも勉強しているような真っ黒な画面で，ポケモン攻略を進めることができます．

<br>

### 📖 機能
---

`poke get 数字`
- ポケモンの名前を数字分リスト表示します

`poke status　ポケモン名`
- 指定されたポケモンの種族値を表示します

<br>

## 🎠 使ってみる
Web上のツールで動作します．Googleアカウントが必要です．

1. エディタを開く  
下記にアクセスしてください  
[![Open in Cloud Shell](https://gstatic.com/cloudssh/images/open-btn.svg)](https://ide.cloud.google.com/?cloudshell_git_repo=https://github.com/SocSEL-SIseminar1-2023/poke-cli.git&cloudshell_workspace=./&cloudshell_tutorial=README.md)


<br>

2. pokeコマンドを使えるようにする  
上の，Terminal > New Terminalでターミナルを開き,   
`source ./scripts/init.sh`  
を打ってください．出力は何もないです．

3. 実行する  
Terminal > Run Build Taskを押して，コンパイルしてください  
ターミナルに，`poke hello`と入力してください．`Hello, Poke CLI`と出力されたら環境構築完了です.  
開発する際は，ソースコードを変更する>Run Build Taskをする> pokeコマンドを打って動作確認する．の手順で行ってください  
gitを使うのが難しい方は，Cloud shell editor上で動作確認して，GitHub上でソースコードをコピペするといいと思います

<br>

## 📚 課題の例
1つでもチャレンジしてみてください！この例以外でもなんでもOKです

- Poke CLIの使用方法を表示するコマンド， `poke help`　を作成する
  - helloコマンドが参考になると思います
- 対応していないコマンド入力があった時にヘルプを表示する
  - 出力例: `poke gaga`と入力された時
  - `poke: 'gaga' is not a poke command. See 'poke help'.`
- コマンド出力をいい感じにする
  - `poke get`コマンドの出力を複数列で表示する
  - 色をおしゃれにする
- コマンドの引数のデフォルト値を用意する
- エラーに対して適切なエラーメッセージを表示させる
- リファクタリング
- 日本語名に対応させる （`src/main/resources/locales.json`）を使用してください．
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

## 🐕‍🦺 Poke API
新しい機能を実装する場合は，下記ドキュメントを参考にしてください．  
https://pokeapi.co/docs/v2  
取得したい情報のGETのURLをHttpRequestクラスに入力すると，データを取得できます．既存の実装も参考にしてください．

