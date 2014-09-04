package org.eclipse.jdt.junit.runners;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.junit.runner.RunWith;

public class RunnerUtil {

	public static String findRunner(IType type) {
		try {
			for (IAnnotation candidate : type.getAnnotations()) {
				String elementName = candidate.getElementName();
				if (!elementName.endsWith(RunWith.class.getSimpleName()))
					continue;
				if (!RunWith.class.getName().equals(resolveToQName(type, elementName)))
					continue;
				for (IMemberValuePair pair : candidate.getMemberValuePairs())
					if ("value".equals(pair.getMemberName()) && pair.getValue() instanceof String)
						return resolveToQName(type, (String) pair.getValue());
			}
			IType superClass = resolveToType(type, type.getSuperclassName());
			if (superClass != null)
				return findRunner(superClass);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String resolveToQName(IType baseType, String refTypeName) throws JavaModelException {
		String[][] resolvedNames = baseType.resolveType(refTypeName);
		if (resolvedNames != null && resolvedNames.length > 0) {
			return resolvedNames[0][0] + "." + resolvedNames[0][1].replace('$', '.');
		} else {
			return null;
		}
	}

	private static IType resolveToType(IType baseType, String refTypeName) throws JavaModelException {
		if (baseType == null || refTypeName == null)
			return null;
		String[][] resolvedNames = baseType.resolveType(refTypeName);
		IJavaProject javaProject = baseType.getJavaProject();
		if (resolvedNames != null && resolvedNames.length > 0) {
			return javaProject.findType(resolvedNames[0][0], resolvedNames[0][1].replace('$', '.'), (IProgressMonitor) null);
		} else if (baseType.isBinary()) {
			IType type = javaProject.findType(refTypeName, (IProgressMonitor) null);
			if (type == null) {
				type = javaProject.findType(baseType.getPackageFragment().getElementName() + '.' + refTypeName, (IProgressMonitor) null);
			}
			return type;
		} else {
			return null;
		}
	}
}
