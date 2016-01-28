package org.sample.calculator.state;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;
import org.sample.calculator.Formula;
import org.sample.calculator.Operation;

/**
 * EqualInputStateテストクラス
 *
 * @author ta_watanabe
 */
public class EqualInputStateTest {

    /**
     * 0〜9入力時の次の状態確認
     */
    @Test
    public void inputNumberNextState() {
        State state = new EqualInputState();
        State nextState = state.inputNumber(new Formula(), "0");
        Assert.assertThat(nextState, is(instanceOf(RightInputState.class)));
    }

    /**
     * 加減乗除演算子入力時の次の状態確認
     */
    @Test
    public void inputOperationNextState() {
        State state = new EqualInputState();
        State nextState = state.inputOperation(new Formula(), Operation.ADD);
        Assert.assertThat(nextState, is(instanceOf(EqualInputState.class)));
    }

    /**
     * 等号入力時の次の状態確認
     */
    @Test
    public void inputEqualeNextState() {
        State state = new EqualInputState();
        State nextState = state.inputEquale(new Formula());
        Assert.assertThat(nextState, is(instanceOf(EqualInputState.class)));
    }

    /**
     * 小数点入力時の次の状態確認
     */
    @Test
    public void inputDotNextState() {
        State state = new EqualInputState();
        State nextState = state.inputDot(new Formula());
        Assert.assertThat(nextState, is(instanceOf(EqualInputState.class)));
    }

    /**
     * クリア入力時の次の状態確認
     */
    @Test
    public void inputClearNextState() {
        State state = new EqualInputState();
        State nextState = state.inputClear(new Formula());
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * 符号反転入力時の次の状態確認
     */
    @Test
    public void inputNegationNextState() {
        State state = new EqualInputState();
        State nextState = state.inputNegation(new Formula());
        Assert.assertThat(nextState, is(instanceOf(EqualInputState.class)));
    }

    /**
     * パーセント入力時の次の状態確認
     */
    @Test
    public void inputPercentNextState() {
        State state = new EqualInputState();
        State nextState = state.inputPercent(new Formula());
        Assert.assertThat(nextState, is(instanceOf(EqualInputState.class)));
    }

    /**
     * 0〜9入力時の表示
     */
    @Test
    public void inputNumberDisplay() {
        State state = new EqualInputState();
        Formula formula = new Formula();
        state.inputNumber(formula, "5");
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("0"));
    }

    /**
     * 加減乗除演算子入力時の表示
     */
    @Test
    public void inputOperationDisplay() {
        State state = new EqualInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        state.inputOperation(formula, Operation.ADD);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("1"));
    }

    /**
     * 等号入力時の表示
     */
    @Test
    public void inputEqualeDisplay() {
        State state = new EqualInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        formula.setRight("5");
        formula.setOperation(Operation.ADD);
        state.inputEquale(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("6"));
    }

    /**
     * 小数点入力時の表示
     */
    @Test
    public void inputDotDisplay() {
        State state = new EqualInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        state.inputDot(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("1"));
    }

    /**
     * クリア入力時の表示
     */
    @Test
    public void inputClearDisplay() {
        State state = new EqualInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        state.inputClear(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("0"));
    }

    /**
     * 符号反転入力時の表示
     */
    @Test
    public void inputNegationDisplay() {
        State state = new EqualInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        state.inputNegation(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("-1"));
    }

    /**
     * パーセント入力時の表示
     */
    @Test
    public void inputPercentDisplay() {
        State state = new EqualInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        state.inputPercent(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("0.01"));
    }

}
