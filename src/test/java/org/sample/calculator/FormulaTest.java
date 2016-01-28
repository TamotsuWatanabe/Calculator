package org.sample.calculator;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Formulaテストクラス
 *
 * @author ta_watanabe
 */
public class FormulaTest {

    /**
     * 加算確認
     */
    @Test
    public void calculateAdd() {
        Formula formula = new Formula();
        formula.setLeft("4");
        formula.setRight("50");
        formula.setOperation(Operation.ADD);
        formula.calculate();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("54"));
    }

    /**
     * 減算確認
     */
    @Test
    public void calculateSub() {
        Formula formula = new Formula();
        formula.setLeft("4");
        formula.setRight("50");
        formula.setOperation(Operation.SUB);
        formula.calculate();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("-46"));
    }

    /**
     * 乗算確認
     */
    @Test
    public void calculateMul() {
        Formula formula = new Formula();
        formula.setLeft("4");
        formula.setRight("50");
        formula.setOperation(Operation.MUL);
        formula.calculate();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("200"));
    }

    /**
     * 除算確認
     */
    @Test
    public void calculateDiv() {
        Formula formula = new Formula();
        formula.setLeft("4");
        formula.setRight("50");
        formula.setOperation(Operation.DIV);
        formula.calculate();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("0.08"));
    }

    /**
     * 左辺に整数11桁目が連結できないことを確認
     */
    @Test
    public void concat11IntegerToLeft() {
        Formula formula = new Formula();
        formula.setLeft("1234567890");
        formula.concatToLeft("1");
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("1234567890"));
    }

    /**
     * 右辺に整数11桁目が連結できないことを確認
     */
    @Test
    public void concat11IntegerToRight() {
        Formula formula = new Formula();
        formula.setRight("1234567890.0987654321");
        formula.concatToRight("1");
        String actual = formula.getRight();
        Assert.assertThat(actual, is("1234567890.0987654321"));
    }

    /**
     * 左辺に小数11桁目が連結できないことを確認
     */
    @Test
    public void concat11DecimalToLeft() {
        Formula formula = new Formula();
        formula.setLeft("1234567890.0987654321");
        formula.concatToLeft("1");
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("1234567890.0987654321"));
    }

    /**
     * 右辺に小数11桁目が連結できないことを確認
     */
    @Test
    public void concat11DecimalToRight() {
        Formula formula = new Formula();
        formula.setRight("1234567890");
        formula.concatToRight("1");
        String actual = formula.getRight();
        Assert.assertThat(actual, is("1234567890"));
    }

    /**
     * 左辺に0が入っているとき、0が上書きされることを確認
     */
    @Test
    public void concatToLeftOverwriteZero() {
        Formula formula = new Formula();
        formula.setLeft("0");
        formula.concatToLeft("1");
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("1"));
    }

    /**
     * 右辺に0が入っているとき、0が上書きされることを確認
     */
    @Test
    public void concatToRightOverwriteZero() {
        Formula formula = new Formula();
        formula.setRight("0");
        formula.concatToRight("1");
        String actual = formula.getRight();
        Assert.assertThat(actual, is("1"));
    }

    /**
     * 左辺に小数点がないとき、小数点が入力されることを確認
     */
    @Test
    public void inputDotToLeft() {
        Formula formula = new Formula();
        formula.setLeft("11");
        formula.dotToLeft();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("11."));
    }

    /**
     * 左辺に小数点があるとき、小数点が入力されないことを確認
     */
    @Test
    public void notInputDotToLeft() {
        Formula formula = new Formula();
        formula.setLeft("11.11");
        formula.dotToLeft();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("11.11"));
    }

    /**
     * 右辺に小数点がないとき、小数点が入力されることを確認
     */
    @Test
    public void inputDotToRight() {
        Formula formula = new Formula();
        formula.setRight("11");
        formula.dotToRight();
        String actual = formula.getRight();
        Assert.assertThat(actual, is("11."));
    }

    /**
     * 右辺に小数点があるとき、小数点が入力されないことを確認
     */
    @Test
    public void notInputDotToRight() {
        Formula formula = new Formula();
        formula.setRight("11.11");
        formula.dotToRight();
        String actual = formula.getRight();
        Assert.assertThat(actual, is("11.11"));
    }

    /**
     * 左辺の符号反転確認
     */
    @Test
    public void negateToLeft() {
        Formula formula = new Formula();
        formula.setLeft("11");
        formula.negateToLeft();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("-11"));
    }

    /**
     * 右辺の符号反転確認
     */
    @Test
    public void negateToRight() {
        Formula formula = new Formula();
        formula.setRight("-11");
        formula.negateToRight();
        String actual = formula.getRight();
        Assert.assertThat(actual, is("11"));
    }

    /**
     * 左辺のパーセント変換
     */
    @Test
    public void percentToLeft() {
        Formula formula = new Formula();
        formula.setLeft("11");
        formula.percentToLeft();
        String actual = formula.getLeft();
        Assert.assertThat(actual, is("0.11"));
    }

    /**
     * 右辺のパーセント変換
     */
    @Test
    public void percentToRight() {
        Formula formula = new Formula();
        formula.setRight("11");
        formula.percentToRight();
        String actual = formula.getRight();
        Assert.assertThat(actual, is("0.11"));
    }
}
