package org.xpect.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("restriction")
public interface IJavaReflectAccess {
	public class Delegate implements IJavaReflectAccess {

		private IJavaReflectAccess delegate;

		public Field getField(JvmField field) {
			return delegate.getField(field);
		}

		public Method getMethod(JvmOperation operation) {
			return delegate.getMethod(operation);
		}

		public Class<?> getRawType(JvmType type) {
			return delegate.getRawType(type);
		}

		public void setDelegate(IJavaReflectAccess delegate) {
			this.delegate = delegate;
		}

	}

	public class RuntimeJavaReflectAccess implements IJavaReflectAccess {

		public Field getField(JvmField field) {
			XtextResourceSet resourceSet = (XtextResourceSet) field.eResource().getResourceSet();
			JavaReflectAccess access = new JavaReflectAccess();
			access.setClassLoader((ClassLoader) resourceSet.getClasspathURIContext());
			return access.getField(field);
		}

		public Method getMethod(JvmOperation operation) {
			XtextResourceSet resourceSet = (XtextResourceSet) operation.eResource().getResourceSet();
			JavaReflectAccess access = new JavaReflectAccess();
			access.setClassLoader((ClassLoader) resourceSet.getClasspathURIContext());
			return access.getMethod(operation);
		}

		public Class<?> getRawType(JvmType type) {
			XtextResourceSet resourceSet = (XtextResourceSet) type.eResource().getResourceSet();
			JavaReflectAccess access = new JavaReflectAccess();
			access.setClassLoader((ClassLoader) resourceSet.getClasspathURIContext());
			return access.getRawType(type);
		}

	}

	public static final IJavaReflectAccess INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new Delegate() : new RuntimeJavaReflectAccess();

	Field getField(JvmField field);

	Method getMethod(JvmOperation operation);

	Class<?> getRawType(JvmType type);

}
