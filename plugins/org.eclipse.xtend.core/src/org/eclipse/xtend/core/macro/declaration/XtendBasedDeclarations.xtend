/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 
package org.eclipse.xtend.core.macro.declaration

import com.google.common.collect.ImmutableList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendEnumLiteral
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.AnnotationTarget
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation

abstract class XtendNamedElementImpl<T extends EObject> extends AbstractNamedElementImpl<T> {
	
}

abstract class XtendAnnotationTargetImpl<T extends XtendAnnotationTarget> extends XtendNamedElementImpl<T> implements AnnotationTarget {
	
	override getAnnotations() {
		ImmutableList::copyOf( this.delegate.annotations.map[compilationUnit.toAnnotationReference(it)] )
	}
	
	override findAnnotation(Type annotationType) {
		annotations.findFirst[it.annotationTypeDeclaration == annotationType]
	}
	
}

abstract class XtendMemberDeclarationImpl<T extends XtendMember> extends XtendAnnotationTargetImpl<T> implements MemberDeclaration {
	
	override getDocComment() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getDeclaringType() {
		switch container : delegate.eContainer {
			XtendTypeDeclaration : compilationUnit.toXtendTypeDeclaration(container)
			default : null
		}
	}
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
}

abstract class XtendTypeDeclarationImpl<T extends XtendTypeDeclaration> extends XtendMemberDeclarationImpl<T> implements TypeDeclaration {
	
	def getPackageName() {
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
	
	override getVisibility() {
		return compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getDeclaredMembers() {
		return delegate.members.map[compilationUnit.toXtendMemberDeclaration(it)]
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
	override findConstructor(TypeReference... parameterTypes) {
		declaredConstructors.findFirst[constructor | constructor.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override findField(String name) {
		declaredFields.findFirst[field | field.name == name]
	}
	
	override findMethod(String name, TypeReference... parameterTypes) {
		declaredMethods.findFirst[method | method.name == name && method.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override getDeclaredMethods() {
		declaredMembers.filter(typeof(MethodDeclaration))
	}
	
	override getDeclaredFields() {
		declaredMembers.filter(typeof(FieldDeclaration))
	}
	
	override getDeclaredClasses() {
		declaredMembers.filter(typeof(ClassDeclaration))
	}
	
	override getDeclaredConstructors() {
		declaredMembers.filter(typeof(ConstructorDeclaration))
	}
	
	override getDeclaredInterfaces() {
		declaredMembers.filter(typeof(InterfaceDeclaration))
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
		delegate.final
	}
	
	override isStatic() {
		true
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}

}

class XtendInterfaceDeclarationImpl extends XtendTypeDeclarationImpl<XtendInterface> implements InterfaceDeclaration {
	
	override getSuperInterfaces() {
		delegate.extends.map[compilationUnit.toTypeReference(it)]
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}

}

class XtendEnumerationDeclarationImpl extends XtendTypeDeclarationImpl<XtendEnum> implements EnumerationTypeDeclaration {
	
}

class XtendAnnotationTypeDeclarationImpl extends XtendTypeDeclarationImpl<XtendAnnotationType> implements AnnotationTypeDeclaration {
	
}

class XtendMethodDeclarationImpl extends XtendMemberDeclarationImpl<XtendFunction> implements MethodDeclaration {
	
	override isAbstract() {
		delegate.expression == null
	}
	
	override isFinal() {
		delegate.final
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
		throw new UnsupportedOperationException("Auto-generated function stub")
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

class XtendParameterDeclarationImpl extends XtendAnnotationTargetImpl<XtendParameter> implements ParameterDeclaration {

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
	
	override ClassDeclaration getDeclaringType() {
		super.getDeclaringType() as ClassDeclaration
	}
	
}

class XtendEnumerationValueDeclarationImpl extends XtendMemberDeclarationImpl<XtendEnumLiteral> implements EnumerationValueDeclaration {
	
	override getName() {
		delegate.name
	}
}

class XtendAnnotationTypeElementDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements AnnotationTypeElementDeclaration {
	
	override getName() {
		delegate.name
	}
	
	override getDefaultValue() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getDefaultValueExpression() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.type)
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
	
	override getAnnotations() {
		emptyList
	}
	
	override findAnnotation(Type annotationType) {
		null
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
}

class XtendAnnotationReferenceImpl extends AbstractDeclarationImpl<XAnnotation> implements AnnotationReference {
	
	override getAnnotationTypeDeclaration() {
		switch type: delegate.annotationType {
			JvmAnnotationType: compilationUnit.toTypeDeclaration(type) as AnnotationTypeDeclaration
			default: null
		}
	}
	
	override getExpression(String property) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getValue(String property) {
		if (property == 'value' && delegate.value != null) {
			return compilationUnit.evaluate(delegate.value)
		}
		val expression = delegate.elementValuePairs.findFirst[element.simpleName == property]?.value
		if (expression != null)
			return compilationUnit.evaluate(expression)
		return null
	}
	
}