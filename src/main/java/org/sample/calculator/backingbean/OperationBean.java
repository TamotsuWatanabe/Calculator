package org.sample.calculator.backingbean;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.sample.calculator.Operation;

/**
 * 加減乗除演算子取得用バッキングビーン
 *
 * @author ta_watanabe
 */
@Named
@ApplicationScoped
public class OperationBean implements Serializable {

    /**
     * 加算取得
     *
     * @return 加算
     */
    public Operation getADD() {
        return Operation.ADD;
    }

    /**
     * 減算取得
     *
     * @return 減算
     */
    public Operation getSUB() {
        return Operation.SUB;
    }

    /**
     * 乗算取得
     *
     * @return 乗算
     */
    public Operation getMUL() {
        return Operation.MUL;
    }

    /**
     * 除算取得
     *
     * @return 除算
     */
    public Operation getDIV() {
        return Operation.DIV;
    }
}
