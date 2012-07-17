package org.eclipse.xpect.model;

import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;

public class XpectTestImplCustom extends XpectTestImpl {
	@Override
	public JvmDeclaredType getSetup() {
		JvmDeclaredType type = getType();
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
}
