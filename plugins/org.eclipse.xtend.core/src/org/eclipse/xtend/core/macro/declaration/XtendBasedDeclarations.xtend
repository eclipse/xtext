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
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.macro.declaration.NamedElement

abstract class XtendNamedElementImpl<T extends EObject> extends AbstractNamedElementImpl<T> implements NamedElement {
}

abstract class XtendMemberDeclarationImpl<T extends XtendMember> extends XtendNamedElementImpl<T> implements MemberDeclaration {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getDeclaringType() {
		switch container : delegate.eContainer {
			XtendTypeDeclaration : compilationUnit.toXtendTypeDeclaration(container)
			default : null
		}
	}
	
}

abstract class XtendTypeDeclarationImpl<T extends XtendTypeDeclaration> extends XtendMemberDeclarationImpl<T> implements TypeDeclaration {
	
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

class XtendClassDeclarationImpl extends XtendTypeDeclarationImpl<XtendClass> implements ClassDeclaration {
	
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
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}

	override getVisibility() {
		return Visibility::PUBLIC
	}
	
	override getMembers() {
		return delegate.members.map[compilationUnit.toXtendMemberDeclaration(it)]
	}
	
}

class XtendMethodDeclarationImpl extends XtendMemberDeclarationImpl<XtendFunction> implements MethodDeclaration {
	
	override isAbstract() {
		delegate.expression == null
	}
	
	override isFinal() {
		false
	}
	
	//TODO declare in interface
	def isOverride() {
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
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toXtendParameterDeclaration(it)]
	}
	
}

class XtendConstructorDeclarationImpl extends XtendMemberDeclarationImpl<XtendConstructor> implements ConstructorDeclaration {
	
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
		delegate.parameters.map[compilationUnit.toXtendParameterDeclaration(it)]
	}

	override getTypeParameters() {
		emptyList
	}
	
}

class XtendParameterDeclarationImpl extends AbstractDeclarationImpl<XtendParameter> implements ParameterDeclaration {

	override getType() {
		compilationUnit.toTypeReference(delegate.parameterType)
	}
	
	override getName() {
		delegate.name
	}

	override getDeclaringExecutable() {
		compilationUnit.toXtendMemberDeclaration(delegate.eContainer as XtendMember) as ExecutableDeclaration
	}
	
}

class XtendFieldDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements FieldDeclaration {
	
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
	
	override ClassDeclaration getDeclaringType() {
		super.getDeclaringType() as ClassDeclaration
	}
	
}

class XtendTypeParameterDeclarationImpl extends AbstractDeclarationImpl<JvmTypeParameter> implements TypeParameterDeclaration {
	
	override getUpperBounds() {
		delegate.constraints.filter(typeof(JvmUpperBound)).map[compilationUnit.toTypeReference(typeReference)].toList
	}
	
	override getName() {
		delegate.name
	}
	
	override getTypeParameterDeclarator() {
		val eContainer = delegate.eContainer
		compilationUnit.toXtendMemberDeclaration(eContainer as XtendMember) as TypeParameterDeclarator
	}
	
}