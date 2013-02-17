package org.xpect.util;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("restriction")
public class RuntimeJavaReflectAccess implements IJavaReflectAccess {

	public Class<?> getRawType(JvmType type) {
		XtextResourceSet resourceSet = (XtextResourceSet) type.eResource().getResourceSet();
		JavaReflectAccess access = new JavaReflectAccess();
		access.setClassLoader((ClassLoader) resourceSet.getClasspathURIContext());
		return access.getRawType(type);
	}

}
