/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.java.resource

import java.util.Collections
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Function
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.jdt.internal.compiler.env.IBinaryType
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.internal.EmfAdaptable

/**
 * A cache for parsed class or java source file content. It is bound to the
 * lifecycle of a resource set.
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.15
 */
@EmfAdaptable
class ClassFileCache {
	
	static val NULL = new Object();
	
	val Map<QualifiedName, Object> cache = new ConcurrentHashMap()
	val Set<Resource> resourcesToCompile = Collections.newSetFromMap(new ConcurrentHashMap())
	val Map<char[], List<String>> allTopLevelTypes = new ConcurrentHashMap()
	val Map<char[], Map<String, byte[]>> allClassMaps = new ConcurrentHashMap()
	
	def boolean containsKey(QualifiedName qualifiedName) {
		return cache.containsKey(qualifiedName)
	}
	
	def IBinaryType get(QualifiedName qualifiedName) {
		val result = cache.get(qualifiedName)
		if (result === NULL) {
			return null
		}
		return result as IBinaryType
	}
	
	def void put(QualifiedName qualifiedName, IBinaryType answer) {
		if (answer === null) {
			cache.put(qualifiedName, NULL)
		} else {
			cache.put(qualifiedName, answer)
		}
	}
	
	def IBinaryType computeIfAbsent(QualifiedName qualifiedName, Function<? super QualifiedName, ? extends IBinaryType> fun) {
		val result = cache.computeIfAbsent(qualifiedName) [
			fun.apply(it) ?: NULL
		]
		if (result instanceof IBinaryType) {
			return result
		}
		return null
	}
	
	def void clear() {
		cache.clear()
		resourcesToCompile.clear()
	}
	
	def void addResourceToCompile(Resource resource) {
		resourcesToCompile.add(resource)
	}
	
	def Set<Resource> drainResourcesToCompile() {
		val result = new HashSet(resourcesToCompile)
		resourcesToCompile.clear
		return result;
	}
	
	def boolean popCompileResult(char[] fileName, (List<String>, Map<String, byte[]>)=>void consumer) {
		if (allTopLevelTypes.containsKey(fileName)) {
			consumer.apply(allTopLevelTypes.remove(fileName), allClassMaps.remove(fileName))
			return true;
		}
		return false;
	}
	
	def void addCompileResult(char[] fileName, List<String> topLevelTypes, Map<String, byte[]> classMap) {
		allTopLevelTypes.put(fileName, topLevelTypes)
		allClassMaps.put(fileName, classMap)
	}
	
}