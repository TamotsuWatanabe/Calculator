package org.sample.calculator.backingbean;

import org.sample.calculator.state.NotInputState;
import org.sample.calculator.state.State;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.sample.calculator.Formula;
import org.sample.calculator.InputBtnLogger;
import org.sample.calculator.Operation;

/**
 * index.xhtmlバッキングビーン
 *
 * @author ta_watanabe
 */
@Named
@ViewScoped
public class IndexBean implements Serializable {

    /**
     * 計算式
     */
    private Formula formula;

    /**
     * 計算式入力状態
     */
    private State state;

    /**
     * 初期化処理
     */
    @PostConstruct
    public void initialize() {
        formula = new Formula();
        state = new NotInputState();
    }

    /**
     * 数値表示処理
     *
     * @return 表示数値
     */
    public String displayNumber() {
        return state.getDisplayNumber(formula);
    }

    /**
     * 0〜9ボタン押下処理
     *
     * @param number
     */
    @InputBtnLogger
    public void inputNumber(String number) {
        state = state.inputNumber(formula, number);
    }

    /**
     * 加減乗除ボタン押下処理
     *
     * @param operation
     */
    @InputBtnLogger
    public void inputOperation(Operation operation) {
        try {
            state = state.inputOperation(formula, operation);
        } catch (ArithmeticException ex) {
            initialize();
            formula.setLeft("数値ではありません");
        }
    }

    /**
     * 等号ボタン押下処理
     *
     */
    @InputBtnLogger
    public void inputEquale() {
        try {
            state = state.inputEquale(formula);
        } catch (ArithmeticException ex) {
            initialize();
            formula.setLeft("数値ではありません");
        }
    }

    /**
     * クリアボタン押下処理
     */
    @InputBtnLogger
    public void inputClear() {
        state = state.inputClear(formula);
    }

    /**
     * 小数点ボタン押下処理
     */
    @InputBtnLogger
    public void inputDot() {
        state = state.inputDot(formula);
    }

    /**
     * 符号反転ボタン押下処理
     */
    @InputBtnLogger
    public void inputNegation() {
        state = state.inputNegation(formula);
    }

    /**
     * パーセントボタン押下処理
     */
    @InputBtnLogger
    public void inputPercent() {
        state = state.inputPercent(formula);
    }
}
