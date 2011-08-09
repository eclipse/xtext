package org.eclipse.xtext.example.domainmodel.jvmmodel

import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider

class DomainmodelIdentifiableSimpleNameProvider extends IdentifiableSimpleNameProvider {
	
	def dispatch getSimpleName(JvmType element) {
		return "this";
	}
	
	def dispatch getSimpleName(JvmIdentifiableElement element) {
		return super.getSimpleName(element);
	}
}