package org.eclipse.xtend.core.macro

import com.google.inject.Singleton
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet

@Singleton
class ProcessorInstanceForJvmTypeProvider {
	
	static val logger = Logger::getLogger(typeof(ProcessorInstanceForJvmTypeProvider))
	
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
			logger.error(e.toString)
			return null
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
		logger.error("No class loader configured or annotation processing.")
		return null
	}
}