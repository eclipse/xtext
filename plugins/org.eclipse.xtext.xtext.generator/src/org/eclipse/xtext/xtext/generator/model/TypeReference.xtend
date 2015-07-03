/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import org.eclipse.xtend.lib.annotations.EqualsHashCode

@EqualsHashCode
class TypeReference {
	
	val String name

	new(String name) {
		this.name = name
	}
	
	new(String packageName, String className) {
		this.name = packageName + '.' + className
	}
	
	new(Class<?> clazz) {
		this.name = clazz.name.replace('$', '.')
	}
	
	override toString() {
		name
	}
	
	def getName() {
		name
	}
	
	def getSimpleName() {
		val simpleNameIndex = name.lastIndexOf('.')
		return name.substring(simpleNameIndex + 1)
	}
	
	def getPackage() {
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
	
	private def matches(char c1, char c2) {
		c1 == c2
	}
	
}