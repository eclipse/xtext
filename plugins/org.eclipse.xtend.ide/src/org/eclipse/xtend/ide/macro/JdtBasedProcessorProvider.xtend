/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.macro

import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.launching.JavaRuntime
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet

class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
	
	override getProcessorInstance(JvmType type) {
		try {
			val project = (type.eResource.resourceSet as XtextResourceSet).classpathURIContext as IJavaProject
			val classLoader = createClassLoaderForJavaProject(project)
			val result = classLoader.loadClass(type.identifier)
			return result.newInstance
		} catch (Exception e) {
			throw new IllegalStateException("Problem during instantiation of "+type.identifier+" : "+e.getMessage, e);
		}
	}
	
	override getClassLoader(EObject ctx) {
		val project = (ctx.eResource.resourceSet as XtextResourceSet).classpathURIContext as IJavaProject
		return createClassLoaderForJavaProject(project)
	}
	
	protected def createClassLoaderForJavaProject(IJavaProject projectToUse) {
		val classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(projectToUse)
		val List<URL> urls = classPathEntries.map[new File(it).toURI.toURL].toList
		return new URLClassLoader(urls, getParentClassLoader())
	}
	
	protected def getParentClassLoader() {
		val bundleClassLoader = TransformationContext.classLoader
		return bundleClassLoader
	}
	
}