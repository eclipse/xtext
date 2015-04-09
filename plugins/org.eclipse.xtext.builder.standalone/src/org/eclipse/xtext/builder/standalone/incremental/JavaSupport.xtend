/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.inject.Inject
import java.io.File
import java.net.URLClassLoader
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
class JavaSupport {
	
	@Inject TypeResourceServices typeResourceServices
	@Inject IndexedJvmTypeAccess typeAccess
	
	def void installLocalOnlyTypeProvider(Iterable<File> classPathRoots, XtextResourceSet resSet) {
		val classLoader = createURLClassLoader(classPathRoots)
		new ClasspathTypeProvider(classLoader, resSet, null, typeResourceServices)
		resSet.setClasspathURIContext(classLoader);
	}
	
	def void installTypeProvider(Iterable<File> classPathRoots, XtextResourceSet resSet) {
		val classLoader = createURLClassLoader(classPathRoots)
		new ClasspathTypeProvider(classLoader, resSet, typeAccess, typeResourceServices)
		resSet.setClasspathURIContext(classLoader);
	}

	def protected URLClassLoader createURLClassLoader(Iterable<File> classPathEntries) {
		val classPathUrls = classPathEntries.map[toURI.toURL]
		return new URLClassLoader(classPathUrls)
	}
}