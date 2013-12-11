/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.lib.Pair

import static org.eclipse.xtend.core.macro.ConditionUtils.*

class RegisterGlobalsContextImpl implements RegisterGlobalsContext {
	
	@Property IJvmDeclaredTypeAcceptor acceptor
	@Property CompilationUnitImpl compilationUnit
	
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
		compilationUnit.checkCanceled
		val namespaceAndName = getNameParts(qualifiedName)
		val headerText = compilationUnit.fileHeaderProvider.getFileHeader(compilationUnit.xtendFile.eResource)
		compilationUnit.jvmTypesBuilder.setFileHeader(newType, headerText)
		if (namespaceAndName.key != null) {
			val parentType = findType(namespaceAndName.key)
			if (parentType != null) {
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
			if (string.startsWith(type.identifier)) {
				if (string == type.identifier) {
					return type;
				}
				val result = findRecursively(string, type.members.filter(JvmDeclaredType))
				if (result != null)
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
	

	override exists(Path path) {
		compilationUnit.fileSystemSupport.exists(path)
	}
	
	override getCharset(Path path) {
		compilationUnit.fileSystemSupport.getCharset(path)
	}
	
	override getChildren(Path path) {
		compilationUnit.fileSystemSupport.getChildren(path)
	}
	
	override getContents(Path path) {
		compilationUnit.fileSystemSupport.getContents(path)
	}
	
	override getContentsAsStream(Path path) {
		compilationUnit.fileSystemSupport.getContentsAsStream(path)
	}
	
	override getLastModification(Path path) {
		compilationUnit.fileSystemSupport.getLastModification(path)
	}
	
	override getProjectFolder(Path path) {
		compilationUnit.fileLocations.getProjectFolder(path)
	}
	
	override getSourceFolder(Path path) {
		compilationUnit.fileLocations.getSourceFolder(path)
	}
	
	override getTargetFolder(Path sourceFolder) {
		compilationUnit.fileLocations.getTargetFolder(sourceFolder)
	}
	
	override isFile(Path path) {
		compilationUnit.fileSystemSupport.isFile(path)
	}
	
	override isFolder(Path path) {
		compilationUnit.fileSystemSupport.isFolder(path)
	}
	
	override toURI(Path path) {
		compilationUnit.fileSystemSupport.toURI(path)
	}
	
}