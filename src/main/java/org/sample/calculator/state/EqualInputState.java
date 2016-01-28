package org.sample.calculator.state;

import org.sample.calculator.Formula;
import org.sample.calculator.Operation;

/**
 * 計算式の等号入力後状態
 *
 * @author ta_watanabe
 */
public class EqualInputState implements State {

    /**
     * 0〜9入力
     *
     * @param formula 計算式
     * @param number 0〜9
     * @return 計算式入力状態
     */
    @Override
    public State inputNumber(Formula formula, String number) {
        formula.setRight(number);
        return new RightInputState();
    }

    /**
     * 加減乗除演算子入力
     *
     * @param formula 計算式
     * @param operation 演算子
     * @return 計算式入力状態
     */
    @Override
    public State inputOperation(Formula formula, Operation operation) {
        formula.setOperation(operation);
        return this;
    }

    /**
     * 等号入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    @Override
    public State inputEquale(Formula formula) {
        formula.calculate();
        return this;
    }

    /**
     * 小数点入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    @Override
    public State inputDot(Formula formula) {
        return this;
    }

    /**
     * クリア入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    @Override
    public State inputClear(Formula formula) {
        formula.initialize();
        return new NotInputState();
    }

    /**
     * 符号反転入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    @Override
    public State inputNegation(Formula formula) {
        formula.negateToLeft();
        return this;
    }

    /**
     * パーセント入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    @Override
    public State inputPercent(Formula formula) {
        formula.percentToLeft();
        return this;
    }

    /**
     * 表示数値取得
     *
     * @param formula 計算式
     * @return 表示数値
     */
    @Override
    public String getDisplayNumber(Formula formula) {
        return formula.getDisplayNumber();
    }

}
