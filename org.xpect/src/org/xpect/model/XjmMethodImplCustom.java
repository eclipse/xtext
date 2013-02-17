package org.xpect.model;

import java.lang.reflect.Method;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("restriction")
public class XjmMethodImplCustom extends XjmMethodImpl {
	@Override
	public String getName() {
		return getJvmMethod().getSimpleName();
	}

	@Override
	public void setJvmMethod(JvmOperation newJvmMethod) {
		setJavaMethod(null);
		super.setJvmMethod(newJvmMethod);
	}

	@Override
	public Method getJavaMethod() {
		Method result = super.getJavaMethod();
		if (result != null)
			return result;
		JvmOperation jvmOperation = super.getJvmMethod();
		if (jvmOperation == null || jvmOperation.eIsProxy())
			return null;
		ClassLoader context = (ClassLoader) ((XtextResourceSet) eResource().getResourceSet()).getClasspathURIContext();
		JavaReflectAccess jra = new JavaReflectAccess();
		jra.setClassLoader(context);
		result = jra.getMethod(jvmOperation);
		setJavaMethod(result);
		return result;
	}

}
