# Calculator
Javaで電卓のWebアプリケーションを作成しました。
フレームワークはJava EE7のJSF2.2を使用しております。
ビューはBootstrapとJSFのUIコンポーネントPrimeFacesで構築しました。
テストはJUnit、ロギングライブラリはSLF4JとLogbackで構成しています。

## 開発環境

* JDK8u25
* NetBeans8.1
* GlassFish4.1.1
* Mac OS X

JDK8、NetBeans8.1をインストールすれば、Windows上でも動作します。
GlassFishは、NetBeansインストール時に一緒にインストールすることができます。

## Demo

AWS EC2にAmazon Linuxのインスタンスを作成し、デプロイしました。

~~http://ec2-52-192-217-112.ap-northeast-1.compute.amazonaws.com:1234/calculator/~~
現在停止中

## 仕様

* 加減乗除の操作は一般的な電卓と同じ
* 整数部、小数部、それぞれ10桁を超える入力はできない
* 計算結果で整数部が10桁を超える場合、「E」を表示する
* 0除算の場合、「数値ではありません」を表示する
* 計算結果で小数部が10桁を超える場合、四捨五入で切り捨てる
* セッションタイムアウトは30分

## 状態遷移

電卓のボタン押下イベントによって、以下の処理と状態遷移を行っています。

![状態遷移](https://raw.githubusercontent.com/TamotsuWatanabe/Calculator/master/state.png)

## 工数

20時間