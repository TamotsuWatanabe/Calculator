package org.sample.calculator;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

/**
 * ボタン押下ログ記録用 メソッド呼び出し時のインターセプター
 *
 * @author ta_watanabe
 */
@InputBtnLogger
@Interceptor
@Dependent
public class InputBtnLogInterceptor implements Serializable {

    @Inject
    transient Logger logger;

    /**
     * ログ書き込み
     *
     * @param context
     * @return
     * @throws java.lang.Exception
     */
    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {

        logger.info(context.getMethod().toString());
        return context.proceed();
    }
}
