package org.eclipse.xpect.xtext.lib.registry;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class StandalonePluginXMLParser {

	protected static class EMFExtensionParserHandler extends ExtensionPointHandler {

		@Override
		public void beginElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if ("parser".equals(qName)) {
				Pair<String, String> pair = parseExtensionFactory(attributes.getValue("class"));
				String type = attributes.getValue("type");
				info.add(new EMFExtensionParserInfo(pair.getFirst(), pair.getSecond(), type));
			}
		}
	}

	public static class EMFExtensionParserInfo implements ExtensionInfo {
		private final String clazz;
		private final String language;
		private final String type;

		public EMFExtensionParserInfo(String language, String clazz, String type) {
			super();
			this.language = language;
			this.clazz = clazz;
			this.type = type;
		}

		public String getClazz() {
			return clazz;
		}

		public String getLanguage() {
			return language;
		}

		public String getType() {
			return type;
		}

		@Override
		public String toString() {
			return "EMFExtensionParser type=" + type + " language=" + language + " class" + clazz;
		}

	}

	protected static class EMFGeneratedPackageHandler extends ExtensionPointHandler {
		@Override
		public void beginElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if ("package".equals(qName)) {
				String u = attributes.getValue("uri");
				String clazz = attributes.getValue("class");
				String genModel = attributes.getValue("genModel");
				info.add(new EMFGeneratedPackageInfo(u, clazz, genModel));
			}
		}
	}

	// <extension
	// point="org.eclipse.emf.ecore.extension_parser">
	// <parser
	// class="org.eclipse.xpect.ui.XpectExecutableExtensionFactory:org.eclipse.xtext.resource.IResourceFactory"
	// type="xpect">
	// </parser>
	// </extension>

	public static class EMFGeneratedPackageInfo implements ExtensionInfo {
		protected final String clazz;

		protected final String genModel;

		protected final String uri;

		public EMFGeneratedPackageInfo(String uri, String clazz, String genModel) {
			super();
			this.uri = uri;
			this.clazz = clazz;
			this.genModel = genModel;
		}

		public String getClazz() {
			return clazz;
		}

		public String getGenModel() {
			return genModel;
		}

		public String getUri() {
			return uri;
		}

		@Override
		public String toString() {
			return "EPackage nsURI=" + uri + " class=" + clazz + " genModel=" + genModel;
		}
	}

	protected interface ExtensionInfo {
	}

	// <extension point="org.eclipse.xtext.extension_resourceServiceProvider">
	// <resourceServiceProvider
	// class="org.eclipse.xpect.ui.XpectExecutableExtensionFactory:org.eclipse.xtext.ui.resource.IResourceUIServiceProvider"
	// uriExtension="xpect">
	// </resourceServiceProvider>
	// </extension>

	protected abstract static class ExtensionPointHandler {

		protected final List<ExtensionInfo> info = Lists.newArrayList();

		public abstract void beginElement(String uri, String localName, String qName, Attributes attributes) throws SAXException;

		public void endElement(String uri, String localName, String qName) throws SAXException {
		}

		public List<ExtensionInfo> getInfo() {
			return info;
		}

		protected Pair<String, String> parseExtensionFactory(String factAndClass) {
			String[] segs = factAndClass.split(":");
			if (segs.length == 2) {
				String fact = segs[0];
				String clazz = segs[1];
				if (fact.endsWith(EXECUTABLE_EXTENSION_FACTORY)) {
					String[] s = fact.substring(0, fact.length() - EXECUTABLE_EXTENSION_FACTORY.length()).split("\\.");
					List<String> result = Lists.newArrayList();
					if (s.length > 1 && "ui".equals(s[s.length - 2]))
						for (int i = 0; i < s.length; i++)
							if (i != s.length - 2)
								result.add(s[i]);
					String lang = Joiner.on(".").join(result);
					return Tuples.create(lang, clazz);
				}
				return Tuples.create(null, clazz);
			} else
				return Tuples.create(null, factAndClass);
		}
	}

	protected static class PluginXMLContentHandler extends DefaultHandler {

		protected ExtensionPointHandler currentHandler = null;
		protected List<ExtensionPointHandler> finishedHandlers = Lists.newArrayList();

		@Override
		public void endDocument() throws SAXException {
			// System.out.println("end");
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if ("extension".equals(qName) && currentHandler != null) {
				finishedHandlers.add(currentHandler);
				currentHandler = null;
			}
			if (currentHandler != null)
				currentHandler.endElement(uri, localName, qName);
		}

		public List<ExtensionPointHandler> getFinishedHandlers() {
			return finishedHandlers;
		}

		@Override
		public void startDocument() throws SAXException {
			// System.out.println("start");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if ("extension".equals(qName)) {
				String point = attributes.getValue("point");
				Class<? extends ExtensionPointHandler> clazz = handlers.get(point);
				if (clazz != null) {
					try {
						currentHandler = clazz.newInstance();
						currentHandler.beginElement(uri, localName, qName, attributes);
					} catch (InstantiationException e) {
						throw new RuntimeException(e);
					} catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					}
				}
			} else if (currentHandler != null)
				currentHandler.beginElement(uri, localName, qName, attributes);
		}
	}

	// <extension point="org.eclipse.emf.ecore.generated_package">
	// <package uri = "http://www.eclipse.org/2008/Xtext" class =
	// "org.eclipse.xtext.XtextPackage" genModel =
	// "org/eclipse/xtext/Xtext.genmodel" />
	// </extension>

	/*
	 * public static class ResourceServiceProviderInfo implements ExtensionInfo
	 * { private final String clazz; private final String language; private
	 * final String uriExtension;
	 * 
	 * public ResourceServiceProviderInfo(String language, String clazz, String
	 * uriExtension) { super(); this.language = language; this.clazz = clazz;
	 * this.uriExtension = uriExtension; }
	 * 
	 * public String getClazz() { return clazz; }
	 * 
	 * public String getLanguage() { return language; }
	 * 
	 * public String getUriExtension() { return uriExtension; }
	 * 
	 * @Override public String toString() { return
	 * "XtextResourceServiceProvider uriExtension=" + uriExtension + " lang=" +
	 * language + " class=" + clazz; }
	 * 
	 * }
	 * 
	 * protected static class XtextResourceServiceProviderHandler extends
	 * ExtensionPointHandler {
	 * 
	 * @Override public void beginElement(String uri, String localName, String
	 * qName, Attributes attributes) throws SAXException { if
	 * (qName.equals("resourceServiceProvider")) { Pair<String, String> pair =
	 * parseExtensionFactory(attributes.getValue("class")); String uriExtension
	 * = attributes.getValue("uriExtension"); info.add(new
	 * ResourceServiceProviderInfo(pair.getFirst(), pair.getSecond(),
	 * uriExtension)); } }
	 * 
	 * }
	 */
	protected static final String EXECUTABLE_EXTENSION_FACTORY = "ExecutableExtensionFactory";
	protected static Map<String, Class<? extends ExtensionPointHandler>> handlers;

	static {
		handlers = Maps.newHashMap();
		handlers.put("org.eclipse.emf.ecore.generated_package", EMFGeneratedPackageHandler.class);
		handlers.put("org.eclipse.emf.ecore.extension_parser", EMFExtensionParserHandler.class);
		// handlers.put("org.eclipse.xtext.extension_resourceServiceProvider",
		// XtextResourceServiceProviderHandler.class);
	}

	protected Collection<URL> getAllPluginResourceURLs() {
		Set<URL> result = Sets.newLinkedHashSet();
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
			Enumeration<URL> resources = classLoader.getResources("plugin.xml");
			while (resources.hasMoreElements())
				result.add(resources.nextElement());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (classLoader instanceof URLClassLoader) {
			URLClassLoader ucl = (URLClassLoader) classLoader;
			for (URL u : ucl.getURLs())
				if (!u.getFile().endsWith(".jar")) {
					try {
						java.io.File f = new java.io.File(u.toURI());
						if (f.isDirectory()) {
							int levels = 5;
							while (levels >= 0) {
								java.io.File pl = new java.io.File(f + "/" + "plugin.xml");
								if (pl.isFile()) {
									result.add(pl.toURI().toURL());
									break;
								}
								levels--;
								f = f.getParentFile();
							}
						}
					} catch (URISyntaxException e) {
						throw new RuntimeException(e);
					} catch (MalformedURLException e) {
						throw new RuntimeException(e);
					}
				}
		}
		return result;
	}

	public List<ExtensionInfo> parse() {
		List<ExtensionInfo> result = Lists.newArrayList();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			PluginXMLContentHandler handler = new PluginXMLContentHandler();
			reader.setContentHandler(handler);
			for (URL u : getAllPluginResourceURLs()) {
				InputStream openStream = null;
				try {
					openStream = u.openStream();
					reader.parse(new InputSource(openStream));
				} catch (IOException e) {
					throw new RuntimeException(e);
				} finally {
					if (openStream != null)
						try {
							openStream.close();
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
				}
			}
			for (ExtensionPointHandler h : handler.getFinishedHandlers())
				for (ExtensionInfo pi : h.getInfo())
					result.add(pi);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
