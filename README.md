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

http://ec2-52-192-84-7.ap-northeast-1.compute.amazonaws.com:8080/calculator/

AWS EC2にAmazon Linuxのインスタンスを作成し、デプロイしました。

## 仕様

* 加減乗除の操作は一般的な電卓と同じ
* 整数部、小数部、それぞれ10桁を超える入力はできない
* 計算結果で整数部が10桁を超える場合、「E」を表示する
* 0除算の場合、「数値ではありません」を表示する
* 計算結果で小数部が10桁を超える場合、四捨五入で切り捨てる
* セッションタイムアウトは30分

## 工数

20時間


