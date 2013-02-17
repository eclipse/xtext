package org.xpect.model;

import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.resource.XtextResourceSet;

public class XjmClassImplCustom extends XjmClassImpl {

	private static Logger logger = Logger.getLogger(XjmClassImplCustom.class);

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
		ClassLoader context = (ClassLoader) ((XtextResourceSet) eResource().getResourceSet()).getClasspathURIContext();
		try {
			result = context.loadClass(jvmClass.getQualifiedName());
			super.setJavaClass(result);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		return result;
	}

}
