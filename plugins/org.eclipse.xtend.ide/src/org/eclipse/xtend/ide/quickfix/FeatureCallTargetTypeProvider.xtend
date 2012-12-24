package org.eclipse.xtend.ide.quickfix

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.typing.ITypeProvider

class FeatureCallTargetTypeProvider {
	
	@Inject extension ITypeProvider
	
	def targetType(XMemberFeatureCall featureCall){
		featureCall.targetFeature?.typeForIdentifiable?.type
	}
	
	def private JvmIdentifiableElement targetFeature(XMemberFeatureCall featureCall){
		val memberCallTarget = featureCall.memberCallTarget
		if(memberCallTarget instanceof XConstructorCall){
			return (memberCallTarget as XConstructorCall).constructor?.declaringType
		}
		if(!(memberCallTarget instanceof XAbstractFeatureCall)){
			return null
		}
		(memberCallTarget as XAbstractFeatureCall).feature
	}
	
}