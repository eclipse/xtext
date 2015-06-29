/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import java.io.File
import java.io.IOException
import java.util.Set
import java.util.jar.JarFile
import java.util.jar.Manifest
import java.util.zip.ZipException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.xtext.mwe.PathTraverser
import org.eclipse.xtext.util.internal.Log

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Log class ResourceURICollector {
	
	def Set<URI> collectAllResources(Iterable<URI> roots, Set<String> fileExtensions) {
		if (LOG.infoEnabled) 
			LOG.info("Collecting source models.")
		val startedAt = System.currentTimeMillis
		val result = roots.collectResources(fileExtensions)
		if (LOG.debugEnabled) 
			LOG.debug("Finished collecting source models. Took: " + (System.currentTimeMillis - startedAt) + " ms.")
		return result
	} 
	
	def protected collectResources(Iterable<URI> roots, Set<String> fileExtensions) {
		val extensions = (fileExtensions + #['java']).toSet

		val modelsFound = new PathTraverser().resolvePathes(roots.map[toFileString].toList) [ extensions.contains(fileExtension) ]
		modelsFound.asMap.forEach [ path, resource |
			val file = new File(path)
			if (resource != null && !file.directory && file.name.endsWith(".jar")) {
				registerBundle(file)
			}
		]
		return modelsFound.values.toSet;
	}

	def protected registerBundle(File file) {
		var JarFile jarFile = null;
		try {
			jarFile = new JarFile(file);
			val Manifest manifest = jarFile.getManifest();
			if (manifest == null)
				return;
			var String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
			if (name != null) {
				val int indexOf = name.indexOf(';');
				if (indexOf > 0)
					name = name.substring(0, indexOf);
				if (EcorePlugin.getPlatformResourceMap().containsKey(name))
					return;
				val String path = "archive:" + URI.createFileURI(file.absolutePath) + "!/";
				EcorePlugin.getPlatformResourceMap().put(name, URI.createURI(path));
			}
		} catch (ZipException e) {
			LOG.info("Could not open Jar file " + file.getAbsolutePath() + ".");
		} catch (Exception e) {
			LOG.error(file.absolutePath, e);
		} finally {
			try {
				if (jarFile != null)
					jarFile.close();
			} catch (IOException e) {
				LOG.error(jarFile, e);
			}
		}
	}
}