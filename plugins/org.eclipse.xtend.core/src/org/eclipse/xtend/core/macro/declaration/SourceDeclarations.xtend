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
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtend.lib.macro.declaration.SourceTypeParameterDeclaration
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtend.lib.macro.declaration.SourceExecutableDeclaration
import org.eclipse.xtend.lib.macro.declaration.SourceTypeParameterDeclarator

abstract class SourceMemberDeclarationImpl<T extends XtendMember> extends AbstractDeclarationImpl<T> implements SourceMemberDeclaration {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getDeclaringType() {
		switch container : delegate.eContainer {
			XtendTypeDeclaration : compilationUnit.toSourceTypeDeclaration(container)
			default : null
		}
	}
	
}

abstract class SourceTypeDeclarationImpl<T extends XtendTypeDeclaration> extends SourceMemberDeclarationImpl<T> implements SourceTypeDeclaration {
	
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

class SourceClassDeclarationImpl extends SourceTypeDeclarationImpl<XtendClass> implements SourceClassDeclaration {
	
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
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toSourceTypeParameterDeclaration(it)]
	}

	override getVisibility() {
		return Visibility::PUBLIC
	}
	
	override getMembers() {
		return delegate.members.map[compilationUnit.toSourceMemberDeclaration(it)]
	}
	
}

class SourceMethodDeclarationImpl extends SourceMemberDeclarationImpl<XtendFunction> implements SourceMethodDeclaration {
	
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
	
	override getReturnType() {
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
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toSourceTypeParameterDeclaration(it)]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toSourceParameterDeclaration(it)]
	}
	
}

class SourceConstructorDeclarationImpl extends SourceMemberDeclarationImpl<XtendConstructor> implements SourceConstructorDeclaration {
	
	override getBody() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}

	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getName() {
		declaringType.simpleName
	}
	
	override isVarArgs() {
		delegate.parameters.exists[varArgs]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toSourceParameterDeclaration(it)]
	}

	override getTypeParameters() {
		emptyList
	}
	
}

class SourceParameterDeclarationImpl extends AbstractDeclarationImpl<XtendParameter> implements SourceParameterDeclaration {

	override getType() {
		compilationUnit.toTypeReference(delegate.parameterType)
	}
	
	override getName() {
		delegate.name
	}

	override getDeclaringExecutable() {
		compilationUnit.toSourceMemberDeclaration(delegate.eContainer as XtendMember) as SourceExecutableDeclaration
	}
	
}

class SourceFieldDeclarationImpl extends SourceMemberDeclarationImpl<XtendField> implements SourceFieldDeclaration {
	
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

class SourceTypeParameterDeclarationImpl extends AbstractDeclarationImpl<JvmTypeParameter> implements SourceTypeParameterDeclaration {
	
	override getUpperBounds() {
		delegate.constraints.filter(typeof(JvmUpperBound)).map[compilationUnit.toTypeReference(typeReference)].toList
	}
	
	override getName() {
		delegate.name
	}
	
	override getTypeParameterDeclarator() {
		compilationUnit.toSourceMemberDeclaration(delegate.eContainer as XtendMember) as SourceTypeParameterDeclarator
	}
	
}