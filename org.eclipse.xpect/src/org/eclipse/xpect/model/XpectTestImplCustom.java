package org.eclipse.xpect.model;

import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;

public class XpectTestImplCustom extends XpectTestImpl {
	@Override
	public JvmDeclaredType getSetupClass() {
		JvmDeclaredType type = getTestClass();
		if (type == null || type.eIsProxy())
			return null;
		for (JvmAnnotationReference ref : type.getAnnotations()) {
			JvmAnnotationType annotation = ref.getAnnotation();
			if (annotation != null && !annotation.eIsProxy() && annotation.getQualifiedName().equals(XpectSetup.class.getName())) {
				for (JvmAnnotationValue value : ref.getValues())
					if (value instanceof JvmTypeAnnotationValue) {
						JvmTypeAnnotationValue typeValue = (JvmTypeAnnotationValue) value;
						if (!typeValue.getValues().isEmpty()) {
							JvmType resultType = typeValue.getValues().get(0).getType();
							if (resultType instanceof JvmDeclaredType)
								return (JvmDeclaredType) resultType;
						}
					}
			}
		}
		return null;
	}

	@Override
	public JvmDeclaredType getComponentClass() {
		JvmDeclaredType setupClass = getSetupClass();
		if (setupClass == null || setupClass.eIsProxy())
			return null;
		if (setupClass.getSuperTypes().size() == 0 && setupClass.getSuperTypes().get(0) instanceof JvmParameterizedTypeReference)
			return null;
		JvmParameterizedTypeReference superClass = (JvmParameterizedTypeReference) setupClass.getSuperTypes().get(0);
		if (superClass.getArguments().size() != 4)
			return null;
		JvmTypeReference typeReference = superClass.getArguments().get(3);
		if (typeReference != null && typeReference.getType() != null && !typeReference.getType().eIsProxy())
			return (JvmDeclaredType) typeReference.getType();
		return null;

		// for (JvmFeature feature :
		// setupClass.findAllFeaturesByName("beforeFile"))
		// if (feature instanceof JvmOperation && ((JvmOperation)
		// feature).getParameters().size() == 3) {
		// JvmTypeReference parameterType = ((JvmOperation)
		// feature).getParameters().get(2).getParameterType();
		// if (parameterType instanceof JvmParameterizedTypeReference) {
		// JvmTypeReference target = ((JvmParameterizedTypeReference)
		// parameterType).getArguments().get(0);
		// if (target != null && target.getType() != null &&
		// !target.getType().eIsProxy())
		// return (JvmDeclaredType) target.getType();
		// }
		// }
		// return null;
	}
}
