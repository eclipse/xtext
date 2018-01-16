/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.types

import com.google.common.base.Splitter
import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException
import java.net.URLClassLoader
import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import java.util.LinkedHashSet
import java.util.LinkedList
import java.util.List
import java.util.concurrent.TimeUnit
import java.util.jar.JarFile

class ClasspathScanner {
	
	static val PROPERTY_CLASSPATH_SPLITTER = Splitter.on(File.pathSeparatorChar)
	static val MANIFEST_CLASSPATH_SPLITTER = Splitter.on(' ').omitEmptyStrings()
	
	
	Cache<Pair<ClassLoader, Collection<String>>, Iterable<ITypeDescriptor>> classLoaderDescriptors
	
	Cache<Pair<URI, Collection<String>>, Iterable<ITypeDescriptor>> uriDescriptors
	
	protected def Cache<Pair<ClassLoader, Collection<String>>, Iterable<ITypeDescriptor>> createClassLoaderCache() {
		CacheBuilder.newBuilder
			.initialCapacity(8)
			.concurrencyLevel(2)
			.maximumSize(32)
			.expireAfterAccess(5, TimeUnit.MINUTES)
			.build()
	}
	
	protected def Cache<Pair<URI, Collection<String>>, Iterable<ITypeDescriptor>> createUriCache() {
		CacheBuilder.newBuilder
			.initialCapacity(64)
			.concurrencyLevel(2)
			.maximumSize(256)
			.expireAfterAccess(30, TimeUnit.MINUTES)
			.build()
	}
	
	def Iterable<ITypeDescriptor> getDescriptors(ClassLoader classLoader, Collection<String> packagePrefixes) {
		synchronized (this) {
			if (classLoaderDescriptors === null)
				classLoaderDescriptors = createClassLoaderCache()
		}
		return classLoaderDescriptors.get(classLoader -> packagePrefixes, [
			loadDescriptors(classLoader, packagePrefixes)
		])
	}
	
	def Iterable<ITypeDescriptor> getDescriptors(URI uri, Collection<String> packagePrefixes) {
		synchronized (this) {
			if (uriDescriptors === null)
				uriDescriptors = createUriCache()
		}
		return uriDescriptors.get(uri -> packagePrefixes, [
			loadDescriptors(uri, packagePrefixes)
		])
	}
	
	def Iterable<ITypeDescriptor> getBootClasspathDescriptors(Collection<String> packagePrefixes) {
		val classpath = System.getProperty('sun.boot.class.path')
		if (classpath === null)
			return Collections.emptyList
		PROPERTY_CLASSPATH_SPLITTER.split(classpath).map[ path |
			getDescriptors(new File(path).toURI, packagePrefixes)
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
		
		uris.map[getDescriptors(packagePrefixes)].flatten
	}
	
	protected def loadDescriptors(URI uri, Collection<String> packagePrefixes) {
		if (uri.scheme == 'file') {
			val file = new File(uri)
			if (file.isDirectory) {
				val descriptors = new ArrayList<ITypeDescriptor>
				loadDirectoryDescriptors(file, '', descriptors, packagePrefixes)
				return descriptors
			} else if (file.exists) {
				return loadJarDescriptors(file, true, packagePrefixes)
			}
		}
		return Collections.emptyList
	}

	protected def void loadDirectoryDescriptors(File directory, String packageName, List<ITypeDescriptor> descriptors,
			Collection<String> packagePrefixes) {
		val children = directory.listFiles
		if(children === null) {
			return
		}
		for (file : children) {
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
			
			var List<Iterable<ITypeDescriptor>> descriptorCollections
			if (includeManifestEntries && jarFile.manifest !== null) {
				val classpath = jarFile.manifest.mainAttributes.getValue('Class-Path')
				if (classpath !== null) {
					descriptorCollections = new ArrayList<Iterable<ITypeDescriptor>>
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
			
			val descriptors = new ArrayList<ITypeDescriptor>
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
