package org.sample.calculator;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 計算式クラス
 *
 * @author ta_watanabe
 */
@Getter
@Setter
public class Formula {

    /**
     * 左辺
     */
    private String left;

    /**
     * 右辺
     */
    private String right;

    /**
     * 演算子
     */
    private Operation operation;

    /**
     * コンストラクタ
     */
    public Formula() {
        initialize();
    }

    /**
     * 初期化処理
     */
    public void initialize() {
        left = "0";
        right = "";
        operation = Operation.NONE;
    }

    /**
     * 演算
     */
    public void calculate() {
        if (right.isEmpty()) {
            right = left;
        }
        left = operation.apply(new BigDecimal(left), new BigDecimal(right)).toPlainString();
    }

    /**
     * 左辺の符号反転
     */
    public void negateToLeft() {
        left = new BigDecimal(left).negate().toPlainString();
    }

    /**
     * 右辺の符号反転
     */
    public void negateToRight() {
        right = new BigDecimal(right).negate().toPlainString();
    }

    /**
     * 左辺のパーセント変換
     */
    public void percentToLeft() {
        left = new BigDecimal(left).divide(new BigDecimal(100)).toPlainString();
    }

    /**
     * 右辺のパーセント変換
     */
    public void percentToRight() {
        right = new BigDecimal(right).divide(new BigDecimal(100)).toPlainString();
    }

    /**
     * 左辺の小数点入力
     */
    public void dotToLeft() {
        if (left.contains(".")) {
            return;
        }
        left += ".";
    }

    /**
     * 右辺の小数点入力
     */
    public void dotToRight() {
        if (right.contains(".")) {
            return;
        }
        right += ".";
    }

    /**
     * 左辺に連結
     *
     * @param number 数値
     */
    public void concatToLeft(String number) {
        if (left.contains(".")) {
            String[] numbers = left.split("\\.");
            // 少数部10桁まで
            if (numbers.length >= 2 && numbers[1].length() >= 10) {
                return;
            }
        } else if (left.length() >= 10) {
            // 整数部10桁まで
            return;
        }
        if (left.equals("0")) {
            left = number;
        } else {
            left += number;
        }
    }

    /**
     * 右辺に連結
     *
     * @param number 数値
     */
    public void concatToRight(String number) {
        if (right.contains(".")) {
            String[] numbers = right.split("\\.");
            // 少数部10桁まで
            if (numbers.length >= 2 && numbers[1].length() >= 10) {
                return;
            }
        } else if (right.length() >= 10) {
            // 整数部10桁まで
            return;
        }
        if (right.equals("0")) {
            right = number;
        } else {
            right += number;
        }
    }

    /**
     * 表示数値取得
     *
     * @return 表示数値
     */
    public String getDisplayNumber() {
        // 整数部、少数部、いずれかが10桁を超えた場合、エラー表示
        String[] numbers = left.split("\\.");
        for (String num : numbers) {
            if (num.length() > 10) {
                return "E";
            }
        }
        return left;
    }
}
