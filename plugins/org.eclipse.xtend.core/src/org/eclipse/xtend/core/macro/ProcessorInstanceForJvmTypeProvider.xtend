/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.inject.Singleton
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet

@Singleton
class ProcessorInstanceForJvmTypeProvider {
	
	static val logger = Logger.getLogger(ProcessorInstanceForJvmTypeProvider)
	
	private ClassLoader classLoader;
	
	def void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader
	}
	
	/**
	 * @return an instance of the given JvmType
	 */
	def Object getProcessorInstance(JvmType type) {
		try {
			val loadClass = type.classLoader?.loadClass(type.identifier)
			return loadClass?.newInstance
		} catch (Exception e) {
			throw new IllegalStateException("Problem during instantiation of "+type.identifier+" : "+e.getMessage, e);
		}
	}
	
	def protected getClassLoader(EObject ctx) {
		if (classLoader != null)
			return classLoader
		val resourceSet = ctx.eResource.resourceSet
		switch resourceSet {
			XtextResourceSet : {
				val classLoaderCtx = resourceSet.classpathURIContext
				switch classLoaderCtx {
					ClassLoader : return classLoaderCtx
					Class<?> : return classLoaderCtx.classLoader
				}
			}
		}
		logger.info("No class loader configured. Trying with this class' classloader.")
		return class.classLoader
	}
}