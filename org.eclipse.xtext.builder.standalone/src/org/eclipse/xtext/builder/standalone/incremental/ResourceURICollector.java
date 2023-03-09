/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.standalone.incremental;

import static java.util.stream.Collectors.*;
import static java.util.stream.StreamSupport.*;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipException;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Multimap;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
public class ResourceURICollector {
	private static final Logger LOG = Logger.getLogger(ResourceURICollector.class);

	public Set<URI> collectAllResources(Iterable<URI> roots, Set<String> fileExtensions) {
		if (LOG.isInfoEnabled()) {
			LOG.info("Collecting source models.");
		}
		long startedAt = System.currentTimeMillis();
		Set<URI> result = collectResources(roots, fileExtensions);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Finished collecting source models. Took: " + (System.currentTimeMillis() - startedAt) + " ms.");
		}
		return result;
	}

	protected Set<URI> collectResources(Iterable<URI> roots, Set<String> fileExtensions) {
		Set<String> extensions = new HashSet<>(fileExtensions);
		extensions.add("java");

		List<String> paths = stream(roots.spliterator(), false).map(URI::toFileString).collect(toList());
		Multimap<String, URI> modelsFound = new PathTraverser().resolvePathes(paths, uri -> extensions.contains(uri.fileExtension()));
		
		modelsFound.asMap().forEach( (path, resource) -> {
			File file = new File(path);
			if (resource != null && !file.isDirectory() && file.getName().endsWith(".jar")) {
				registerBundle(file);
			}
		});

		return IterableExtensions.toSet(modelsFound.values());
	}

	protected void registerBundle(File file) {
		try (JarFile jarFile = new JarFile(file)){
			Manifest manifest = jarFile.getManifest();
			if (manifest == null) {
				return;
			}
			String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
			if (name != null) {
				int indexOf = name.indexOf(";");
				if (indexOf > 0) {
					name = name.substring(0, indexOf);
				}
				if (EcorePlugin.getPlatformResourceMap().containsKey(name)) {
					return;
				}
				String path = ("archive:" + URI.createFileURI(file.getAbsolutePath()) + "!/");
				EcorePlugin.getPlatformResourceMap().put(name, URI.createURI(path));
			}
		} catch (ZipException e) {
			LOG.info("Could not open Jar file " + file.getAbsolutePath() + ".");
		} catch (Exception e) {
			LOG.error(file.getAbsolutePath(), e);
		}
	}

}
