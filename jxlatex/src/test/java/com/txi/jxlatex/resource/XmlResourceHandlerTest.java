package com.txi.jxlatex.resource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class XmlResourceHandlerTest {

    @Test
    public void testParse() {
        Assertions
                .assertThat(XmlResourceHandler.getInstance().parse("TeXFormulaSettings.xml"))
                .isNotNull();
    }
}
