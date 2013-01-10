package org.eclipse.xtend.core.macro

import org.eclipse.xtext.common.types.JvmType

class ProcessorInstanceForJvmTypeProvider {
	
	@Property ClassLoader classLoaderToUse = typeof(ProcessorInstanceForJvmTypeProvider).classLoader
	
	/**
	 * @return an instance of the given JvmType
	 */
	def Object getProcessorInstance(JvmType type) {
		try {
			val loadClass = classLoaderToUse.loadClass(type.identifier)
			return loadClass.newInstance
		} catch (Exception e) {
			return null
		}
	}
}