package org.eclipse.xtend.ide.macro

import java.net.URL
import java.net.URLClassLoader
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet

class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
	
	static val LOG = Logger::getLogger(typeof(JdtBasedProcessorProvider))
	
	override getProcessorInstance(JvmType type) {
		try {
			val project = (type.eResource.resourceSet as XtextResourceSet).classpathURIContext as IJavaProject
			val List<URL> urls =  project.rawClasspath.map[it.path.toFile.toURL]
			val classLoader = new URLClassLoader(urls, typeof(ProcessorInstanceForJvmTypeProvider).classLoader)
			val result = classLoader.loadClass(type.identifier)
			return result.newInstance
		} catch (Exception e) {
			LOG.info(e)
			return null
		}
	}
	
}