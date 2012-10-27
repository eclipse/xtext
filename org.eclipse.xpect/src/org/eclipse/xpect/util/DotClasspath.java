package org.eclipse.xpect.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.google.common.collect.Lists;

public class DotClasspath {

	protected class Handler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if ("classpathentry".equals(qName)) {
				String kind = attributes.getValue("kind");
				String path = attributes.getValue("path");
				if ("src".equals(kind))
					sources.add(path);
				else if ("output".equals(kind))
					output = path;
			}
		}

	}

	protected String output;

	protected List<String> sources = Lists.newArrayList();

	public DotClasspath(File file) {
		parse(file);
	}

	protected Handler createXMLHandler() {
		return new Handler();
	}

	public String getOutput() {
		return output;
	}

	public List<String> getSources() {
		return sources;
	}

	protected void parse(File file) {
		InputStream in = null;
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(createXMLHandler());
			in = new FileInputStream(file);
			reader.parse(new InputSource(in));
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
