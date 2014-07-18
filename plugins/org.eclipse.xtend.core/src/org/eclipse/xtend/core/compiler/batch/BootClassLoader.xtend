/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.compiler.batch

import com.google.common.collect.Maps
import java.io.IOException
import java.net.URL
import java.net.URLClassLoader
import java.util.concurrent.ConcurrentMap

/**
 * Use this classloader as a parent in order to supply different JDK classes than the
 * currently running VM.
 * @since 2.7
 */
class BootClassLoader extends URLClassLoader {
	private final ConcurrentMap<String, Object> locks = Maps.newConcurrentMap;

	new(URL[] urls) {
		super(urls)
	}

	override protected loadClass(String name, boolean resolve) throws ClassNotFoundException {
		synchronized (getClassLoadingLockJdk5(name)) {
			val c = findLoadedClass(name) ?: findClass(name)
			if (resolve) {
				resolveClass(c)
			}
			c
		}
	}

	override getResource(String name) {
		findResource(name)
	}

	override getResources(String name) throws IOException {
		findResources(name)
	}

	private def Object getClassLoadingLockJdk5(String className) {
		val newLock = new Object
		val existingLock = locks.putIfAbsent(className, newLock)
		return existingLock ?: newLock
	}
}
