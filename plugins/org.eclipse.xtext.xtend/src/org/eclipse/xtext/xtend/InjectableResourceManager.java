/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import java.io.InputStream;
import java.io.Reader;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.util.Cache;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.ResourceManagerDefaultImpl;
import org.eclipse.xtend.expression.ResourceParser;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class InjectableResourceManager extends ResourceManagerDefaultImpl {
	
	private final ClassLoader classLoader;

	@Inject
	public InjectableResourceManager(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	private final Cache<Pair<String, String>, Resource> resourceCache = new Cache<Pair<String, String>, Resource>() {

		@Override
		protected Resource createNew(Pair<String, String> resourceName) {
			String qualifiedResourceName = getQualifiedResourceName(resourceName.getFirst(), resourceName.getSecond());
			final InputStream in = classLoader.getResourceAsStream(
					qualifiedResourceName);

			if (in == null)
				return null;

			Reader reader = createReader(in);
			final ResourceParser parser = registeredParsers.get(resourceName.getSecond());
			if (parser == null)
				throw new RuntimeException("No Parser registered for extension '" + resourceName.getSecond()
						+ "'! Known extensions are '" + registeredParsers.keySet() + "'");
			final Resource res = parser.parse(reader, qualifiedResourceName);
			res.setFullyQualifiedName(resourceName.getFirst());
			return res;
		}
	};

	@Override
	public Resource loadResource(String fullyQualifiedName, String extension) {
		return resourceCache.get(Tuples.pair(fullyQualifiedName,extension));
	}

	private String getQualifiedResourceName(String fullyQualifiedName, String extension) {
		return fullyQualifiedName.replace(SyntaxConstants.NS_DELIM, "/") + "." + extension;
	}

	public final static String FILE_ENCODING = "fileEncoding";
	
	@Override
	@Inject(optional=true)
	public void setFileEncoding(@Named(FILE_ENCODING) String fileEncoding) {
		super.setFileEncoding(fileEncoding);
	}

}
