package org.eclipse.xtext.xbase.tests.typing

import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.annotations.typing.XbaseWithAnnotationsTypeProvider
import com.google.inject.Singleton
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.common.types.JvmDeclaredType

@Singleton
class SomeCustomTypeProviderWithXtend extends XbaseWithAnnotationsTypeProvider {
	
	def dispatch type(XBinaryOperation binaryOperation, JvmTypeReference rawExpectation, boolean rawType) {
		if (true)
			throw new RuntimeException("This is expected")
		else
			null as JvmTypeReference
	}
	
	def dispatch expectedType(XMemberFeatureCall container, EReference reference, int index,
			boolean rawType) {
		if (true)
			throw new RuntimeException("This is expected")
		else
			null as JvmTypeReference		
	}
	
	def dispatch typeForIdentifiable(JvmDeclaredType identifiable, boolean rawType) {
		if (true)
			throw new RuntimeException("This is expected")
		else
			null as JvmTypeReference		
	}
	
}