/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl
import org.eclipse.xtend.core.macro.declaration.XtendNamedElementImpl
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.Element
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement

class TransformationContextImpl implements TransformationContext {

	@Inject IXtendJvmAssociations associations

	@Property CompilationUnitImpl unit

	override isExternal(NamedElement element) {
		!isSource(element) && !isGenerated(element)
	}

	override isGenerated(NamedElement element) {
		switch element {
			JvmNamedElementImpl<? extends JvmIdentifiableElement>: {
				return element.delegate.eResource == unit.xtendFile.eResource
			}
			default:
				false
		}
	}

	override isSource(NamedElement element) {
		element instanceof XtendNamedElementImpl<?>
	}

	override getPrimaryGeneratedJavaElement(NamedElement source) {
		if (isSource(source)) {
			val derivedElement = associations.getJvmElements((source as XtendNamedElementImpl<?>).delegate).filter(
				JvmIdentifiableElement).head
			if (derivedElement != null)
				return unit.toNamedElement(derivedElement) as MutableNamedElement
		}
		return null
	}

	override addError(Element element, String message) {
		unit.problemSupport.addError(element, message)
	}

	override addWarning(Element element, String message) {
		unit.problemSupport.addWarning(element, message)
	}

	override getProblems(Element element) {
		unit.problemSupport.getProblems(element)
	}

	override getAnyType() {
		unit.typeReferenceProvider.anyType
	}

	override getList(TypeReference param) {
		unit.typeReferenceProvider.getList(param)
	}

	override getObject() {
		unit.typeReferenceProvider.getObject
	}

	override getPrimitiveBoolean() {
		unit.typeReferenceProvider.primitiveBoolean
	}

	override getPrimitiveByte() {
		unit.typeReferenceProvider.primitiveByte
	}

	override getPrimitiveChar() {
		unit.typeReferenceProvider.primitiveChar
	}

	override getPrimitiveDouble() {
		unit.typeReferenceProvider.primitiveDouble
	}

	override getPrimitiveFloat() {
		unit.typeReferenceProvider.primitiveFloat
	}

	override getPrimitiveInt() {
		unit.typeReferenceProvider.primitiveInt
	}

	override getPrimitiveLong() {
		unit.typeReferenceProvider.primitiveLong
	}

	override getPrimitiveShort() {
		unit.typeReferenceProvider.primitiveShort
	}

	override getPrimitiveVoid() {
		unit.typeReferenceProvider.primitiveVoid
	}

	override getSet(TypeReference param) {
		unit.typeReferenceProvider.getSet(param)
	}

	override getString() {
		unit.typeReferenceProvider.string
	}

	override newArrayTypeReference(TypeReference componentType) {
		unit.typeReferenceProvider.newArrayTypeReference(componentType)
	}

	override newTypeReference(String typeName, TypeReference... typeArguments) {
		unit.typeReferenceProvider.newTypeReference(typeName, typeArguments)
	}

	override newTypeReference(Type typeDeclaration, TypeReference... typeArguments) {
		unit.typeReferenceProvider.newTypeReference(typeDeclaration, typeArguments)
	}

	override newTypeReference(Class<?> clazz, TypeReference... typeArguments) {
		unit.typeReferenceProvider.newTypeReference(clazz, typeArguments)
	}

	override newWildcardTypeReference() {
		unit.typeReferenceProvider.newWildcardTypeReference
	}

	override newWildcardTypeReference(TypeReference upperBound) {
		unit.typeReferenceProvider.newWildcardTypeReference(upperBound)
	}

	override newWildcardTypeReferenceWithLowerBound(TypeReference upperBound) {
		unit.typeReferenceProvider.newWildcardTypeReferenceWithLowerBound(upperBound)
	}

	override findInterface(String qualifiedName) {
		unit.typeLookup.findInterface(qualifiedName)
	}

	override findClass(String qualifiedName) {
		unit.typeLookup.findClass(qualifiedName)
	}

	override findAnnotationType(String qualifiedName) {
		unit.typeLookup.findAnnotationType(qualifiedName)
	}

	override findEnumerationType(String qualifiedName) {
		unit.typeLookup.findEnumerationType(qualifiedName)
	}

	override findTypeGlobally(Class<? extends Object> clazz) {
		unit.typeLookup.findTypeGlobally(clazz)
	}

	override findTypeGlobally(String typeName) {
		unit.typeLookup.findTypeGlobally(typeName)
	}
	
	override exists(Path path) {
		unit.fileSystemSupport.exists(path)
	}
	
	override getCharset(Path path) {
		unit.fileSystemSupport.getCharset(path)
	}
	
	override getChildren(Path path) {
		unit.fileSystemSupport.getChildren(path)
	}
	
	override getContents(Path path) {
		unit.fileSystemSupport.getContents(path)
	}
	
	override getContentsAsStream(Path path) {
		unit.fileSystemSupport.getContentsAsStream(path)
	}
	
	override getLastModification(Path path) {
		unit.fileSystemSupport.getLastModification(path)
	}
	
	override getProjectFolder(Path path) {
		unit.fileLocations.getProjectFolder(path)
	}
	
	override getSourceFolder(Path path) {
		unit.fileLocations.getSourceFolder(path)
	}
	
	override getTargetFolder(Path sourceFolder) {
		unit.fileLocations.getTargetFolder(sourceFolder)
	}
	
	override isFile(Path path) {
		unit.fileSystemSupport.isFile(path)
	}
	
	override isFolder(Path path) {
		unit.fileSystemSupport.isFolder(path)
	}
	
	override toURI(Path path) {
		unit.fileSystemSupport.toURI(path)
	}
	
}
