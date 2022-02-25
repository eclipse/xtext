/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration
import org.eclipse.xtend.lib.macro.services.TypeLookup
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.xtype.XtypePackage
import org.eclipse.xtend.lib.macro.services.SourceTypeLookup
import org.eclipse.xtend.lib.macro.services.UpstreamTypeLookup

class TypeLookupImpl implements TypeLookup, SourceTypeLookup, UpstreamTypeLookup {
	
	extension CompilationUnitImpl compilationUnit
	
	new (CompilationUnitImpl compilationUnit) {
		this.compilationUnit = compilationUnit
	}
	
	override findAnnotationType(String qualifiedName) {
		val type = findType(qualifiedName)
		return switch type {
			MutableAnnotationTypeDeclaration : type
		}
	}
	
	override findClass(String qualifiedName) {
		val type = findType(qualifiedName)
		return switch type {
			MutableClassDeclaration : type
		}
	}
	
	override findEnumerationType(String qualifiedName) {
		val type = findType(qualifiedName)
		return switch type {
			MutableEnumerationTypeDeclaration : type
		}
	}
	
	override findInterface(String qualifiedName) {
		val type = findType(qualifiedName)
		return switch type {
			MutableInterfaceDeclaration : type
		}
	}
	
	private def findType(String qualifiedName) {
		val result = recursiveFindType(
			qualifiedName, 
			compilationUnit.xtendFile.eResource.contents.filter(JvmDeclaredType),
			[type|type.getQualifiedName('.')],
			[type|type.members.filter(JvmDeclaredType)]
		)
		return if (result !== null) {
			compilationUnit.toType(result)
		}
	}
	
	override findSourceClass(String qualifiedName) {
		val type = findSourceType(qualifiedName)
		return switch type {
			ClassDeclaration : type
		}
	}
	
	override findSourceInterface(String qualifiedName) {
		val type = findSourceType(qualifiedName)
		return switch type {
			InterfaceDeclaration : type
		}
	}
	
	override findSourceEnumerationType(String qualifiedName) {
		val type = findSourceType(qualifiedName)
		return switch type {
			EnumerationTypeDeclaration : type
		}
	}
	
	override findSourceAnnotationType(String qualifiedName) {
		val type = findSourceType(qualifiedName)
		return switch type {
			AnnotationTypeDeclaration : type
		}
	}
	
	private def findSourceType(String qualifiedName) {
		val result = recursiveFindType(
			qualifiedName, 
			(compilationUnit.xtendFile.eResource.contents.head as XtendFile).xtendTypes,
			[type|compilationUnit.qualifiedNameConverter.toString(compilationUnit.qualifiedNameProvider.getFullyQualifiedName(type))],
			[type|type.members.filter(XtendTypeDeclaration)]
		)
		return if (result !== null) {
			compilationUnit.toXtendTypeDeclaration(result)
		}
	}
	
	private def <T> T recursiveFindType(String qualifiedName, Iterable<? extends T> typeDeclarations, (T)=>String qualifiedNameProvider, (T)=>Iterable<? extends T> subTypeProvider) {
		val char dot = '.'
		for (type : typeDeclarations) {
			val name = qualifiedNameProvider.apply(type)
			if (qualifiedName == name) {
				return type
			}
			if (qualifiedName.startsWith(name) && qualifiedName.charAt(name.length) == dot) {
				return recursiveFindType(qualifiedName, subTypeProvider.apply(type), qualifiedNameProvider, subTypeProvider)
			}
		}
		return null
	}
	
	override findTypeGlobally(Class<? extends Object> clazz) {
		findTypeGlobally(clazz.canonicalName)
	}
	
	override findTypeGlobally(String typeName) {
		findType(typeName) ?: findTypeOnScope(typeName)[true]
	}
	
	override findUpstreamType(Class<?> clazz) {
		findUpstreamType(clazz.canonicalName)
	}
	
	override findUpstreamType(String typeName) {
		findTypeOnScope(typeName)[EObjectOrProxy.eResource != compilationUnit.xtendFile.eResource]
	}
	
	private def findTypeOnScope(String typeName, (IEObjectDescription)=>boolean filter) {
		val qualifiedName = compilationUnit.qualifiedNameConverter.toQualifiedName(typeName)
		val result = compilationUnit.scopeProvider
			.getScope(compilationUnit.xtendFile, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE)
			.getSingleElement(qualifiedName)
		if (result !== null && TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(result.EClass) && filter.apply(result)) {
			return compilationUnit.toType(result.EObjectOrProxy as JvmType)
		}
		return null
	}
}