package org.xpect.util;

import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.ImplementedBy;

@ImplementedBy(RuntimeJavaReflectAccess.class)
public interface IJavaReflectAccess {
	Class<?> getRawType(JvmType type);
}
