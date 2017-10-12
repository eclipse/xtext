/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import java.util.List

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class FilteringClassLoader extends ClassLoader {
	
	static val char DOT = '.'
	static val char SLASH = '/'
	
	val List<String> includes
	val List<String> resourceIncludes

	new(ClassLoader parent, List<String> includes) {
		super(parent)
		this.includes = includes
		this.resourceIncludes = includes.map[replace(DOT,SLASH)]
	}

	override loadClass(String name, boolean resolve) throws ClassNotFoundException {
		try {
			return ClassLoader.systemClassLoader.parent?.loadClass(name)
		} catch(ClassNotFoundException ignored) {
		}
		
		if (name.isValidClass) {
			val result = super.loadClass(name, false)
			if (resolve) {
				resolveClass(result)
			}
			return result
		} else {
			throw new ClassNotFoundException(name)
		}
	}

	override getResource(String name) {
		val result = ClassLoader.systemClassLoader.parent?.getResource(name)
		if (result !== null) {
			return result
		}
		if (name.isValidResource) {
			return super.getResource(name)
		}
		return null
	}

	private def isValidClass(String name) {
		includes.exists[name.startsWith(it + DOT)]
	}
	
	private def isValidResource(String name) {
		resourceIncludes.exists[name.startsWith(it + SLASH)]
	}

}
