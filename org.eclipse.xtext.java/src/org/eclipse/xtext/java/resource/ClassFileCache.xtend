/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.java.resource

import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Function
import org.eclipse.jdt.internal.compiler.env.IBinaryType
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.internal.EmfAdaptable

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
@EmfAdaptable
class ClassFileCache {
	
	static val NULL = new Object();
	
	//TODO: concurrency
	//TODO: clear
	//TODO: weak?
	// type if Object by intention, but we store IBinaryTypes only
	val Map<QualifiedName, Object> cache = new ConcurrentHashMap()
	
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
		if (result !== NULL) { // TODO should this ever happen
			return result as IBinaryType;
		}
		return null
	}
	
	def void clear() {
		cache.clear()
	}
	
}