/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * Reference to a Java type. Use this for automatic import of types in
 * {@link JavaFileAccess} and {@link XtendFileAccess}.
 */
public class TypeReference {
	public static class QualifiedClassName {
		private final String packageName;

		private final String className;

		public String getPackageName() {
			return packageName;
		}

		public String getClassName() {
			return className;
		}

		public QualifiedClassName(String packageName, String className) {
			this.packageName = packageName;
			this.className = className;
		}
	}

	public static TypeReference typeRef(String name, TypeReference... arguments) {
		return new TypeReference(name, arguments == null ? null : Arrays.asList(arguments));
	}

	/**
	 * @deprecated this method is available for backwards compatibility reasons
	 */
	@Deprecated
	public static TypeReference guessTypeRef(String name, TypeReference... arguments) {
		return new TypeReference(name, arguments == null ? null : Arrays.asList(arguments), false);
	}

	public static TypeReference typeRef(Class<?> clazz, TypeReference... arguments) {
		return new TypeReference(clazz, arguments == null ? null : Arrays.asList(arguments));
	}

	public static TypeReference typeRef(EClass clazz, IXtextGeneratorLanguage language) {
		ResourceSet _resourceSet = language.getResourceSet();
		return new TypeReference(clazz, _resourceSet);
	}

	private final String packageName;

	private final List<String> simpleNames;

	private final List<TypeReference> typeArguments;

	public TypeReference(String qualifiedName) {
		this(qualifiedName, ((List<TypeReference>) null));
	}

	public TypeReference(String qualifiedName, List<TypeReference> arguments) {
		this(qualifiedName, arguments, true);
	}

	private TypeReference(String qualifiedName, List<TypeReference> arguments, boolean strict) {
		this(TypeReference.getPackageName(qualifiedName, strict), TypeReference.getClassName(qualifiedName, strict),
				arguments);
	}

	public TypeReference(String packageName, String className) {
		this(packageName, className, null);
	}

	public TypeReference(String packageName, String className, List<TypeReference> arguments) {
		if (packageName == null) {
			throw new IllegalArgumentException("Invalid package name: " + packageName);
		}
		if (className == null) {
			throw new IllegalArgumentException("Invalid class name: " + className);
		}
		this.packageName = packageName;
		this.simpleNames = Arrays.asList(className.split("\\."));
		if (arguments == null) {
			arguments = Collections.emptyList();
		}
		this.typeArguments = arguments;
	}

	public TypeReference(Class<?> clazz) {
		this(clazz, null);
	}

	public TypeReference(Class<?> clazz, List<TypeReference> arguments) {
		if (clazz.isPrimitive()) {
			throw new IllegalArgumentException("Type is primitive: " + clazz.getName());
		}
		if (clazz.isAnonymousClass()) {
			throw new IllegalArgumentException("Class is anonymous: " + clazz.getName());
		}
		if (clazz.isLocalClass()) {
			throw new IllegalArgumentException("Class is local: " + clazz.getName());
		}
		this.packageName = clazz.getPackage().getName();
		this.simpleNames = new ArrayList<>();
		if (arguments == null) {
			arguments = Collections.emptyList();
		}
		this.typeArguments = arguments;
		Class<?> c = clazz;
		do {
			this.simpleNames.add(0, c.getSimpleName());
			c = c.getDeclaringClass();
		} while (c != null);
	}

	public TypeReference(EClass clazz, ResourceSet resourceSet) {
		this(TypeReference.getQualifiedName(clazz, resourceSet));
	}

	public TypeReference(QualifiedClassName qualifiedClazzName) {
		this(qualifiedClazzName.packageName, qualifiedClazzName.className, null);
	}

	public TypeReference(EPackage epackage, ResourceSet resourceSet) {
		this(TypeReference.getQualifiedName(epackage, resourceSet));
	}

