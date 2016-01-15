package org.eclipse.xpect.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;
import org.eclipse.xpect.runner.XpectRunner;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.google.common.io.Closeables;

public class ClasspathUtil {

	private static final String BUNDLE_SYMBOLIC_NAME = "Bundle-SymbolicName";

	private final static Logger LOG = Logger.getLogger(ClasspathUtil.class);

	@SuppressWarnings("resource")
	public static Collection<URL> findResources(String... fileNames) {
		Set<URL> result = Sets.newLinkedHashSet();
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
			for (String fileName : fileNames) {
				Enumeration<URL> resources = classLoader.getResources(fileName);
				while (resources.hasMoreElements())
					result.add(resources.nextElement());
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
		if (classLoader instanceof URLClassLoader) {
			URLClassLoader ucl = (URLClassLoader) classLoader;
			for (URL u : ucl.getURLs())
				if (!u.getFile().endsWith(".jar")) {
					try {
						java.io.File f = new java.io.File(u.toURI());
						if (f.isDirectory()) {
							int levels = 5;
							W: while (levels >= 0 && f != null) {
								for (String fileName : fileNames) {
									java.io.File pl = new java.io.File(f + "/" + fileName);
									if (pl.isFile()) {
										result.add(pl.toURI().toURL());
										break W;
									}
								}
								levels--;
								f = f.getParentFile();
							}
						}
					} catch (URISyntaxException e) {
						LOG.error(e.getMessage(), e);
					} catch (MalformedURLException e) {
						LOG.error(e.getMessage(), e);
					}
				}
		}
		// for some reason, ucl.getURLs() doesn't catch the current project in standalone maven surefire
		if (XpectRunner.INSTANCE != null) {
			Class<?> clazz = XpectRunner.INSTANCE.getTestClass().getJavaClass();
			String[] segments = clazz.getName().split("\\.");
			String fileName = Joiner.on('/').join(segments) + ".class";
			URL resource = clazz.getClassLoader().getResource(fileName);
			if ("jar".equals(resource.getProtocol())) {
				// URI location = URI.createURI(resource.toString()).trimSegments(segments.length).appendSegment("");
				// return location;
			} else {
				File classFile;
				try {
					classFile = new File(resource.toURI());
					File packageRootFolder = classFile;
					for (int i = 0; i < segments.length; i++) {
						packageRootFolder = packageRootFolder.getParentFile();
						if (packageRootFolder == null)
							LOG.error("Could not determine package root for " + clazz);
					}
					File current = packageRootFolder;
					W: while (current != null) {
						for (String name : fileNames) {
							java.io.File pl = new java.io.File(current, name);
							if (pl.isFile()) {
								result.add(pl.toURI().toURL());
								break W;
							}
						}
						current = current.getParentFile();
					}
				} catch (URISyntaxException e) {
					LOG.error(e.getMessage(), e);
				} catch (MalformedURLException e) {
					LOG.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}

	public static String getSymbolicName(InputStream manifestInputStream) {
		try {
			Manifest manifest = new Manifest(manifestInputStream);
			return getSymbolicName(manifest);
		} catch (IOException e) {
			LOG.error("error parsing manifest", e);
		} finally {
			Closeables.closeQuietly(manifestInputStream);
		}
		return null;
	}

	public static String getSymbolicName(Manifest manifest) {
		String name = manifest.getMainAttributes().getValue(BUNDLE_SYMBOLIC_NAME);
		if (name != null) {
			int i = name.indexOf(';');
			if (i >= 0)
				name = name.substring(0, i);
		}
		return name;
	}
}
