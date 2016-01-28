package org.sample.calculator.state;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;
import org.sample.calculator.Formula;
import org.sample.calculator.Operation;

/**
 * NotInputStateテストクラス
 *
 * @author ta_watanabe
 */
public class NotInputStateTest {

    /**
     * 0〜9入力時の次の状態確認
     */
    @Test
    public void inputNumberNextState() {
        State state = new NotInputState();
        State nextState = state.inputNumber(new Formula(), "0");
        Assert.assertThat(nextState, is(instanceOf(LeftInputState.class)));
    }

    /**
     * 加減乗除演算子入力時の次の状態確認
     */
    @Test
    public void inputOperationNextState() {
        State state = new NotInputState();
        State nextState = state.inputOperation(new Formula(), Operation.ADD);
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * 等号入力時の次の状態確認
     */
    @Test
    public void inputEqualeNextState() {
        State state = new NotInputState();
        State nextState = state.inputEquale(new Formula());
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * 小数点入力時の次の状態確認
     */
    @Test
    public void inputDotNextState() {
        State state = new NotInputState();
        State nextState = state.inputDot(new Formula());
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * クリア入力時の次の状態確認
     */
    @Test
    public void inputClearNextState() {
        State state = new NotInputState();
        State nextState = state.inputClear(new Formula());
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * パーセント入力時の状態確認
     */
    @Test
    public void inputPercentNextState() {
        State state = new NotInputState();
        State nextState = state.inputPercent(new Formula());
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * 符号反転入力時の次の状態確認
     */
    @Test
    public void inputNegationNextState() {
        State state = new NotInputState();
        State nextState = state.inputNegation(new Formula());
        Assert.assertThat(nextState, is(instanceOf(NotInputState.class)));
    }

    /**
     * 0〜9入力時の表示
     */
    @Test
    public void inputNumberDisplay() {
        State state = new NotInputState();
        Formula formula = new Formula();
        state.inputNumber(formula, "5");
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("5"));
    }

    /**
     * 加減乗除演算子入力時の表示
     */
    @Test
    public void inputOperationDisplay() {
        State state = new NotInputState();
        Formula formula = new Formula();
        state.inputOperation(formula, Operation.ADD);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("0"));
    }

    /**
     * 等号入力時の表示
     */
    @Test
    public void inputEqualeDisplay() {
        State state = new NotInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        formula.setRight("5");
        formula.setOperation(Operation.ADD);
        state.inputEquale(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("1"));
    }

    /**
     * 小数点入力時の表示
     */
    @Test
    public void inputDotDisplay() {
        State state = new NotInputState();
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
        State state = new NotInputState();
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
        State state = new NotInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        state.inputNegation(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("1"));
    }

    /**
     * パーセント入力時の表示
     */
    @Test
    public void inputPercentDisplay() {
        State state = new NotInputState();
        Formula formula = new Formula();
        formula.setLeft("1");
        state.inputPercent(formula);
        String actual = state.getDisplayNumber(formula);
        Assert.assertThat(actual, is("1"));
    }

}
