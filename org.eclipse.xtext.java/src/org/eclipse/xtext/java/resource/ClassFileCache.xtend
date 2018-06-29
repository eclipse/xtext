/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.java.resource

import java.util.HashMap
import java.util.Map
import org.eclipse.jdt.internal.compiler.env.IBinaryType
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.util.internal.EmfAdaptable

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
@EmfAdaptable
class ClassFileCache {
	
	//TODO: concurrency
	//TODO: clear
	//TODO: weak?
	val Map<QualifiedName, IBinaryType> cache = new HashMap()
	
	def boolean containsKey(QualifiedName qualifiedName) {
		return cache.containsKey(qualifiedName)
	}
	
	def IBinaryType get(QualifiedName qualifiedName) {
		return cache.get(qualifiedName)
	}
	
	def void put(QualifiedName qualifiedName, IBinaryType answer) {
		cache.put(qualifiedName, answer)
	}
	
	def void clear() {
		cache.clear()
	}
	
}