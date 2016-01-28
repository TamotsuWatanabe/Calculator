package org.sample.calculator.state;

import org.sample.calculator.Formula;
import org.sample.calculator.Operation;

/**
 * 計算式入力状態抽象クラス
 *
 * @author ta_watanabe
 */
public interface State {

    /**
     * 0〜9入力
     *
     * @param formula 計算式
     * @param number 0〜9
     * @return 計算式入力状態
     */
    public State inputNumber(Formula formula, String number);

    /**
     * 加減乗除演算子入力
     *
     * @param formula 計算式
     * @param operation 演算子
     * @return 計算式入力状態
     */
    public State inputOperation(Formula formula, Operation operation);

    /**
     * 等号入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    public State inputEquale(Formula formula);

    /**
     * 小数点入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    public State inputDot(Formula formula);

    /**
     * クリア入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    public State inputClear(Formula formula);

    /**
     * 符号反転入力
     *
     * @param formula 計算式
     * @return 計算式入力状態
     */
    public State inputNegation(Formula formula);

    /**
     * パーセント入力
     *
     * @param formula 計算式
     * @return
     */
    public State inputPercent(Formula formula);

    /**
     * 表示数値取得
     *
     * @param formula 計算式
     * @return 表示数値
     */
    public String getDisplayNumber(Formula formula);

}
