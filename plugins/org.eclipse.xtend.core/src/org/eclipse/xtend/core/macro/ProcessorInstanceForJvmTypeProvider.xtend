/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.inject.Singleton
import java.io.Closeable
import java.io.IOException
import java.net.URLClassLoader
import org.apache.log4j.Logger
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet

@Singleton
class ProcessorInstanceForJvmTypeProvider {
	static val logger = Logger.getLogger(ProcessorInstanceForJvmTypeProvider)
	
	@Accessors public static class ProcessorClassloaderAdapter extends AdapterImpl {
		var ClassLoader classLoader
		
		new(ClassLoader classLoader) {
			this.classLoader = classLoader
		}

		override isAdapterForType(Object type) {
			type == ProcessorClassloaderAdapter
		}
		
		override unsetTarget(Notifier oldTarget) {
			discard()
		}
		
		override setTarget(Notifier newTarget) {
			if (newTarget==null) {
				discard()
			}
		}
		
		def discard() {
			if (classLoader instanceof Closeable) {
				try {
					(classLoader as Closeable).close
					classLoader = null
				} catch (IOException e) {
					logger.error(e.message, e)
				}
			}
		}
		
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
		val resourceSet = ctx.eResource.resourceSet
		val adapter = resourceSet.eAdapters.filter(ProcessorClassloaderAdapter).head
		if (adapter != null) {
			return adapter.getClassLoader
		}
		switch resourceSet {
			XtextResourceSet : {
				val classLoaderCtx = resourceSet.classpathURIContext
				val jvmTypeLoader = switch classLoaderCtx {
					ClassLoader : classLoaderCtx
					Class<?> : classLoaderCtx.classLoader
				}
				val processorClassLoader = if (jvmTypeLoader instanceof URLClassLoader) {
					new URLClassLoader(jvmTypeLoader.URLs, TransformationContext.classLoader)
				} else {
					jvmTypeLoader
				}
				if (processorClassLoader != null) {
					resourceSet.eAdapters += new ProcessorClassloaderAdapter(processorClassLoader)
					return processorClassLoader
				}
			}
		}
		logger.info("No class loader configured. Trying with this class classloader.")
		return class.classLoader
	}
}