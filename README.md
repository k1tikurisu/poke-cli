## Requirements
https://shell.cloud.google.com/?hl=ja

## Build and Setup
```sh
 $ git clone https://github.com/Wakayama-SocSEL/si-seminar-2023-poke-cli.git ~/poke-cli
 $ cd ~/poke-cli
 $ gradle build
 $ source ./scripts/init.sh
 $ poke hello
 # Hello, Poke
```

## Usage
```sh
 # get pokemon name list
 $ poke get --limit=10
 # get pokemon status
 $ poke status --name=pikachu
```