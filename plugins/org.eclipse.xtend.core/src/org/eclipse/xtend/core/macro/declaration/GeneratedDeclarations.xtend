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

abstract class GeneratedNamedElementImpl<T extends JvmIdentifiableElement> extends AbstractDeclarationImpl<T> implements GeneratedNamedElement {
	
	override getName() {
		delegate.simpleName
	}
}

abstract class GeneratedMemberDeclarationImpl<T extends JvmMember> extends GeneratedNamedElementImpl<T> implements GeneratedMemberDeclaration {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getDeclaringType() {
		compilationUnit.toTypeDeclaration(delegate.declaringType) as GeneratedTypeDeclaration
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
	
}
