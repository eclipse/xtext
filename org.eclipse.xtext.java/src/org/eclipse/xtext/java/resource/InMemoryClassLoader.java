/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Exceptions;

public class InMemoryClassLoader extends ClassLoader {
	private Map<String, byte[]> classMap;

	public InMemoryClassLoader(Map<String, byte[]> classMap, ClassLoader parent) {
		super(parent);
		this.classMap = classMap;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bytes = classMap.get(name);
		if (bytes == null) {
			return super.findClass(name);
		} else {
			return defineClass(name, bytes, 0, bytes.length);
		}
	}

	@Override
	public URL getResource(String path) {
		try {
			if (path.endsWith(".class")) {
				String className = pathToClassName(path);
				byte[] bytes = classMap.get(className);
				if (bytes != null) {
					return byteArrayToURL(path, bytes);
				}
				return super.getResource(path);
			}
			return null;
		} catch (MalformedURLException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	private URL byteArrayToURL(String path, byte[] bytes) throws MalformedURLException {
		return new URL("in-memory", null, -1, path, new URLStreamHandler() {
			@Override
			protected URLConnection openConnection(URL it) throws IOException {
				return new URLConnection(it) {
					@Override
					public void connect() {
					}

					@Override
					public InputStream getInputStream() {
						return new ByteArrayInputStream(bytes);
					}
				};
			}
		});
	}

	@Override
	protected URL findResource(String path) {
		try {
			if (path.endsWith(".class")) {
				String className = pathToClassName(path);
				byte[] bytes = classMap.get(className);
				if (bytes != null) {
					return byteArrayToURL(path, bytes);
				}
			}
			return super.findResource(path);
		} catch (MalformedURLException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected String pathToClassName(String path) {
		if (path.endsWith(".class")) {
			return path.substring(0, path.length() - 6).replace("/", ".");
		} else {
			return null;
		}
	}
}
