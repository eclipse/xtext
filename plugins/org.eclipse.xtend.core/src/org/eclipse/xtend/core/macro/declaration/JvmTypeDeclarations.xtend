/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation

import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration

abstract class NamedElementJavaImpl<T extends JvmIdentifiableElement> extends AbstractDeclarationImpl<T> implements NamedElement {
	
	override getName() {
		delegate.simpleName
	}
}

abstract class MemberDeclarationJavaImpl<T extends JvmMember> extends NamedElementJavaImpl<T> implements MemberDeclaration {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getDeclaringType() {
		compilationUnit.toTypeDeclaration(delegate.declaringType)
	}
	
}

abstract class TypeDeclarationJavaImpl<T extends JvmDeclaredType> extends MemberDeclarationJavaImpl<T> implements TypeDeclaration {
	
	override getMembers() {
		delegate.members.map[compilationUnit.toMemberDeclaration(it)]
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
	
}

class ClassDeclarationJavaImpl extends TypeDeclarationJavaImpl<JvmGenericType> implements ClassDeclaration {
	
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
	
	override getFormalTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
}

class InterfaceDeclarationJavaImpl extends TypeDeclarationJavaImpl<JvmGenericType> implements InterfaceDeclaration {
	
	override getSuperInterfaces() {
		delegate.superTypes.map[compilationUnit.toTypeReference(it)]
	}
	
	override getFormalTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
}

abstract class ExecutableDeclarationJavaImpl<T extends JvmExecutable> extends MemberDeclarationJavaImpl<T> implements ExecutableDeclaration {
	
	override getFormalTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
	override getType() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override isVarArgs() {
		delegate.varArgs
	}
	
	override getBody() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}

class MethodDeclarationJavaImpl extends ExecutableDeclarationJavaImpl<JvmOperation> implements MethodDeclaration {
	
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
	
	override getType() {
		compilationUnit.toTypeReference(delegate.returnType)
	}
	
}

class ConstructorDeclarationJavaImpl extends ExecutableDeclarationJavaImpl<JvmConstructor> implements ConstructorDeclaration {
	
	override getBody() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}

class FieldDeclarationJavaImpl extends MemberDeclarationJavaImpl<JvmField> implements FieldDeclaration {
	
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
