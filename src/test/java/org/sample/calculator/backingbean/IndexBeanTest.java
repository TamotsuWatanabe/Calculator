package org.sample.calculator.backingbean;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;
import org.sample.calculator.Operation;

/**
 * IndexBeanテストクラス
 *
 * @author ta_watanabe
 */
public class IndexBeanTest {

    /**
     * (1+5)*65=390
     */
    @Test
    public void calculate1() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("1");
        bean.inputOperation(Operation.ADD);
        bean.inputNumber("5");
        bean.inputOperation(Operation.MUL);
        bean.inputNumber("6");
        bean.inputNumber("5");
        bean.inputEquale();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("390"));
    }

    /**
     * (357/43-656)*6=390
     */
    @Test
    public void calculate2() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("3");
        bean.inputNumber("5");
        bean.inputNumber("7");
        bean.inputOperation(Operation.DIV);
        bean.inputNumber("4");
        bean.inputNumber("3");
        bean.inputOperation(Operation.SUB);
        bean.inputNumber("6");
        bean.inputNumber("5");
        bean.inputNumber("6");
        bean.inputOperation(Operation.MUL);
        bean.inputNumber("6");
        bean.inputEquale();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("-3886.1860465116"));
    }

    /**
     * -12+4555*(-20)-3=-90863
     */
    @Test
    public void calculate3() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("1");
        bean.inputNumber("2");
        bean.inputNegation();
        bean.inputOperation(Operation.ADD);
        bean.inputNumber("4");
        bean.inputNumber("5");
        bean.inputNumber("5");
        bean.inputNumber("5");
        bean.inputOperation(Operation.MUL);
        bean.inputNumber("2");
        bean.inputNumber("0");
        bean.inputNegation();
        bean.inputOperation(Operation.SUB);
        bean.inputNumber("3");
        bean.inputEquale();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("-90863"));
    }

    /**
     * 1234567890+9876543210=E
     */
    @Test
    public void calculate4() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("1");
        bean.inputNumber("2");
        bean.inputNumber("3");
        bean.inputNumber("4");
        bean.inputNumber("5");
        bean.inputNumber("6");
        bean.inputNumber("7");
        bean.inputNumber("8");
        bean.inputNumber("9");
        bean.inputNumber("0");
        bean.inputOperation(Operation.ADD);
        bean.inputNumber("9");
        bean.inputNumber("8");
        bean.inputNumber("7");
        bean.inputNumber("6");
        bean.inputNumber("5");
        bean.inputNumber("4");
        bean.inputNumber("3");
        bean.inputNumber("2");
        bean.inputNumber("1");
        bean.inputNumber("0");
        bean.inputEquale();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("E"));
    }

    /**
     * 0.99/-3*1000.12=-330.0396
     */
    @Test
    public void calculate5() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("9");
        bean.inputNumber("9");
        bean.inputPercent();
        bean.inputOperation(Operation.DIV);
        bean.inputNumber("3");
        bean.inputNegation();
        bean.inputOperation(Operation.MUL);
        bean.inputNumber("1");
        bean.inputNumber("0");
        bean.inputNumber("0");
        bean.inputNumber("0");
        bean.inputDot();
        bean.inputNumber("1");
        bean.inputNumber("2");
        bean.inputEquale();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("-330.0396"));
    }

    /**
     * 10+10+10+10=40
     */
    @Test
    public void calculate6() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("1");
        bean.inputNumber("0");
        bean.inputOperation(Operation.ADD);
        bean.inputEquale();
        bean.inputEquale();
        bean.inputEquale();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("40"));
    }

    /**
     * 10+324*35*35*35/289=49551.0380622837
     */
    @Test
    public void calculate7() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("1");
        bean.inputNumber("0");
        bean.inputOperation(Operation.ADD);
        bean.inputNumber("3");
        bean.inputNumber("2");
        bean.inputNumber("4");
        bean.inputOperation(Operation.MUL);
        bean.inputNumber("3");
        bean.inputNumber("5");
        bean.inputEquale();
        bean.inputEquale();
        bean.inputEquale();
        bean.inputOperation(Operation.DIV);
        bean.inputNumber("2");
        bean.inputNumber("8");
        bean.inputNumber("9");
        bean.inputEquale();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("49551.0380622837"));
    }

    /**
     * 10+324*35*35*35/289=49551.0380622837
     */
    @Test
    public void clear() {
        IndexBean bean = new IndexBean();
        bean.initialize();
        bean.inputNumber("1");
        bean.inputNumber("2");
        bean.inputNumber("3");
        bean.inputNumber("4");
        bean.inputNumber("5");
        bean.inputNumber("6");
        bean.inputNumber("7");
        bean.inputNumber("8");
        bean.inputNumber("9");
        bean.inputNumber("0");
        bean.inputClear();
        String actual = bean.displayNumber();
        Assert.assertThat(actual, is("0"));
    }
}