	private static String getPackageName(String qualifiedName, boolean strict) {
		List<String> segments = IterableExtensions.toList(Splitter.on(".").split(qualifiedName));
		if (segments.size() == 1) {
			return "";
		}
		if (strict) {
			List<String> packageSegments = segments.subList(0, segments.size() - 1);
			if (!Iterables.isEmpty(Iterables.filter(packageSegments, it -> Character.isUpperCase(it.charAt(0))))) {
				throw new IllegalArgumentException("Cannot determine the package name of '" + qualifiedName
						+ "'. Please use the TypeReference(packageName, className) constructor");
			}
			return Joiner.on(".").join(packageSegments);
		} else {
			List<String> packageSegments = segments.subList(0, segments.size() - 1);
			while (!packageSegments.isEmpty()) {
				if (Character.isUpperCase(IterableExtensions.last(packageSegments).charAt(0))) {
					packageSegments = packageSegments.subList(0, packageSegments.size() - 1);
				} else {
					return Joiner.on(".").join(packageSegments);
				}
			}
			return "";
		}
	}

	private static String getClassName(String qualifiedName, boolean strict) {
		String packageName = TypeReference.getPackageName(qualifiedName, strict);
		if (packageName.isEmpty()) {
			return qualifiedName;
		} else {
			return qualifiedName.substring(packageName.length() + 1, qualifiedName.length());
		}
	}

	private static QualifiedClassName getQualifiedName(EClass clazz, ResourceSet resourceSet) {
		if ("http://www.eclipse.org/2008/Xtext".equals(clazz.getEPackage().getNsURI())) {
			return new QualifiedClassName("org.eclipse.xtext", clazz.getName());
		} else {
			if ("http://www.eclipse.org/emf/2002/Ecore".equals(clazz.getEPackage().getNsURI())) {
				if (clazz.getInstanceTypeName() != null) {
					String itn = clazz.getInstanceTypeName();
					return new QualifiedClassName(itn.substring(0, itn.lastIndexOf(".")),
							itn.substring(itn.lastIndexOf(".") + 1).replace("$", "."));
				} else {
					return new QualifiedClassName("org.eclipse.emf.ecore", clazz.getName());
				}
			} else {
				if (clazz.getInstanceTypeName() != null) {
					String itn = clazz.getInstanceTypeName();
					return new QualifiedClassName(itn.substring(0, itn.lastIndexOf(".")),
							itn.substring(itn.lastIndexOf(".") + 1).replace("$", "."));
				} else {
					GenClass genClass = GenModelUtil2.getGenClass(clazz, resourceSet);
					String packageName = genClass.getGenPackage().getInterfacePackageName();
					return new QualifiedClassName(packageName, genClass.getInterfaceName());
				}
			}
		}
	}

	private static QualifiedClassName getQualifiedName(EPackage epackage, ResourceSet resourceSet) {
		GenPackage genPackage = GenModelUtil2.getGenPackage(epackage, resourceSet);
		String packageName = null;
		if (genPackage.getGenModel().isSuppressEMFMetaData()) {
			packageName = genPackage.getQualifiedPackageClassName();
		} else {
			packageName = genPackage.getReflectionPackageName();
		}
		return new QualifiedClassName(packageName, genPackage.getPackageInterfaceName());
	}

	@Override
	public String toString() {
		return getName() + IterableExtensions.join(typeArguments, "<", ", ", ">", TypeReference::toString);
	}

	public String getName() {
		return packageName + "." + Joiner.on(".").join(simpleNames);
	}

	public String getSimpleName() {
		return IterableExtensions.last(simpleNames);
	}

	public String getPath() {
		return packageName.replace(".", "/") + "/" + Iterables.getFirst(simpleNames, null);
	}

	public String getJavaPath() {
		return getPath() + ".java";
	}

	public String getXtendPath() {
		return getPath() + ".xtend";
	}

	public String getPackageName() {
		return packageName;
	}

	public List<String> getSimpleNames() {
		return simpleNames;
	}

	public List<TypeReference> getTypeArguments() {
		return typeArguments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result + ((simpleNames == null) ? 0 : simpleNames.hashCode());
		result = prime * result + ((typeArguments == null) ? 0 : typeArguments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeReference other = (TypeReference) obj;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (simpleNames == null) {
			if (other.simpleNames != null)
				return false;
		} else if (!simpleNames.equals(other.simpleNames))
			return false;
		if (typeArguments == null) {
			if (other.typeArguments != null)
				return false;
		} else if (!typeArguments.equals(other.typeArguments))
			return false;
		return true;
	}

}
