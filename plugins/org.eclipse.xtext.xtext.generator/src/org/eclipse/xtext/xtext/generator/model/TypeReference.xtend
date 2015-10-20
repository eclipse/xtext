/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.Collections
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage

@Accessors
@EqualsHashCode
class TypeReference {
	
	static def TypeReference typeRef(String name, TypeReference... arguments) {
		new TypeReference(name, arguments)
	}
	
	static def TypeReference typeRef(Class<?> clazz, TypeReference... arguments) {
		new TypeReference(clazz, arguments)
	}
	
	static def TypeReference typeRef(EClass clazz, IXtextGeneratorLanguage language) {
		new TypeReference(clazz, language.resourceSet)
	}
	
	static def TypeReference typeRef(EPackage epackage, IXtextGeneratorLanguage language) {
		new TypeReference(epackage, language.resourceSet)
	}
	
	static val PACKAGE_MATCHER = Pattern.compile('([a-z][a-zA-Z0-9_]*(\\.[a-z][a-zA-Z0-9_]*)*)?')
	static val CLASS_MATCHER = Pattern.compile('[A-Z][a-zA-Z0-9_]*(\\.[A-Z][a-zA-Z0-9_]*)*')
	
	val String packageName
	
	val List<String> simpleNames
	
	val List<TypeReference> typeArguments
	
	new(String qualifiedName) {
		this(qualifiedName, null as List<TypeReference>)
	}

	new(String qualifiedName, List<TypeReference> arguments) {
		this(getPackageName(qualifiedName), getClassName(qualifiedName), arguments)
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
	
	private static def getPackageName(String qualifiedName) {
		var packageEnd = qualifiedName.length
		for (var i = qualifiedName.length - 1; i >= 0; i--) {
			if (qualifiedName.charAt(i).matches('.')) {
				if (Character.isLowerCase(qualifiedName.charAt(i + 1)))
					return qualifiedName.substring(0, packageEnd)
				else
					packageEnd = i
			}
		}
		return ""
	}
	
	private static def getClassName(String qualifiedName) {
		var classStart = qualifiedName.length
		for (var i = qualifiedName.length - 1; i >= 0; i--) {
			if (qualifiedName.charAt(i).matches('.')) {
				if (Character.isLowerCase(qualifiedName.charAt(i + 1)))
					return qualifiedName.substring(classStart)
				else
					classStart = i + 1
			}
		}
		return qualifiedName
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
	
	private static def matches(char c1, char c2) {
		c1 == c2
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