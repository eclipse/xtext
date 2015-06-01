/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.scoping

import com.google.common.base.Splitter
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.net.URLClassLoader
import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.List
import java.util.jar.JarFile
import org.eclipse.xtend.lib.annotations.Accessors

class ClasspathScanner {
	
	static val PROPERTY_CLASSPATH_SPLITTER = Splitter.on(':')
	static val MANIFEST_CLASSPATH_SPLITTER = Splitter.on(' ').omitEmptyStrings()
	
	@Accessors
	static val instance = new ClasspathScanner
	
	val classLoaderDescriptors = new HashMap<ClassLoader, Iterable<ClasspathTypeDescriptor>>
	
	val uriDescriptors = new HashMap<URI, Iterable<ClasspathTypeDescriptor>>
	
	def Iterable<ClasspathTypeDescriptor> getDescriptors(ClassLoader classLoader) {
		synchronized (classLoaderDescriptors) {
			if (classLoaderDescriptors.containsKey(classLoader))
				return classLoaderDescriptors.get(classLoader)
			val result = loadDescriptors(classLoader)
			classLoaderDescriptors.put(classLoader, result)
			return result
		}
	}
	
	def Iterable<ClasspathTypeDescriptor> getDescriptors(URI uri) {
		synchronized (uriDescriptors) {
			if (uriDescriptors.containsKey(uri))
				return uriDescriptors.get(uri)
			val result = loadDescriptors(uri)
			uriDescriptors.put(uri, result)
			return result
		}
	}
	
	def Iterable<ClasspathTypeDescriptor> getBootClasspathDescriptors() {
		val classpath = System.getProperty('sun.boot.class.path')
		if (classpath === null)
			return Collections.emptyList
		PROPERTY_CLASSPATH_SPLITTER.split(classpath).map[ path |
			getDescriptors(new URI('file', null, path, null))
		].flatten
	}
	
	protected def loadDescriptors(ClassLoader classLoader) {
		val classLoaderHierarchy = new LinkedList<ClassLoader>
		var cl = classLoader
		while (cl !== null) {
			classLoaderHierarchy.push(cl)
			cl = cl.parent
		}
		
		val uris = new LinkedHashSet<URI>
		while (!classLoaderHierarchy.empty) {
			cl = classLoaderHierarchy.pop()
			if (cl instanceof URLClassLoader) {
				for (url : cl.URLs) {
					uris.add(url.toURI)
				}
			}
		}
		
		return uris.map[getDescriptors].flatten
	}
	
	protected def loadDescriptors(URI uri) {
		if (uri.scheme == 'file') {
			val file = new File(uri)
			if (file.isDirectory) {
				val descriptors = new ArrayList<ClasspathTypeDescriptor>
				loadDirectoryDescriptors(file, newArrayList, descriptors)
				return descriptors
			} else if (file.exists) {
				return loadJarDescriptors(file, true)
			}
		}
		return Collections.emptyList
	}

	protected def void loadDirectoryDescriptors(File directory, List<String> packageName, List<ClasspathTypeDescriptor> descriptors) {
		for (file : directory.listFiles) {
			val fileName = file.name
			if (file.isDirectory) {
				packageName += fileName
				loadDirectoryDescriptors(file, packageName, descriptors)
				packageName.remove(packageName.size - 1)
			} else {
				val typeDesc = ClasspathTypeDescriptor.forFile(file, packageName)
				if (typeDesc !== null)
					descriptors += typeDesc
			}
		}
	}
	
	protected def loadJarDescriptors(File file, boolean includeManifestEntries) {
		var JarFile jarFile
		try {
			jarFile = new JarFile(file, false)
			
			val descriptorCollections = new ArrayList<Iterable<ClasspathTypeDescriptor>>
			if (includeManifestEntries && jarFile.manifest !== null) {
				val classpath = jarFile.manifest.mainAttributes.getValue('Class-Path')
				if (classpath !== null) {
					for (path : MANIFEST_CLASSPATH_SPLITTER.split(classpath)) {
						try {
							var uri = new URI(path)
							if (!uri.isAbsolute)
								uri = new File(file.parentFile, path.replace('/', File.separator)).toURI
							descriptorCollections += getDescriptors(uri)
						} catch (URISyntaxException exception) {
							// Bad classpath entry
						}
					}
				}
			}
			
			val descriptors = new ArrayList<ClasspathTypeDescriptor>
			val entries = jarFile.entries
			while (entries.hasMoreElements) {
				val entry = entries.nextElement
				if (!entry.isDirectory && !entry.name.startsWith('META-INF')) {
					val typeDesc = ClasspathTypeDescriptor.forJarEntry(entry, jarFile)
					if (typeDesc !== null)
						descriptors += typeDesc
				}
			}
			if (descriptorCollections.empty)
				return descriptors
			else {
				descriptorCollections.add(descriptors)
				return descriptorCollections.flatten
			}
		} catch (IOException exception) {
			return Collections.emptyList
		} finally {
			if (jarFile !== null)
				jarFile.close()
		}
	}
	
}