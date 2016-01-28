package org.sample.calculator;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ロガークラス
 *
 * @author ta_watanabe
 */
@Named
@Dependent
public class LoggerProducer {

    @Produces
    public Logger getLogger(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getName());
    }
}
