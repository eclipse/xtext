/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.Collections
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode

@Accessors
@EqualsHashCode
class TypeReference {
	
	static def TypeReference typeRef(String name, String... arguments) {
		new TypeReference(name, arguments.map[new TypeReference(it)])
	}
	
	static def TypeReference typeRef(Class<?> clazz, Class<?>... arguments) {
		new TypeReference(clazz, arguments.map[new TypeReference(it)])
	}
	
	val String name
	
	val List<TypeReference> arguments
	
	new(String name) {
		this.name = name
		this.arguments = Collections.emptyList
	}

	new(String name, List<TypeReference> arguments) {
		this.name = name
		this.arguments = Collections.unmodifiableList(arguments)
	}
	
	new(String packageName, String className) {
		this.name = packageName + '.' + className
		this.arguments = Collections.emptyList
	}
	
	new(Class<?> clazz) {
		this.name = clazz.name.replace('$', '.')
		this.arguments = Collections.emptyList
	}
	
	new(Class<?> clazz, List<TypeReference> arguments) {
		this.name = clazz.name.replace('$', '.')
		this.arguments = Collections.unmodifiableList(arguments)
	}
	
	override toString() {
		name + arguments.join('<', ', ', '>', [toString])
	}
	
	def String getSimpleName() {
		val simpleNameIndex = name.lastIndexOf('.')
		return name.substring(simpleNameIndex + 1)
	}
	
	def String getPackage() {
		var packageEnd = name.length
		for (var i = name.length - 1; i >= 0; i--) {
			if (name.charAt(i).matches('.')) {
				if (Character.isLowerCase(name.charAt(i + 1)))
					return name.substring(0, packageEnd)
				else
					packageEnd = i
			}
		}
		return ''
	}
	
	def String getPath() {
		val packageName = getPackage
		var className = name.substring(packageName.length + 1)
		val outerClassEnd = className.indexOf('.')
		if (outerClassEnd >= 0)
			className = className.substring(0, outerClassEnd)
		return packageName.replace('.', '/') + '/' + className + '.java'
	}
	
	private def matches(char c1, char c2) {
		c1 == c2
	}
	
}