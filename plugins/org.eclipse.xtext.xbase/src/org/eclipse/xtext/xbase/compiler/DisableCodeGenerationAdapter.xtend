package org.eclipse.xtext.xbase.compiler

import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.emf.ecore.util.EcoreUtil

class DisableCodeGenerationAdapter extends AdapterImpl {
	
	override isAdapterForType(Object type) {
		getClass == type
	}
	
	def static boolean isDisabled(JvmDeclaredType type) { 
		getAdapter(type) != null
	}
	
	def static void disableCodeGeneration(JvmDeclaredType declaredType) {
		if (getAdapter(declaredType) == null) {
			declaredType.eAdapters.add(new DisableCodeGenerationAdapter)
		}
	}
	
	def static void enableCodeGeneration(JvmDeclaredType declaredType) {
		val adapter = getAdapter(declaredType)
		if (adapter != null) {
			declaredType.eAdapters.remove(adapter)
		}
	}
	
	def private static getAdapter(JvmDeclaredType declaredType) {
		return EcoreUtil::getAdapter(declaredType.eAdapters, typeof(DisableCodeGenerationAdapter))
	}
}