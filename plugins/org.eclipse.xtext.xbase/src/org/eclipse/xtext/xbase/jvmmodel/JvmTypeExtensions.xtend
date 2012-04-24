package org.eclipse.xtext.xbase.jvmmodel

import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.common.types.JvmConstructor
import com.google.inject.Inject

class JvmTypeExtensions {
	
	@Inject extension ILogicalContainerProvider 
	
	def (ITreeAppendable)=>void getCompilationStrategy(JvmIdentifiableElement it) {
		val adapter = eAdapters.filter(typeof(CompilationStrategyAdapter)).head
		return adapter?.compilationStrategy
	}
	
	def isSingleSyntheticDefaultConstructor(JvmConstructor it) {
		return parameters.empty && associatedExpression == null && compilationStrategy == null && declaringType.members.filter(typeof(JvmConstructor)).size == 1
	}
}