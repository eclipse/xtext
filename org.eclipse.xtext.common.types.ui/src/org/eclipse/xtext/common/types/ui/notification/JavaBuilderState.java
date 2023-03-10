/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.ui.notification;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.internal.compiler.util.SimpleLookupTable;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.builder.State;
import org.eclipse.jdt.internal.core.builder.StringSet;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @since 2.5
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JavaBuilderState {

	private static final Logger LOG = Logger.getLogger(JavaBuilderState.class);

	private final State state;

	private final IProject project;

	private Integer buildNumber;

	private Object references;

	private Long lastStructuralBuildTime;

	private Set<QualifiedName> structurallyChangedTypes;

	private JavaBuilderState(IProject project, State state) {
		this.project = project;
		this.state = state;
	}

	public IProject getProject() {
		return project;
	}

	public static JavaBuilderState getLastBuiltState(IJavaElement javaElement) {
		IJavaProject javaProject = javaElement.getJavaProject();
		return javaProject == null ? null : JavaBuilderState.getLastBuiltState(javaProject.getProject());
	}

	public static JavaBuilderState getLastBuiltState(IProject project) {
		final State state;
		Object lastBuiltState = JavaModelManager.getJavaModelManager().getLastBuiltState(project, null);
		if (lastBuiltState instanceof State) {
			state = (State) lastBuiltState;
		} else {
			state = null;
		}
		return new JavaBuilderState(project, state);
	}

	public Long getLastStructuralBuildTime() {
		if (lastStructuralBuildTime != null) {
			return lastStructuralBuildTime;
		}
		if (state == null) {
			return lastStructuralBuildTime = -1L;
		}
		return lastStructuralBuildTime = (Long) readField(state, "lastStructuralBuildTime", -1L);
	}

	public Integer getBuildNumber() {
		if (buildNumber != null) {
			return buildNumber;
		}
		if (state == null) {
			return buildNumber = -1;
		}
		return buildNumber = (Integer) readField(state, "buildNumber", -1);
	}

	public Set<QualifiedName> getStructurallyChangedTypes() {
		if (structurallyChangedTypes != null) {
			return structurallyChangedTypes;
		}

		structurallyChangedTypes = new HashSet<>();

		if (state != null) {
			Object types = readField(state, "structurallyChangedTypes", null);
			if (types instanceof StringSet) {
				for (String name : ((StringSet) types).values) {
					if (name != null) {
						structurallyChangedTypes.add(QualifiedName.create(name.split("/")));
					}
				}
			}
		}
		return structurallyChangedTypes;
	}

	public TypeNames getQualifiedTypeNames(Object obj) {
		if (obj instanceof ICompilationUnit) {
			return _getQualifiedTypeNames((ICompilationUnit) obj);
		} else if (obj instanceof IPackageFragment) {
			return _getQualifiedTypeNames((IPackageFragment) obj);
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(obj).toString());
		}
	}

	/**
	 * @return The {@code TypeNames} which are direct children of the given package.
	 */
	protected TypeNames _getQualifiedTypeNames(IPackageFragment packageFragment) {
		TypeNames qualifiedTypeNames = new TypeNames(packageFragment.getJavaProject());

		Object references = getReferences();
		if (references == null) {
			return qualifiedTypeNames;
		}

		IResource resource = packageFragment.getResource();
		if (resource == null) {
			return qualifiedTypeNames;
		}

		String packageName = packageFragment.getElementName();
		IPath packagePath = resource.getProjectRelativePath();
		int srcPathSegmentCount = getPackageFragmentRoot(packageFragment).getResource().getProjectRelativePath().segmentCount();
		Iterable<?> keys;
		if (references instanceof Map) {
			keys = ((Map<?,?>) references).keySet();
		} else {
			keys = Arrays.asList(((SimpleLookupTable)references).keyTable);
		}
		for (Object typeLocator : keys) {
			if (typeLocator instanceof String) {
				IPath typeLocatorPath = packageFragment.getJavaProject().getProject().getFile((String) typeLocator)
						.getProjectRelativePath();
				if (packagePath.isPrefixOf(typeLocatorPath)) {
					IPath qualifiedPath = typeLocatorPath.removeFirstSegments(srcPathSegmentCount).removeFileExtension();
					String typePackageName = qualifiedPath.removeLastSegments(1).toString().replace("/", ".");
					if (packageName.equals(typePackageName)) {
						String simpleTypeName = qualifiedPath.lastSegment().toString();
						qualifiedTypeNames.addAll(
								getQualifiedTypeNames((String) typeLocator, packageName, simpleTypeName, packageFragment.getJavaProject()));
					}
				}
			}
		}
		return qualifiedTypeNames;
	}

	/**
	 * @return The {@code TypeNames} which are direct children of a given CompilationUnit.
	 */
	protected TypeNames _getQualifiedTypeNames(ICompilationUnit compilationUnit) {
		return getQualifiedTypeNames(getTypeLocator(compilationUnit), getPackageName(compilationUnit),
				getSimplePrimaryTypeName(compilationUnit), compilationUnit.getJavaProject());
	}

	private IPackageFragmentRoot getPackageFragmentRoot(IJavaElement javaElement) {
		IJavaElement parent = javaElement.getParent();
		return parent instanceof IPackageFragmentRoot ? ((IPackageFragmentRoot) parent) : getPackageFragmentRoot(parent);
	}

	private TypeNames getQualifiedTypeNames(String typeLocator, String packageName, String simpleName, IJavaProject project) {
		TypeNames qualifiedTypeNames = new TypeNames(project);
		String primaryTypeFqn = getQualifedTypeName(packageName, simpleName);

		char[][] typeNames = null;
		if (state != null) {
			typeNames = state.getDefinedTypeNamesFor(typeLocator);
		}

		if (typeNames == null) {
			TypeNames newTypeNames = new TypeNames(project);
			newTypeNames.addTypeName(primaryTypeFqn, primaryTypeFqn);
			return newTypeNames;
		}

		for (char[] typeName : typeNames) {
			String qualifiedTypeName = getQualifedTypeName(packageName, new String(typeName));
			qualifiedTypeNames.addTypeName(qualifiedTypeName, primaryTypeFqn);
		}

		return qualifiedTypeNames;
	}

	private String getQualifedTypeName(String packageName, String simpleTypeName) {
		return packageName == null ? simpleTypeName : packageName + "." + simpleTypeName;
	}

	private String getTypeLocator(ICompilationUnit compilationUnit) {
		IResource resource = compilationUnit.getResource();
		if (resource != null && resource.getProjectRelativePath() != null) {
			return resource.getProjectRelativePath().toString();
		}
		return null;
	}

	private String getPackageName(ICompilationUnit compilationUnit) {
		IJavaElement parent = compilationUnit.getParent();
		if (parent instanceof IPackageFragment && !((IPackageFragment) parent).isDefaultPackage()) {
			return ((IPackageFragment) parent).getElementName();
		}
		return null;
	}

	private String getSimplePrimaryTypeName(ICompilationUnit compilationUnit) {
		String elementName = compilationUnit.getElementName();
		return elementName.substring(0, elementName.lastIndexOf("."));
	}

	private Object getReferences() {
		if (references != null) {
			return references;
		}

		if (state == null) {
			return null;
		}

		Object readReferences = readField(state, "references", null);
		if (readReferences instanceof Map) {
			// used in 4.16 and later
			references = readReferences;
		} else if (readReferences instanceof SimpleLookupTable) {
			// used in 4.15 and earlier
			references = readReferences;
		}
		return references;
	}

	private Object readField(Object instance, String fieldName, Object defaultValue) {
		try {
			Field field = instance.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			Object value = field.get(instance);
			if (value != null) {
				return value;
			}
			return defaultValue;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return defaultValue;
		}
	}

}
