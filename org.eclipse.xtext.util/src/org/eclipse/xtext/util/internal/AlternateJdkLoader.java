/**
 * Copyright (c) 2014, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util.internal;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.Lists;

public class AlternateJdkLoader extends URLClassLoader {
	private final ConcurrentMap<String, Object> locks = new ConcurrentHashMap<>();

	public AlternateJdkLoader(Iterable<File> files) {
		super(mapToURLs(files));
	}
	
	private static URL[] mapToURLs (Iterable<File> files) {
		ArrayList<File> fileList = Lists.newArrayList(files);
		URL[] result = new URL[fileList.size()];
		for (int i = 0; i < fileList.size(); i++) {
			try {
				result[i] = fileList.get(i).toURI().toURL();
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		synchronized (getClassLoadingLockJdk5(name)) {
			Class<?> c = findLoadedClass(name);
			if (c == null) {
				c = findClass(name);
			}
			if (resolve) {
				resolveClass(c);
			}
			return c;
		}
	}

	@Override
	public URL getResource(String name) {
		return findResource(name);
	}

	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		return findResources(name);
	}

	private Object getClassLoadingLockJdk5(String className) {
		Object newLock = new Object();
		Object existingLock = locks.putIfAbsent(className, newLock);
		return existingLock != null ? existingLock : newLock;
	}
}
