/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.util

/**
 * @author kosyakov - Initial contribution and API
 */
class FilteringClassLoader extends ClassLoader {

	val (String)=>boolean filter
	
	new(ClassLoader parent, (String)=>boolean filter) {
		super(parent)
		this.filter = filter
	}
	
	override protected loadClass(String name, boolean resolve) throws ClassNotFoundException {
		try {
			return ClassLoader.systemClassLoader.parent?.loadClass(name)
		} catch (ClassNotFoundException e) {
			// do nothing
		}
		
		if (!filter.apply(name))
			throw new ClassNotFoundException(name)

		return super.loadClass(name, resolve)
	}

}
