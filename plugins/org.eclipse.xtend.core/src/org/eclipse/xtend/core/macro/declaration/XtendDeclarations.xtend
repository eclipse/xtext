/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility

abstract class MemberDeclarationXtendImpl<T extends XtendMember> extends AbstractDeclarationImpl<T> implements MemberDeclaration {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getDeclaringType() {
		switch container : delegate.eContainer {
			XtendTypeDeclaration : compilationUnit.toTypeDeclaration(container)
			default : null
		}
	}
	
}

abstract class TypeDeclarationXtendImpl<T extends XtendTypeDeclaration> extends MemberDeclarationXtendImpl<T> implements TypeDeclaration {
	
	override getPackageName() {
		return (delegate.eContainer as XtendFile).getPackage
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getName() {
		if (packageName != null)
			packageName+'.'+simpleName
		else 
			simpleName
	}
	
}

class ClassDeclarationXtendImpl extends TypeDeclarationXtendImpl<XtendClass> implements ClassDeclaration {
	
	override getImplementedInterfaces() {
		delegate.getImplements.map[compilationUnit.toTypeReference(it)]
	}
	
	override getSuperclass() {
		compilationUnit.toTypeReference(delegate.getExtends)
	}
	
	override isAbstract() {
		delegate.isAbstract
	}
	
	override isFinal() {
		false
	}
	
	override isStatic() {
		false
	}
	
	override getFormalTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}

	override getVisibility() {
		return Visibility::PUBLIC
	}
	
	override getMembers() {
		return delegate.members.map[compilationUnit.toMemberDeclaration(it)]
	}
	
}

class MethodDeclarationXtendImpl extends MemberDeclarationXtendImpl<XtendFunction> implements MethodDeclaration {
	
	override isAbstract() {
		delegate.expression == null
	}
	
	override isFinal() {
		false
	}
	
	override isOverride() {
		delegate.isOverride
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.returnType)
	}

	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getName() {
		delegate.name
	}
	
	override getBody() {
//		delegate.expression.toExpression
	}
	
	override isVarArgs() {
		delegate.parameters.exists[varArgs]
	}
	
	override getFormalTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
}

class ConstructorDeclarationXtendImpl extends MemberDeclarationXtendImpl<XtendConstructor> implements ConstructorDeclaration {
	
	override getBody() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	

	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getName() {
		delegate.name
	}
	
	override isVarArgs() {
		delegate.parameters.exists[varArgs]
	}
	
	override getType() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getFormalTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
}

class FieldDeclarationXtendImpl extends MemberDeclarationXtendImpl<XtendField> implements FieldDeclaration {
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getName() {
		delegate.name
	}
	
	override getInitializer() {
//		delegate.initialValue.toExpression
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