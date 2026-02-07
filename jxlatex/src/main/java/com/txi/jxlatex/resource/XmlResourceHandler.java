package com.txi.jxlatex.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlResourceHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlResourceHandler.class);

    private static XmlResourceHandler soleInstance;

    private final DocumentBuilderFactory factory;

    public XmlResourceHandler() {
        this.factory = DocumentBuilderFactory.newInstance();
        this.factory.setIgnoringElementContentWhitespace(true);
        this.factory.setIgnoringComments(true);
    }


    public Element parse(String resourceName) {
        try (InputStream inputStream = openStream(resourceName)) {
            return factory.newDocumentBuilder().parse(inputStream).getDocumentElement();
        } catch (IOException exception) {
            throw new UncheckedIOException("cannot read %s".formatted(resourceName), exception);
        } catch (ParserConfigurationException | SAXException exception) {
            throw new IllegalStateException("parsing of %s failed".formatted(resourceName), exception);
        }
    }

    private InputStream openStream(String resourceName) throws IOException {
        if (Files.exists(Paths.get(resourceName))) {
            LOGGER.info("open file {}", resourceName);
            return new FileInputStream(resourceName);
        } else {
            return findResource(resourceName).openStream();
        }
    }


    private URL findResource(String resourceName) {
        URL resource = XmlResourceHandler.class.getResource(resourceName);
        if (resource == null) {
            String alternative = "/com/txi/jxlatex/%s".formatted(resourceName);
            LOGGER.info("load {}", alternative);
            resource = XmlResourceHandler.class.getResource(alternative);
        }
        if (resource == null) {
            throw new NoSuchResourceException("no such resource %s".formatted(resourceName));
        } else {
            return resource;
        }

    }

    public static XmlResourceHandler getInstance() {
        if (XmlResourceHandler.soleInstance == null) {
            XmlResourceHandler.soleInstance = new XmlResourceHandler();
        }
        return XmlResourceHandler.soleInstance;
    }
}
