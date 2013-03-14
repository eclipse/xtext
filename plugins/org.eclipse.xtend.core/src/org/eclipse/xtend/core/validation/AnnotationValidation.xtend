package org.eclipse.xtend.core.validation

import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check

import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.xbase.annotations.validation.XbaseWithAnnotationsJavaValidator

class AnnotationValidation extends AbstractDeclarativeValidator {
	
	override protected getEPackages() {
		newArrayList(XtendPackage::eINSTANCE, XbasePackage::eINSTANCE, XAnnotationsPackage::eINSTANCE)
	}
	
	@Check def checkAnnotation(XtendAnnotationType it) {
		for (it : members.filter(typeof(XtendField))) {
			if (!isValidAnnotationValueType(type)) {
				error('''Invalid type «type.simpleName» for the annotation attribute «name»; only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof''', it, XTEND_FIELD__TYPE, IssueCodes::INVALID_ANNOTATION_VALUE_TYPE)
			}
			if(initialValue != null) {
				for(EObject subExpression: EcoreUtil2::eAllContents(initialValue)) {
					if(!XbaseWithAnnotationsJavaValidator::expressionTypesAllowedAsValues.contains(subExpression.eClass)) 
						error("The value for an annotation attribute must be a constant expression", it, XTEND_FIELD__INITIAL_VALUE, org::eclipse::xtext::xbase::validation::IssueCodes::ANNOTATIONS_ILLEGAL_ATTRIBUTE);
				}
			}
		}
	}
	
	def boolean isValidAnnotationValueType(JvmTypeReference reference) {
		val toCheck = switch reference {
			JvmGenericArrayTypeReference : 
				reference.componentType
			default : reference
		}
		if (toCheck == null)
			return true;
		if (toCheck.type instanceof JvmPrimitiveType) 
			return true
		if (toCheck.type instanceof JvmEnumerationType)
			return true
		if (toCheck.type instanceof JvmAnnotationType)
			return true
		if (toCheck.type.qualifiedName == 'java.lang.String' 
			|| toCheck.type.qualifiedName == 'java.lang.Class') 
			return true
		return false
	}

}