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
import java.util.List
import java.util.jar.JarFile
import java.util.jar.Manifest
import java.util.zip.ZipException
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.xtext.mwe.NameBasedFilter
import org.eclipse.xtext.mwe.PathTraverser

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
class ResourceURICollector {
	
	static val LOG = Logger.getLogger(ResourceURICollector)
	
	def protected List<URI> collectResources(List<File> roots, BuildContext context) {
		val extensions = context.languages.keySet.join("|")
		val nameBasedFilter = new NameBasedFilter

		// TODO test with whitespaced file extensions
		nameBasedFilter.setRegularExpression(".*\\.(?:(" + extensions + "))$");
		val List<URI> resources = newArrayList();

		val modelsFound = new PathTraverser().resolvePathes(
			roots.map[absolutePath].toList,
			[ input |
				val matches = nameBasedFilter.matches(input)
				if (matches) {
					LOG.info("Adding file '" + input + "'");
					resources.add(input);
				}
				return matches
			]
		)
		modelsFound.asMap.forEach [ uri, resource |
			val file = new File(uri)
			if (resource != null && !file.directory && file.name.endsWith(".jar")) {
				registerBundle(file)
			}
		]
		return resources;
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
				val String path = "archive:" + file.toURI() + "!/";
				val URI uri = URI.createURI(path);
				EcorePlugin.getPlatformResourceMap().put(name, uri);
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