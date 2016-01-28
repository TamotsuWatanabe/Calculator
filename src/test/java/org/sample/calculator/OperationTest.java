package org.sample.calculator;

import java.math.BigDecimal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

/**
 * Operationテストクラス
 *
 * @author ta_watanabe
 */
public class OperationTest {

    /**
     * 10+55=65
     */
    @Test
    public void add10and55() {
        String actual = Operation.ADD.apply(new BigDecimal(10), new BigDecimal(55)).toPlainString();
        Assert.assertThat(actual, is("65"));
    }

    /**
     * -67.0+21=-46
     */
    @Test
    public void addMinus67and21() {
        String actual = Operation.ADD.apply(new BigDecimal(-67.0), new BigDecimal(21)).toPlainString();
        Assert.assertThat(actual, is("-46"));
    }

    /**
     * 6875-1209=5666
     */
    @Test
    public void subtract1209from6875() {
        String actual = Operation.SUB.apply(new BigDecimal(6875), new BigDecimal(1209)).toPlainString();
        Assert.assertThat(actual, is("5666"));
    }

    /**
     * 12.0-333=--321
     */
    @Test
    public void subtract333from12() {
        String actual = Operation.SUB.apply(new BigDecimal(12.0), new BigDecimal(333)).toPlainString();
        Assert.assertThat(actual, is("-321"));
    }

    /**
     * 265*7=1855
     */
    @Test
    public void multiply265by7() {
        String actual = Operation.MUL.apply(new BigDecimal(265), new BigDecimal(7)).toPlainString();
        Assert.assertThat(actual, is("1855"));
    }

    /**
     * -99+(-32.0)=3168
     */
    @Test
    public void multiplyMinus99byMinus32() {
        String actual = Operation.MUL.apply(new BigDecimal(-99), new BigDecimal(-32.0)).toPlainString();
        Assert.assertThat(actual, is("3168"));
    }

    /**
     * 5/2=2.5
     */
    @Test
    public void divide5by2() {
        String actual = Operation.DIV.apply(new BigDecimal(5), new BigDecimal(2)).toPlainString();
        Assert.assertThat(actual, is("2.5"));
    }

    /**
     * -85/11=-7.7272727273
     */
    @Test
    public void divideMinus85by11() {
        String actual = Operation.DIV.apply(new BigDecimal(-85), new BigDecimal(11)).toPlainString();
        Assert.assertThat(actual, is("-7.7272727273"));
    }

}
