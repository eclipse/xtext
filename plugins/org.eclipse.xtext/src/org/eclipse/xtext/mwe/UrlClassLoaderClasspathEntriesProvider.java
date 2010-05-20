/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class UrlClassLoaderClasspathEntriesProvider implements IClasspathEntriesProvider {

	public Iterable<String> getAllPathes(ClassLoader classloader) {
		if (classloader instanceof URLClassLoader) {
			List<URL> urls = Arrays.asList(((URLClassLoader)classloader).getURLs());
			return Iterables.transform(urls, new Function<URL,String>(){
				public String apply(URL from) {
					return from.toString();
				}});
		}
		throw new IllegalArgumentException("expected an URLClassLoader but received "+classloader);
	}

}
