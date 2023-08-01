/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lsp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.util.UriExtensions;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @since 2.35
 */
@Singleton
public class ClasspathPropertiesBasedFileSystemScanner implements IFileSystemScanner {
	
	private static final Logger LOGGER = Logger.getLogger(ClasspathPropertiesBasedFileSystemScanner.class);
	
	private static final Predicate<String> MODEL = Pattern.compile("^\\w+\\.(model|src).\\d+$").asPredicate();
	
	static final String XTEXT_CLASSPATH = "xtext.classpath";
	
	@Inject
	private UriExtensions uriExtensions;
	
	@Override
	public void scan(URI root, IAcceptor<URI> acceptor) {
		Properties classpath = getProjectClasspath(root);
		List<String> modelPaths = new ArrayList<>();
		if (classpath != null) {
			classpath.forEach((k, v)->{
				String key = (String) k;
				String value = (String) v;
				if (MODEL.test(key)) {
					modelPaths.add(value);
				}
			});
		} else {
			modelPaths.add(new File(root.toFileString()).getAbsolutePath());
		};
		
		Registry registry = IResourceServiceProvider.Registry.INSTANCE;
		Multimap<String, URI> byPath = new PathTraverser().resolvePathes(modelPaths, uri->{
			return registry.getResourceServiceProvider(uri) != null;
		});
		LOGGER.debug("Initial files:");
		byPath.values().forEach(uri->{
			URI lspCompliant = uriExtensions.withEmptyAuthority(uri);
			LOGGER.debug(lspCompliant);
			acceptor.accept(lspCompliant);	
		});
	}
	
	protected Properties getProjectClasspath(URI root) {
		return Optional.ofNullable(root).map(URI::toFileString).map(File::new).map(base->{
			File classPathInfo = configFile(base);
			if (classPathInfo.exists()) {
				Properties properties = new Properties();
				try (FileReader reader = new FileReader(classPathInfo, StandardCharsets.UTF_8)) {
					properties.load(reader);
					return properties;
				} catch(IOException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}	
			return null;
		}).orElse(null);
	}

	protected File configFile(File base) {
		return new File(new File(base, "target"), XTEXT_CLASSPATH);
	}

}
