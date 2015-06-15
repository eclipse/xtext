/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.types

import com.google.common.base.Splitter
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.net.URLClassLoader
import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import java.util.HashMap
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.List
import java.util.jar.JarFile

class ClasspathScanner {
	
	static val PROPERTY_CLASSPATH_SPLITTER = Splitter.on(File.pathSeparatorChar)
	static val MANIFEST_CLASSPATH_SPLITTER = Splitter.on(' ').omitEmptyStrings()
	
	val classLoaderDescriptors = new HashMap<Pair<ClassLoader, Collection<String>>, Iterable<ClasspathTypeDescriptor>>
	
	val uriDescriptors = new HashMap<Pair<URI, Collection<String>>, Iterable<ClasspathTypeDescriptor>>
	
	def Iterable<ClasspathTypeDescriptor> getDescriptors(ClassLoader classLoader, Collection<String> packagePrefixes) {
		val key = new Pair(classLoader, packagePrefixes)
		synchronized (classLoaderDescriptors) {
			var result = classLoaderDescriptors.get(key)
			if (result === null) {
				result = loadDescriptors(classLoader, packagePrefixes)
				classLoaderDescriptors.put(key, result)
			}
			return result
		}
	}
	
	def Iterable<ClasspathTypeDescriptor> getDescriptors(URI uri, Collection<String> packagePrefixes) {
		val key = new Pair(uri, packagePrefixes)
		synchronized (uriDescriptors) {
			var result = uriDescriptors.get(key)
			if (result === null) {
				result = loadDescriptors(uri, packagePrefixes)
				uriDescriptors.put(key, result)
			}
			return result
		}
	}
	
	def Iterable<ClasspathTypeDescriptor> getBootClasspathDescriptors(Collection<String> packagePrefixes) {
		val classpath = System.getProperty('sun.boot.class.path')
		if (classpath === null)
			return Collections.emptyList
		PROPERTY_CLASSPATH_SPLITTER.split(classpath).map[ path |
			getDescriptors(new URI('file', null, path, null), packagePrefixes)
		].flatten
	}
	
	protected def loadDescriptors(ClassLoader classLoader, Collection<String> packagePrefixes) {
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
				for (url : cl.getURLs) {
					uris.add(url.toURI)
				}
			}
		}
		
		return uris.map[getDescriptors(packagePrefixes)].flatten
	}
	
	protected def loadDescriptors(URI uri, Collection<String> packagePrefixes) {
		if (uri.scheme == 'file') {
			val file = new File(uri)
			if (file.isDirectory) {
				val descriptors = new ArrayList<ClasspathTypeDescriptor>
				loadDirectoryDescriptors(file, '', descriptors, packagePrefixes)
				return descriptors
			} else if (file.exists) {
				return loadJarDescriptors(file, true, packagePrefixes)
			}
		}
		return Collections.emptyList
	}

	protected def void loadDirectoryDescriptors(File directory, String packageName, List<ClasspathTypeDescriptor> descriptors,
			Collection<String> packagePrefixes) {
		for (file : directory.listFiles) {
			if (file.isDirectory) {
				val subPackageName = if (packageName.empty) file.name else packageName + '.' + file.name
				loadDirectoryDescriptors(file, subPackageName, descriptors, packagePrefixes)
			} else {
				val typeDesc = ClasspathTypeDescriptor.forFile(file, packageName, packagePrefixes)
				if (typeDesc !== null)
					descriptors += typeDesc
			}
		}
	}
	
	protected def loadJarDescriptors(File file, boolean includeManifestEntries, Collection<String> packagePrefixes) {
		var JarFile jarFile
		try {
			jarFile = new JarFile(file, false)
			
			var List<Iterable<ClasspathTypeDescriptor>> descriptorCollections
			if (includeManifestEntries && jarFile.manifest !== null) {
				val classpath = jarFile.manifest.mainAttributes.getValue('Class-Path')
				if (classpath !== null) {
					descriptorCollections = new ArrayList<Iterable<ClasspathTypeDescriptor>>
					for (path : MANIFEST_CLASSPATH_SPLITTER.split(classpath)) {
						try {
							var uri = new URI(path)
							if (!uri.isAbsolute)
								uri = new File(file.parentFile, path.replace('/', File.separator)).toURI
							descriptorCollections += getDescriptors(uri, packagePrefixes)
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
					val typeDesc = ClasspathTypeDescriptor.forJarEntry(entry, jarFile, packagePrefixes)
					if (typeDesc !== null)
						descriptors += typeDesc
				}
			}
			if (descriptorCollections === null)
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
