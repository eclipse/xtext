package org.eclipse.xtend.ide.quickfix

import org.eclipse.xtext.xbase.XMemberFeatureCall
import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.emf.ecore.EObject

class IsUndefinedMethod {
	
	@Inject extension FeatureCallTargetTypeProvider
	@Inject extension ITypeProvider
	
	def callsUndefinedMethod(XMemberFeatureCall featureCall){
		if(featureCall.targetType.isUnknown){
			return false
		}
		val method = featureCall.feature
		if(method == null){
			return false
		}
		if(method.eIsProxy){
			return true
		}
		if(!(method instanceof JvmOperation)){
			return false
		}
		return featureCall.calls(method as JvmOperation)
	}
	
	def private calls(XMemberFeatureCall featureCall, JvmOperation operation){
		val left = operation.parameters
		val right = featureCall.memberCallArguments
		if(left.size != right.size){
			return true
		}
		var i = 0
		
		while(i < operation.parameters.size){
			if(left.get(i).parameterType != right.get(i).type){
				return true
			}
			i = i + 1
		}		
		return false
	}
	
	def private isUnknown(EObject obj){
		obj == null || obj.eIsProxy
	}
	
}