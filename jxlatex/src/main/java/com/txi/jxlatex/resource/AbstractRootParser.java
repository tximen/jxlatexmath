package com.txi.jxlatex.resource;

import org.w3c.dom.Element;

public class AbstractRootParser {

    protected Element root;

    public AbstractRootParser(String resourceName) {
        this.root = XmlResourceHandler.getInstance().parse(resourceName);
    }
}
