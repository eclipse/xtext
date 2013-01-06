/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.GeneratedClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedExecutableDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedNamedElement
import org.eclipse.xtend.lib.macro.declaration.GeneratedParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import java.lang.String
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtext.common.types.JvmVisibility
import java.util.List
import org.eclipse.xtend.lib.macro.type.TypeReference

abstract class GeneratedNamedElementImpl<T extends JvmIdentifiableElement> extends AbstractDeclarationImpl<T> implements GeneratedNamedElement {
	
	override getName() {
		delegate.simpleName
	}
	
}

abstract class GeneratedMemberDeclarationImpl<T extends JvmMember> extends GeneratedNamedElementImpl<T> implements GeneratedMemberDeclaration {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override setDocComment(String docComment) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override setVisibility(Visibility visibility) {
		delegate.visibility = switch visibility {
			case Visibility::DEFAULT : JvmVisibility::DEFAULT
			case Visibility::PUBLIC : JvmVisibility::PUBLIC
			case Visibility::PRIVATE : JvmVisibility::PRIVATE
			case Visibility::PROTECTED : JvmVisibility::PROTECTED
		}
	}
	
	override getDeclaringType() {
		compilationUnit.toTypeDeclaration(delegate.declaringType) as GeneratedTypeDeclaration
	}
	
	override setName(String name) {
		delegate.simpleName = name
	}
	
}

abstract class GeneratedTypeDeclarationImpl<T extends JvmDeclaredType> extends GeneratedMemberDeclarationImpl<T> implements GeneratedTypeDeclaration {
	
	override getMembers() {
		delegate.members.map[compilationUnit.toMemberDeclaration(it) as GeneratedMemberDeclaration]
	}
	
	override getPackageName() {
		delegate.packageName
	}
	
	override getSimpleName() {
		delegate.simpleName
	}
	
	override getName() {
		delegate.identifier
	}
	
	override setPackageName(String packageName) {
		delegate.packageName = packageName
	}
	
	override setSimpleName(String simpleName) {
		delegate.simpleName = simpleName
	}
	
	override setName(String name) {
		val idx = name.lastIndexOf('.')
		if (idx == -1) {
			delegate.packageName = null
			delegate.simpleName = name
		} else {
			delegate.packageName = name.substring(0, idx-1)
			delegate.simpleName = name.substring(idx)
		}
	}
	
}

class GeneratedClassDeclarationImpl extends GeneratedTypeDeclarationImpl<JvmGenericType> implements GeneratedClassDeclaration {
	
	override getImplementedInterfaces() {
		val filtered = delegate.superTypes.filter[(it.type as JvmGenericType).interface]
		filtered.map[compilationUnit.toTypeReference(it)].toList
	}
	
	override getSuperclass() {
		compilationUnit.toTypeReference(delegate.superTypes.findFirst[(it.type as JvmGenericType).interface])
	}
	
	override isAbstract() {
		delegate.isAbstract
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	

	override setAbstract(boolean isAbstract) {
		delegate.setAbstract(isAbstract)
	}
	
	override setFinal(boolean isFinal) {
		delegate.setFinal(isFinal)
	}
	
	override setStatic(boolean isStatic) {
		delegate.setStatic(isStatic)
	}
	
	override setSuperclass(TypeReference superclass) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override setImplementedInterfaces(List<? extends TypeReference> superclass) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
}

//class InterfaceDeclarationJavaImpl extends GeneratedTypeDeclarationImpl<JvmGenericType> implements GeneratedInterfaceDeclaration {
//	
//	override getSuperInterfaces() {
//		delegate.superTypes.map[compilationUnit.toTypeReference(it)]
//	}
//	
//	override getTypeParameters() {
//		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
//	}
//	
//}

abstract class GeneratedExecutableDeclarationImpl<T extends JvmExecutable> extends GeneratedMemberDeclarationImpl<T> implements GeneratedExecutableDeclaration {
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it) as GeneratedTypeParameterDeclaration]
	}
	
	override isVarArgs() {
		delegate.varArgs
	}
	
	override getBody() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toParameterDeclaration(it) as GeneratedParameterDeclaration]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
}

class GeneratedParameterDeclarationImpl extends GeneratedNamedElementImpl<JvmFormalParameter> implements GeneratedParameterDeclaration {

	override getType() {
		compilationUnit.toTypeReference(delegate.parameterType)
	}
	
	override getDeclaringExecutable() {
		compilationUnit.toMemberDeclaration(delegate.eContainer as JvmMember) as GeneratedExecutableDeclaration
	}
	
	override setName(String name) {
		delegate.name = name
	}
	
}

class GeneratedMethodDeclarationImpl extends GeneratedExecutableDeclarationImpl<JvmOperation> implements GeneratedMethodDeclaration {
	
	override isAbstract() {
		delegate.isAbstract
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
	override isOverride() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override getReturnType() {
		compilationUnit.toTypeReference(delegate.returnType)
	}
	
}

class GeneratedConstructorDeclarationImpl extends GeneratedExecutableDeclarationImpl<JvmConstructor> implements GeneratedConstructorDeclaration {
	
	override getName() {
		declaringType.simpleName
	}
	
	override getBody() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}

class GeneratedFieldDeclarationImpl extends GeneratedMemberDeclarationImpl<JvmField> implements GeneratedFieldDeclaration {
	
	override getInitializer() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.type)
	}
	
}

class GeneratedTypeParameterDeclarationImpl extends TypeParameterDeclarationImpl implements GeneratedTypeParameterDeclaration {
	
	override GeneratedTypeParameterDeclarator getTypeParameterDeclarator() {
		compilationUnit.toMemberDeclaration(delegate.eContainer as JvmExecutable) as GeneratedTypeParameterDeclarator
	}
	
	override setName(String name) {
		delegate.name = name
	}
	
}
