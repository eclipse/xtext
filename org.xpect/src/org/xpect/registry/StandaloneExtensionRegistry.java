package org.xpect.registry;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xpect.util.ClasspathUtil;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.io.Closeables;

public class StandaloneExtensionRegistry implements IExtensionInfo.Registry {

	protected static class PluginXMLContentHandler extends DefaultHandler {

		private int depth;

		private final Multimap<String, IExtensionInfo> extensions;
		private String point;

		private final URL url;

		public PluginXMLContentHandler(URL url, Multimap<String, IExtensionInfo> extensions) {
			super();
			this.url = url;
			this.extensions = extensions;
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			switch (depth) {
			case 1:
				point = null;
				break;
			}
			depth--;
		}

		@Override
		public void startDocument() throws SAXException {
			this.depth = 0;
			this.point = null;
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			switch (depth) {
			case 1:
				if ("extension".equals(qName))
					point = attributes.getValue("point");
				break;
			case 2:
				if (point != null && attributes.getLength() > 0) {
					Map<String, String> attrs = Maps.newHashMap();
					for (int i = 0; i < attributes.getLength(); i++)
						attrs.put(attributes.getQName(i), attributes.getValue(i));
					extensions.put(point, new StandaloneExtension(url.toString(), qName, attrs));
				}
				break;
			}
			depth++;
		}
	}

	private static class StandaloneExtension implements IExtensionInfo {
		private final Map<String, String> attribtues;
		private final String loacation;
		private final String name;

		public StandaloneExtension(String location, String name, Map<String, String> attribtues) {
			this.loacation = location;
			this.name = name;
			this.attribtues = ImmutableMap.copyOf(attribtues);
		}

		public Collection<String> getAttributes() {
			return this.attribtues.keySet();
		}

		public String getAttributeValue(String name) {
			return this.attribtues.get(name);
		}

		public Function<String, Class<?>> getClassLoader() {
			return new Function<String, Class<?>>() {
				public Class<?> apply(String input) {
					try {
						return ClassLoader.getSystemClassLoader().loadClass(input);
					} catch (ClassNotFoundException e) {
						throw new RuntimeException(e);
					}
				}
			};
		}

		public String getLocation() {
			return loacation;
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			result.append("<");
			result.append(name);
			List<String> attrs = Lists.newArrayList(getAttributes());
			Collections.sort(attrs);
			for (String attr : attrs) {
				result.append(" ");
				result.append(attr);
				result.append("=\"");
				result.append(getAttributeValue(attr));
				result.append("\"");
			}
			result.append(" />");
			return result.toString();
		}
	}

	private final static Logger LOG = Logger.getLogger(StandaloneExtensionRegistry.class);

	public static void main(String[] args) {
		System.out.println(new StandaloneExtensionRegistry().toString());
	}

	private final Multimap<String, IExtensionInfo> extensions;

	public StandaloneExtensionRegistry() {
		this.extensions = ImmutableMultimap.copyOf(collectExtensions());
	}

	public StandaloneExtensionRegistry(URL url, InputStream in) {
		this.extensions = ImmutableMultimap.copyOf(collectExtensions(url, in));
	}

	private Multimap<String, IExtensionInfo> collectExtensions() {
		Multimap<String, IExtensionInfo> result = HashMultimap.create();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			for (URL url : ClasspathUtil.findResources("plugin.xml")) {
				reader.setContentHandler(new PluginXMLContentHandler(url, result));
				InputStream openStream = null;
				try {
					openStream = url.openStream();
					reader.parse(new InputSource(openStream));
				} catch (Throwable e) {
					LOG.error("Error parsing " + url, e);
				} finally {
					Closeables.closeQuietly(openStream);
				}
			}
		} catch (Throwable e) {
			LOG.error(e.getMessage(), e);
		}
		return result;
	}

	private Multimap<String, IExtensionInfo> collectExtensions(URL url, InputStream in) {
		Multimap<String, IExtensionInfo> result = HashMultimap.create();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new PluginXMLContentHandler(url, result));
			reader.parse(new InputSource(in));
		} catch (Throwable e) {
			LOG.error("Error parsing " + url, e);
		}
		return result;
	}

	public Collection<String> getExtensionPoints() {
		return extensions.keySet();
	}

	public Collection<IExtensionInfo> getExtensions(String extensionPointName) {
		return this.extensions.get(extensionPointName);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("<plugin>\n");
		for (String point : getExtensionPoints()) {
			result.append("  <extension point=\"");
			result.append(point);
			result.append("\">\n");
			for (IExtensionInfo ext : getExtensions(point)) {
				result.append("    ");
				result.append(ext.toString());
				result.append("\n");
			}
		}
		result.append("  </extension>\n");
		result.append("</plugin>");
		return result.toString();
	}

}
