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
import org.eclipse.emf.ecore.InternalEObject
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
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation

import static org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage.Literals.*

abstract class XtendNamedElementImpl<T extends EObject> extends AbstractNamedElementImpl<T> {
	
}

abstract class XtendAnnotationTargetImpl<T extends XtendAnnotationTarget> extends XtendNamedElementImpl<T> implements AnnotationTarget {
	
	override getAnnotations() {
		ImmutableList.copyOf( this.delegate.annotations.map[compilationUnit.toAnnotationReference(it)] )
	}
	
	override findAnnotation(Type annotationType) {
		annotations.findFirst[it.annotationTypeDeclaration == annotationType]
	}
	
}

abstract class XtendMemberDeclarationImpl<T extends XtendMember> extends XtendAnnotationTargetImpl<T> implements MemberDeclaration {
	
	override getDocComment() {
		compilationUnit.documentationProvider.getDocumentation(delegate)
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
	
	override getQualifiedName() {
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
	
	override findDeclaredConstructor(TypeReference... parameterTypes) {
		declaredConstructors.findFirst[constructor | constructor.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override findDeclaredField(String name) {
		declaredFields.findFirst[field | field.simpleName == name]
	}
	
	override findDeclaredMethod(String name, TypeReference... parameterTypes) {
		declaredMethods.findFirst[method | method.simpleName == name && method.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override getDeclaredMethods() {
		declaredMembers.filter(MethodDeclaration)
	}
	
	override getDeclaredFields() {
		declaredMembers.filter(FieldDeclaration)
	}
	
	override getDeclaredClasses() {
		declaredMembers.filter(ClassDeclaration)
	}
	
	override getDeclaredConstructors() {
		declaredMembers.filter(ConstructorDeclaration)
	}
	
	override getDeclaredInterfaces() {
		declaredMembers.filter(InterfaceDeclaration)
	}
	
}

class XtendClassDeclarationImpl extends XtendTypeDeclarationImpl<XtendClass> implements ClassDeclaration {
	
	override getImplementedInterfaces() {
		delegate.getImplements.map[compilationUnit.toTypeReference(it)]
	}
	
	override getExtendedClass() {
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
	
	override isStrictFloatingPoint() {
		false	
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}

}

class XtendInterfaceDeclarationImpl extends XtendTypeDeclarationImpl<XtendInterface> implements InterfaceDeclaration {
	
	override getExtendedInterfaces() {
		delegate.extends.map[compilationUnit.toTypeReference(it)]
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}

	override isStrictFloatingPoint() {
		false	
	}

}

class XtendEnumerationDeclarationImpl extends XtendTypeDeclarationImpl<XtendEnum> implements EnumerationTypeDeclaration {
	
	override findDeclaredValue(String name) {
		declaredValues.findFirst[value | value.simpleName == name]
	}
	
	override getDeclaredValues() {
		declaredMembers.filter(EnumerationValueDeclaration)
	}
	
}

class XtendAnnotationTypeDeclarationImpl extends XtendTypeDeclarationImpl<XtendAnnotationType> implements AnnotationTypeDeclaration {
	
	override findDeclaredAnnotationTypeElement(String name) {
		declaredAnnotationTypeElements.findFirst[simpleName == name]
	}
	
	override getDeclaredAnnotationTypeElements() {
		delegate.members.map[compilationUnit.toXtendMemberDeclaration(it)].filter(AnnotationTypeElementDeclaration)
	}
	
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
	
	override isSynchronized() {
		false
	}

	override isDefault() {
		false
	}
	
	override isStrictFloatingPoint() {
		false	
	}
	
	override isNative() {
		false	
	}
	
	override getReturnType() {
		compilationUnit.toTypeReference(delegate.returnType)
	}

	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getBody() {
		if (delegate.expression == null)
			return null
		return compilationUnit.toExpression(delegate.expression)
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
		if (delegate.expression == null)
			return null
		return compilationUnit.toExpression(delegate.expression)
	}

	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getSimpleName() {
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
	
	override getSimpleName() {
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
	
	override getSimpleName() {
		delegate.name
	}
	
	override getInitializer() {
		if (delegate.initialValue == null)
			return null
		return compilationUnit.toExpression(delegate.initialValue)
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override isTransient() {
		return false;
	}

	override isVolatile() {
		return false;
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.type)
	}
	
	override ClassDeclaration getDeclaringType() {
		super.getDeclaringType() as ClassDeclaration
	}
	
}

class XtendEnumerationValueDeclarationImpl extends XtendMemberDeclarationImpl<XtendEnumLiteral> implements EnumerationValueDeclaration {
	
	override getSimpleName() {
		delegate.name
	}
	
	override EnumerationTypeDeclaration getDeclaringType() {
		super.getDeclaringType() as EnumerationTypeDeclaration
	}
	
}

class XtendAnnotationTypeElementDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements AnnotationTypeElementDeclaration {
	
	override getSimpleName() {
		delegate.name
	}
	
	override getDefaultValue() {
		if (delegate.initialValue == null)
			return null
		compilationUnit.evaluate(delegate.initialValue, delegate.type)
	}
	
	override getDefaultValueExpression() {
		if (delegate.initialValue == null)
			return null
		compilationUnit.toExpression(delegate.initialValue) 
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.type)
	}
	
}

class XtendTypeParameterDeclarationImpl extends AbstractElementImpl<JvmTypeParameter> implements TypeParameterDeclaration {
	
	override getUpperBounds() {
		delegate.constraints.filter(JvmUpperBound).map[compilationUnit.toTypeReference(typeReference)].toList
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getQualifiedName() {
		simpleName
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

class XtendAnnotationReferenceImpl extends AbstractElementImpl<XAnnotation> implements AnnotationReference {
	
	override getAnnotationTypeDeclaration() {
		switch type: getAnnotationType() {
			JvmAnnotationType: compilationUnit.toTypeDeclaration(type) as AnnotationTypeDeclaration
			default: null
		}
	}
	
	def getAnnotationType() {
		if (!compilationUnit.indexing) {
			return delegate.annotationType	
		}
		switch proxy : delegate.eGet(XANNOTATION__ANNOTATION_TYPE, false) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				return delegate.eResource.resourceSet.getEObject(uri, true) as JvmType
			}
			JvmType: {
				proxy
			}
		}
	}
	
	override getExpression(String property) {
		if (property == 'value' && delegate.value != null) {
			return compilationUnit.toExpression(delegate.value)
		}
		val expression = delegate.elementValuePairs.findFirst[element.simpleName == property]?.value
		if (expression != null)
			return compilationUnit.toExpression(expression)
		return null
	}
	
	override getValue(String property) {
		if (property == 'value' && delegate.value != null) {
			return compilationUnit.evaluate(delegate.value, null)
		}
		val annoValue = delegate.elementValuePairs.findFirst[element.simpleName == property]
		val expression = annoValue?.value
		if (expression != null)
			return compilationUnit.evaluate(expression, annoValue.element?.returnType)
		return annotationTypeDeclaration.findDeclaredAnnotationTypeElement(property).defaultValue
	}
	
}