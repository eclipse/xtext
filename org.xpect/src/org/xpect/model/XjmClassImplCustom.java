package org.xpect.model;

import static org.xpect.util.JvmAnnotationUtil.newInstancesViaAnnotation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.xpect.parameter.IParameterAdapter;
import org.xpect.parameter.XpectParameterAdapter;
import org.xpect.util.IJavaReflectAccess;

public class XjmClassImplCustom extends XjmClassImpl {

	@Override
	public void setJvmClass(JvmDeclaredType newJvmClass) {
		super.setJavaClass(null);
		super.setJvmClass(newJvmClass);
		this.parameterAdapters = null;
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

	@Override
	public EList<IParameterAdapter> getParameterAdapters() {
		if (this.parameterAdapters == null)
			super.getParameterAdapters().addAll(
					newInstancesViaAnnotation(getJvmClass(), IParameterAdapter.class, XpectParameterAdapter.class));
		return super.getParameterAdapters();
	}

}
