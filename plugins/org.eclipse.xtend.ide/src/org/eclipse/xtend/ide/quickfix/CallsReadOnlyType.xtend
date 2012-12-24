package org.eclipse.xtend.ide.quickfix

import org.eclipse.xtext.common.types.JvmType
import com.google.inject.Inject
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.xtext.xbase.XMemberFeatureCall

class CallsReadOnlyType {
	
	extension IJavaElementFinder elementFinder
	extension FeatureCallTargetTypeProvider targetTypeProvider

	@Inject 
	new(IJavaElementFinder elementFinder, FeatureCallTargetTypeProvider targetTypeProvider){
		this.elementFinder = elementFinder
		this.targetTypeProvider = targetTypeProvider
	}
		
	def receiverIsReadOnly(XMemberFeatureCall featureCall) {
		return featureCall.targetType?.targetJavaElement?.isReadOnly
	}
	
	def private targetJavaElement(JvmType type){
		findElementFor(type)
	}
	
}