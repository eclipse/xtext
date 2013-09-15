package org.xpect.util;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("restriction")
public interface IJavaReflectAccess {
	public class Delegate implements IJavaReflectAccess {

		private IJavaReflectAccess delegate;

		public Class<?> getRawType(JvmType type) {
			return delegate.getRawType(type);
		}

		public void setDelegate(IJavaReflectAccess delegate) {
			this.delegate = delegate;
		}

	}

	public class RuntimeJavaReflectAccess implements IJavaReflectAccess {

		public Class<?> getRawType(JvmType type) {
			XtextResourceSet resourceSet = (XtextResourceSet) type.eResource().getResourceSet();
			JavaReflectAccess access = new JavaReflectAccess();
			access.setClassLoader((ClassLoader) resourceSet.getClasspathURIContext());
			return access.getRawType(type);
		}

	}

	public static final IJavaReflectAccess INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new Delegate() : new RuntimeJavaReflectAccess();

	Class<?> getRawType(JvmType type);

}
