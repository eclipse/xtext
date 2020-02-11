/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	@Override
	public Iterable<String> getAllPathes(ClassLoader classloader) {
		if (classloader instanceof URLClassLoader) {
			List<URL> urls = Arrays.asList(((URLClassLoader)classloader).getURLs());
			return Iterables.transform(urls, new Function<URL,String>(){
				@Override
				public String apply(URL from) {
					return from.toString();
				}});
		}
		throw new IllegalArgumentException("expected an URLClassLoader but received "+classloader);
	}

}
