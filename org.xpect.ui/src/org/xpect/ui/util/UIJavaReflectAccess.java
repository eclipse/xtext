package org.xpect.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.ClassMirror;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeMirror;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.xpect.util.IJavaReflectAccess;

@SuppressWarnings("restriction")
public class UIJavaReflectAccess implements IJavaReflectAccess {
	private static final String BUNDLE_SYMBOLIC_NAME = "Bundle-SymbolicName";

	private IPackageFragmentRoot getPackageFragmentRoot(IJavaElement ele) {
		IJavaElement current = ele;
		while (current != null) {
			if (current instanceof IPackageFragmentRoot)
				return (IPackageFragmentRoot) current;
			current = current.getParent();
		}
		return null;
	}

	private String getBundleNameFromDir(File file) {
		File current = file;
		int counter = 5;
		while (current != null && counter > 0) {
			File cand = new File(current + "/META-INF/MANIFEST.MF");
			if (cand.isFile()) {
				InputStream in = null;
				try {
					in = new FileInputStream(cand);
					return getBundleNameFromJar(new Manifest(in));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return null;
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				} finally {
					try {
						in.close();
					} catch (IOException e) {
						return null;
					}
				}
			}
			current = current.getParentFile();
		}
		return null;
	}

	private String getBundleNameFromJar(Manifest manifest) {
		String name = manifest.getMainAttributes().getValue(BUNDLE_SYMBOLIC_NAME);
		if (name != null) {
			int i = name.indexOf(';');
			if (i >= 0)
				name = name.substring(0, i);
		}
		return name;
	}

	private String getBundleNameFromJar(File file) {
		try {
			return getBundleNameFromJar(new JarFile(file).getManifest());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Bundle getBundle(ClassMirror mirror) {
		Class<?> mirroredClass = mirror.getMirroredClass();
		return FrameworkUtil.getBundle(mirroredClass);
	}

	private Bundle getBundle(JdtTypeMirror mirror) {
		IType mirroredType = mirror.getMirroredType();
		IPackageFragmentRoot fragmentRoot = getPackageFragmentRoot(mirroredType);
		if (fragmentRoot == null || fragmentRoot.getPath() == null)
			return null;
		File file = fragmentRoot.getPath().toFile();
		String bundleName;
		if (file.isFile())
			bundleName = getBundleNameFromJar(file);
		else if (file.isDirectory())
			bundleName = getBundleNameFromDir(file);
		else
			return null;
		if (bundleName == null)
			return null;
		return Platform.getBundle(bundleName);
	}

	public Class<?> getRawType(JvmType jvmType) {
		if (jvmType == null || jvmType.eIsProxy())
			return null;
		XtextResourceSet resourceSet = (XtextResourceSet) jvmType.eResource().getResourceSet();
		if (resourceSet.getClasspathURIContext() instanceof ClassLoader) {
			JavaReflectAccess access = new JavaReflectAccess();
			access.setClassLoader((ClassLoader) resourceSet.getClasspathURIContext());
			return access.getRawType(jvmType);
		}
		if (!(jvmType.eResource() instanceof TypeResource))
			return null;
		IMirror typeMirror = ((TypeResource) jvmType.eResource()).getMirror();
		Bundle bundle = null;
		if (typeMirror instanceof JdtTypeMirror)
			bundle = getBundle((JdtTypeMirror) typeMirror);
		if (typeMirror instanceof ClassMirror)
			bundle = getBundle((ClassMirror) typeMirror);
		if (bundle == null)
			return null;
		String className = jvmType.getQualifiedName();
		try {
			return bundle.loadClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Method getMethod(JvmOperation operation) {
		Class<?> rawType = getRawType(operation.getDeclaringType());
		if (rawType != null) {
			String name = operation.getSimpleName();
			for (Method method : rawType.getMethods()) {
				if (name.equals(method.getName()))
					return method;
			}
		}
		return null;
	}

}
