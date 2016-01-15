package org.eclipse.xpect.model;

import org.eclipse.xpect.util.IJavaReflectAccess;
import org.eclipse.xtext.common.types.JvmDeclaredType;

public class XjmClassImplCustom extends XjmClassImpl {

	@Override
	public void setJvmClass(JvmDeclaredType newJvmClass) {
		super.setJavaClass(null);
		super.setJvmClass(newJvmClass);
	}

	@Override
	public Class<?> getJavaClass() {
		Class<?> result = super.getJavaClass();
		if (result != null)
			return result;
		JvmDeclaredType jvmClass = getJvmClass();
		if (jvmClass == null || jvmClass.eIsProxy())
			return null;
		Class<?> type = IJavaReflectAccess.INSTANCE.getRawType(jvmClass);
		super.setJavaClass(type);
		return type;
	}

}
