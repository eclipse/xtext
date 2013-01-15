package org.eclipse.xtend.core.macro

import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.emf.ecore.EObject
import org.apache.log4j.Logger

class ProcessorInstanceForJvmTypeProvider {
	
	static val logger = Logger::getLogger(typeof(ProcessorInstanceForJvmTypeProvider))
	
	/**
	 * @return an instance of the given JvmType
	 */
	def Object getProcessorInstance(JvmType type) {
		try {
			val loadClass = type.classLoader?.loadClass(type.identifier)
			return loadClass?.newInstance
		} catch (Exception e) {
			logger.error(e.toString)
			return null
		}
	}
	
	def protected getClassLoader(EObject ctx) {
		val resourceSet = ctx.eResource.resourceSet
		switch resourceSet {
			XtextResourceSet : {
				val classLoaderCtx = resourceSet.classpathURIContext
				switch classLoaderCtx {
					ClassLoader : return classLoaderCtx
					Class<?> : return classLoaderCtx.classLoader
					default : {
						logger.error("Unsupported classloader context in resource set : "+classLoaderCtx)
					}
				}
			}
		}
		return null
	}
}