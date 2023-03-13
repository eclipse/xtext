/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.compiler.batch

import com.google.common.collect.Maps
import java.io.IOException
import java.net.URL
import java.net.URLClassLoader
import java.util.concurrent.ConcurrentMap

/**
 * @deprecated This was an accidently exposed implementation detail of the batch compiler
 * @since 2.7
 */
@Deprecated
class BootClassLoader extends URLClassLoader {
	final ConcurrentMap<String, Object> locks = Maps.newConcurrentMap;

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
