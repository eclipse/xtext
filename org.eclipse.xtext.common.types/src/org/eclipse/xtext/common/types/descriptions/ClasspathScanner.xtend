/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import io.github.classgraph.ClassGraph
import io.github.classgraph.ScanResult
import java.util.ArrayList
import java.util.Collection
import java.util.concurrent.TimeUnit
import org.eclipse.xtend.lib.annotations.Data
import com.google.inject.Singleton
import com.google.inject.Provider
import com.google.inject.Inject

@Singleton
class ClasspathScanner {
	
	@Data
	protected static class ClassLoaderPackageConfig {
		val ClassLoader loader
		val boolean bootstrap
		val Collection<String> packagePrefixes
	}
	
	@Inject
	Provider<ClassGraph> classGraphProvider = [ new ClassGraph ]
	
	Cache<ClassLoaderPackageConfig, Iterable<ITypeDescriptor>> classLoaderDescriptors = createClassLoaderCache()
	
	protected def Cache<ClassLoaderPackageConfig, Iterable<ITypeDescriptor>> createClassLoaderCache() {
		CacheBuilder.newBuilder
			.initialCapacity(8)
			.concurrencyLevel(2)
			.maximumSize(32)
			.expireAfterAccess(5, TimeUnit.MINUTES)
			.build()
	}
	
	def Iterable<ITypeDescriptor> getDescriptors(ClassLoader classLoader, Collection<String> packagePrefixes) {
		return classLoader.getDescriptors(false, packagePrefixes)
	}
	
	protected def Iterable<ITypeDescriptor> getDescriptors(ClassLoader classLoader, boolean bootstrap, Collection<String> packagePrefixes) {
		return classLoaderDescriptors.get(new ClassLoaderPackageConfig(classLoader, bootstrap, packagePrefixes), [
			loadDescriptors(classLoader, bootstrap, packagePrefixes)
		])
	}
	
	def Iterable<ITypeDescriptor> getBootClasspathDescriptors(Collection<String> packagePrefixes) {
		return ClassLoader.systemClassLoader.getDescriptors(true, packagePrefixes)
	}
	
	var String[] systemClasspath = null
	
	def String[] getSystemClasspath() {
		if (systemClasspath !== null) {
			return systemClasspath;
		}
		try (val ScanResult scanResult = classGraphProvider.get()
				.enableSystemJarsAndModules()
				.addClassLoader(ClassLoader.getSystemClassLoader())
				.scan()) {
			val classpathURIs = scanResult.classpathURIs
			systemClasspath = classpathURIs.map[path].filterNull
			return systemClasspath;
		}
	}
	
	protected def Iterable<ITypeDescriptor> loadDescriptors(ClassLoader classLoader, boolean bootstrap,
		Collection<String> packagePrefixes) {
		val classGraph = classGraphProvider.get()
			.ignoreClassVisibility()
			.enableClassInfo()
			.whitelistPackages(packagePrefixes.toArray(#[]))
			.addClassLoader(classLoader)
		
		if (bootstrap) {
			classGraph.enableSystemJarsAndModules()
		}
		try (val ScanResult scanResult = classGraph.scan()) {
			return scanResult.loadDescriptors
		}
	}
	
	protected def Iterable<ITypeDescriptor> loadDescriptors(ScanResult scanResult) {
		val result = new ArrayList<ITypeDescriptor>
		scanResult.allClasses.forEach [ clazz |
			// filter types that did not match the scan spec but are referenced transitively
			if (clazz.resource !== null) {
				result.add(newDescriptor(clazz.name, clazz.modifiers))
			}
		]
		return result
	}
	
	protected def ITypeDescriptor newDescriptor(String name, int modifiers) {
		return new ClasspathTypeDescriptor(name, modifiers)
	}
	
}
