package org.sample.calculator.state;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;
import org.sample.calculator.Formula;
import org.sample.calculator.Operation;

/**
 * RightInputStateテストクラス
 *
 * @author ta_watanabe
 */
public class RightInputStateTest {

    /**
     * 0〜9入力時の次の状態確認
     */
    @Test
    public void inputNumberNextState() {
        State state = new RightInputState();
        State nextState = state.inputNumber(new Formula(), "0");
        Assert.assertThat(nextState, is(instanceOf(RightInputState.class)));
    }

    /**
     * 加減乗除演算子入力時の次の状態確認
     */
    @Test
    public void inputOperationNextState() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setOperation(Operation.ADD);
        State nextState = state.inputOperation(formula, Operation.ADD);
        Assert.assertThat(nextState, is(instanceOf(OperationInputState.class)));
    }

    /**
     * 等号入力時の次の状態確認
     */
    @Test
    public void inputEqualeNextState() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setOperation(Operation.ADD);
        State nextState = state.inputEquale(formula);
        Assert.assertThat(nextState, is(instanceOf(EqualInputState.class)));
    }

    /**
     * 小数点入力時の次の状態確認
     */
    @Test
    public void inputDotNextState() {
        State state = new RightInputState();
        State nextState = state.inputDot(new Formula());
        Assert.assertThat(nextState, is(instanceOf(RightInputState.class)));
    }

    /**
     * クリア入力時の次の状態確認
     */
    @Test
    public void inputClearNextState() {
        State state = new RightInputState();
        State nextState = state.inputClear(new Formula());
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * 符号反転入力時の次の状態確認
     */
    @Test
    public void inputNegationNextState() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setRight("1");
        State nextState = state.inputNegation(formula);
        Assert.assertThat(nextState, is(instanceOf(RightInputState.class)));
    }

    /**
     * パーセント入力時の状態確認
     */
    @Test
    public void inputPercentNextState() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setRight("1");
        State nextState = state.inputPercent(formula);
        Assert.assertThat(nextState, is(instanceOf(RightInputState.class)));
    }

    /**
     * 0〜9入力時の表示
     */
    @Test
    public void inputNumberDisplay() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setRight("1");
        state.inputNumber(formula, "5");
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("15"));
    }

    /**
     * 加減乗除演算子入力時の表示
     */
    @Test
    public void inputOperationDisplay() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        formula.setRight("5");
        formula.setOperation(Operation.ADD);
        state.inputOperation(formula, Operation.ADD);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("5"));
    }

    /**
     * 等号入力時の表示
     */
    @Test
    public void inputEqualeDisplay() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        formula.setRight("5");
        formula.setOperation(Operation.ADD);
        state.inputEquale(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("5"));
    }

    /**
     * 小数点入力時の表示
     */
    @Test
    public void inputDotDisplay() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setRight("1");
        state.inputDot(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("1."));
    }

    /**
     * クリア入力時の表示
     */
    @Test
    public void inputClearDisplay() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        formula.setRight("1");
        state.inputClear(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is(""));
    }

    /**
     * 符号反転入力時の表示
     */
    @Test
    public void inputNegationDisplay() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setRight("1");
        state.inputNegation(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("-1"));
    }

    /**
     * パーセント入力時の表示
     */
    @Test
    public void inputPercentDisplay() {
        State state = new RightInputState();
        Formula formula = new Formula();
        formula.setRight("1");
        state.inputPercent(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("0.01"));
    }

}
