/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.common.base.Splitter
import java.util.Collections
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2

@Accessors
@EqualsHashCode
class TypeReference {
	
	static def TypeReference typeRef(String name, TypeReference... arguments) {
		new TypeReference(name, arguments)
	}
	
	/**
	 * @deprecated this method is available for backwards compatibility reasons
	 */
	@Deprecated
	static def TypeReference guessTypeRef(String name, TypeReference... arguments) {
		new TypeReference(name, arguments, false)
	}
	
	static def TypeReference typeRef(Class<?> clazz, TypeReference... arguments) {
		new TypeReference(clazz, arguments)
	}
	
	static def TypeReference typeRef(EClass clazz, IXtextGeneratorLanguage language) {
		new TypeReference(clazz, language.resourceSet)
	}
	
	static val PACKAGE_MATCHER = Pattern.compile('([a-zA-Z_$][a-zA-Z0-9_$]*(\\.[a-zA-Z_$][a-zA-Z0-9_$]*)*)?')
	static val CLASS_MATCHER = Pattern.compile('[a-zA-Z][a-zA-Z0-9_]*(\\.[a-zA-Z][a-zA-Z0-9_]*)*')
	
	val String packageName
	
	val List<String> simpleNames
	
	val List<TypeReference> typeArguments
	
	new(String qualifiedName) {
		this(qualifiedName, null as List<TypeReference>)
	}

	new(String qualifiedName, List<TypeReference> arguments) {
		this(qualifiedName, arguments, true)
	}
	
	private new(String qualifiedName, List<TypeReference> arguments, boolean strict) {
		this(getPackageName(qualifiedName, strict), getClassName(qualifiedName, strict), arguments)
	}
	
	new(String packageName, String className) {
		this(packageName, className, null)
	}
	
	new(String packageName, String className, List<TypeReference> arguments) {
		if (packageName === null || !PACKAGE_MATCHER.matcher(packageName).matches)
			throw new IllegalArgumentException('Invalid package name: ' + packageName)
		if (className === null || !CLASS_MATCHER.matcher(className).matches)
			throw new IllegalArgumentException('Invalid class name: ' + className)
		this.packageName = packageName
		this.simpleNames = className.split('\\.')
		this.typeArguments = arguments ?: Collections.emptyList
	}
	
	new(Class<?> clazz) {
		this(clazz, null)
	}
	
	new(Class<?> clazz, List<TypeReference> arguments) {
		if (clazz.primitive)
			throw new IllegalArgumentException('Type is primitive: ' + clazz.name)
		if (clazz.anonymousClass)
			throw new IllegalArgumentException('Class is anonymous: ' + clazz.name)
		if (clazz.localClass)
			throw new IllegalArgumentException('Class is local: ' + clazz.name)
		this.packageName = clazz.package.name
		this.simpleNames = newArrayList
		this.typeArguments = arguments ?: Collections.emptyList
		var c = clazz
		do {
			simpleNames.add(0, c.simpleName)
			c = c.declaringClass
		} while (c !== null)
	}
	
	new(EClass clazz, ResourceSet resourceSet) {
		this(getQualifiedName(clazz, resourceSet))
	}
	
	new(EPackage epackage, ResourceSet resourceSet) {
		this(getQualifiedName(epackage, resourceSet))
	}
	
	private static def getPackageName(String qualifiedName, boolean strict) {
		val segments = Splitter.on('.').split(qualifiedName).toList
		if (segments.size == 1)
			return ""
		if (strict) {
			val packageSegments = segments.subList(0, segments.length -1)
			if (!packageSegments.filter[Character.isUpperCase(charAt(0))].isEmpty)
				throw new IllegalArgumentException("Cannot determine the package name of '" + qualifiedName + "'. Please use the TypeReference(packageName, className) constructor")
			return packageSegments.join(".")
		} else {
			var packageSegments = segments.subList(0, segments.length -1)
			while(!packageSegments.isEmpty) {
				if (Character.isUpperCase(packageSegments.last.charAt(0))) {
					packageSegments = packageSegments.subList(0, packageSegments.length -1)
				} else {
					return packageSegments.join(".") 
				}
			}
			return ""
		}
	}
	
	private static def getClassName(String qualifiedName, boolean strict) {
		val packageName = qualifiedName.getPackageName(strict)
		if (packageName.isEmpty)
			qualifiedName
		else
			qualifiedName.substring(packageName.length + 1, qualifiedName.length)
	}
	
	private static def getQualifiedName(EClass clazz, ResourceSet resourceSet) {
		if (clazz.EPackage.nsURI == 'http://www.eclipse.org/2008/Xtext')
			'org.eclipse.xtext.' + clazz.name
		else
			GenModelUtil2.getGenClass(clazz, resourceSet).qualifiedInterfaceName
	}
	
	private static def getQualifiedName(EPackage epackage, ResourceSet resourceSet) {
		GenModelUtil2.getGenPackage(epackage, resourceSet).qualifiedPackageInterfaceName
	}
	
	override toString() {
		name + typeArguments.join('<', ', ', '>', [toString])
	}
	
	def String getName() {
		packageName + '.' + simpleNames.join('.')
	}
	
	def String getSimpleName() {
		simpleNames.last
	}
	
	def String getPath() {
		return packageName.replace('.', '/') + '/' + simpleNames.head
	}
	
	def String getJavaPath() {
		path + ".java"
	}
	
	def String getXtendPath() {
		path + ".xtend"
	}
	
}