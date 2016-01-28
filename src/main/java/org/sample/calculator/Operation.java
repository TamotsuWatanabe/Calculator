package org.sample.calculator;

import java.math.BigDecimal;

/**
 * 演算子
 *
 * @author ta_watanabe
 */
public enum Operation {

    /**
     * なし
     */
    NONE {
        @Override
        public BigDecimal apply(BigDecimal left, BigDecimal right) {
            return new BigDecimal(0);
        }
    },
    /**
     * 加算
     */
    ADD {
        @Override
        public BigDecimal apply(BigDecimal left, BigDecimal right) {
            return left.add(right).stripTrailingZeros();
        }
    },
    /**
     * 減算
     */
    SUB {
        @Override
        public BigDecimal apply(BigDecimal left, BigDecimal right) {
            return left.subtract(right).stripTrailingZeros();
        }
    },
    /**
     * 乗算
     */
    MUL {
        @Override
        public BigDecimal apply(BigDecimal left, BigDecimal right) {
            return left.multiply(right).stripTrailingZeros();
        }
    },
    /**
     * 除算
     */
    DIV {
        @Override
        public BigDecimal apply(BigDecimal left, BigDecimal right) {
            // 小数部10桁まで
            return left.divide(right, 10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
        }
    };

    abstract public BigDecimal apply(BigDecimal left, BigDecimal right);
}
