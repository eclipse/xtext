/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.lib.Pair

import static org.eclipse.xtend.core.macro.ConditionUtils.*
import com.google.common.base.Preconditions
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.macro.file.FileLocations
import org.eclipse.xtend.lib.macro.file.FileSystemSupport
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl

class RegisterGlobalsContextImpl implements RegisterGlobalsContext {
	
	@Accessors IJvmDeclaredTypeAcceptor acceptor
	@Accessors CompilationUnitImpl compilationUnit
	
	override registerAnnotationType(String qualifiedName) throws IllegalArgumentException {
		val newType = TypesFactory.eINSTANCE.createJvmAnnotationType
		newType.setVisibility(JvmVisibility.PUBLIC)
		setNameAndAccept(newType, qualifiedName)
	}
	
	override registerClass(String qualifiedName) throws IllegalArgumentException {
		val newType = TypesFactory.eINSTANCE.createJvmGenericType
		newType.setVisibility(JvmVisibility.PUBLIC)
		newType.superTypes += compilationUnit.typeReferences.getTypeForName(Object, compilationUnit.xtendFile)
		setNameAndAccept(newType, qualifiedName)
	}
	
	override registerEnumerationType(String qualifiedName) throws IllegalArgumentException {
		val newType = TypesFactory.eINSTANCE.createJvmEnumerationType
		newType.setVisibility(JvmVisibility.PUBLIC)
		setNameAndAccept(newType, qualifiedName)
	}
	
	override registerInterface(String qualifiedName) throws IllegalArgumentException {
		val newType = TypesFactory.eINSTANCE.createJvmGenericType
		newType.setVisibility(JvmVisibility.PUBLIC)
		newType.interface = true
		setNameAndAccept(newType, qualifiedName)
	}
	
	private def void setNameAndAccept(JvmDeclaredType newType, String qualifiedName) {
		checkQualifiedName(qualifiedName, "qualifiedName")
		Preconditions.checkArgument(qualifiedName.findType === null, '''The type '«qualifiedName»' has already been registered.''');
		compilationUnit.checkCanceled
		val namespaceAndName = getNameParts(qualifiedName)
		val headerText = compilationUnit.fileHeaderProvider.getFileHeader(compilationUnit.xtendFile.eResource)
		compilationUnit.jvmTypesBuilder.setFileHeader(newType, headerText)
		if (namespaceAndName.key !== null) {
			val parentType = findType(namespaceAndName.key)
			if (parentType !== null) {
				parentType.members += newType
				newType.static = true
			} else {
				newType.packageName = namespaceAndName.key
				acceptor.accept(newType) 
			}
		} else {
			acceptor.accept(newType) 
		}
		newType.simpleName = namespaceAndName.value
	}
	
	private def JvmDeclaredType findType(String string) {
		return findRecursively( string, compilationUnit.xtendFile.eResource.contents.filter(JvmDeclaredType))
	}
	
	private def JvmDeclaredType findRecursively(String string, Iterable<? extends JvmDeclaredType> types) {
		for (type : types) {
			val candidateQualifiedName= type.getQualifiedName(".")
			if (string == candidateQualifiedName) {
				return type;
			}
			if (string.startsWith(candidateQualifiedName)) {
				val result = findRecursively(string, type.members.filter(JvmDeclaredType))
				if (result !== null)
					return result
			}
		}
		return null;
	}
	
	private def Pair<String,String> getNameParts(String string) {
		val char dot = '.'
		val index = string.lastIndexOf(dot)
		if (index!=-1) {
			return string.substring(0, index) -> string.substring(index+1)
		} else {
			return null -> string
		}
	}
	
	@Delegate def FileSystemSupport getFileSystemSupport() {
		compilationUnit.fileSystemSupport
	}
	
	@Delegate def FileLocations getFileLocations() {
		compilationUnit.fileLocations
	}
	
	@Delegate def TypeLookupImpl getTypeLookup() {
		compilationUnit.typeLookup
	}
}