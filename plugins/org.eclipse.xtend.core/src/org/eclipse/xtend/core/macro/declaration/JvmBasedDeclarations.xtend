/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import com.google.common.collect.ImmutableList
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeElementDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.lib.Procedures$Procedure1
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter
import org.eclipse.xtext.common.types.impl.JvmMemberImplCustom

abstract class JvmNamedElementImpl<T extends JvmIdentifiableElement> extends AbstractElementImpl<T> implements MutableNamedElement {
	
	override getSimpleName() {
		delegate.simpleName
	}
	
	override remove() {
		if (delegate.eContainer == null)
			return;
		EcoreUtil::remove(delegate)
		if (delegate.eContainer != null)
			throw new IllegalStateException("Couldn't remove "+delegate.toString)
	}
	
	override toString() {
		class.name+"["+simpleName+"]"
	}
}

abstract class JvmAnnotationTargetImpl<T extends JvmAnnotationTarget> extends JvmNamedElementImpl<T> implements MutableAnnotationTarget {
	override getAnnotations() {
		ImmutableList::copyOf(delegate.annotations.map[compilationUnit.toAnnotationReference(it)])
	}	
	
	override addAnnotation(Type annotationType) {
		switch annotationType { 
			JvmAnnotationTypeDeclarationImpl : {
				val result = TypesFactory::eINSTANCE.createJvmAnnotationReference
				result.setAnnotation(annotationType.delegate)
				this.delegate.annotations.add(result)
				return compilationUnit.toAnnotationReference(result)
			}
			default : throw new IllegalArgumentException(""+annotationType+" is not an annotation type.")
		}
	}
	
	override findAnnotation(Type annotationType) {
		annotations.findFirst[annotationTypeDeclaration == annotationType]
	}
}

abstract class JvmMemberDeclarationImpl<T extends JvmMember> extends JvmAnnotationTargetImpl<T> implements MutableMemberDeclaration {
	
	override getDocComment() {
		val adapter = EcoreUtil::getAdapter(delegate.eAdapters(), typeof(DocumentationAdapter)) as DocumentationAdapter;
		return adapter?.getDocumentation();
	}
	
	override setDocComment(String docComment) {
		var adapter = EcoreUtil::getAdapter(delegate.eAdapters(), typeof(DocumentationAdapter)) as DocumentationAdapter;
		if (adapter == null) {
			adapter = new DocumentationAdapter
			delegate.eAdapters += adapter
		}
		adapter.setDocumentation(docComment)
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
		compilationUnit.toTypeDeclaration(delegate.declaringType)
	}
	
	override setSimpleName(String name) {
		switch (it: delegate) {
			JvmMemberImplCustom : clearIdentifierCache
		}
		delegate.simpleName = name
	}
	
}

abstract class JvmTypeDeclarationImpl<T extends JvmDeclaredType> extends JvmMemberDeclarationImpl<T> implements MutableTypeDeclaration {
	
	override getDeclaredMembers() {
		ImmutableList::copyOf(delegate.members.map[compilationUnit.toMemberDeclaration(it)])
	}
	
	override getSimpleName() {
		delegate.simpleName
	}
	
	override getQualifiedName() {
		delegate.identifier
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
	override addConstructor(Procedure1<MutableConstructorDeclaration> initializer) {
		// remove default constructor
		val constructor = delegate.members.filter(typeof(JvmConstructor)).findFirst[compilationUnit.typeExtensions.isSingleSyntheticDefaultConstructor(it)]
		if (constructor != null) {
			EcoreUtil::remove(constructor)
		}
		val newConstructor = TypesFactory::eINSTANCE.createJvmConstructor
		newConstructor.visibility = JvmVisibility::PUBLIC
		newConstructor.simpleName = simpleName
		delegate.members.add(newConstructor)
		val mutableConstructorDeclaration = compilationUnit.toMemberDeclaration(newConstructor) as MutableConstructorDeclaration
		initializer.apply(mutableConstructorDeclaration)
		return mutableConstructorDeclaration
	}
	
	override addField(String name, Procedure1<MutableFieldDeclaration> initializer) {
		val newField = TypesFactory::eINSTANCE.createJvmField
		newField.simpleName = name
		newField.visibility = JvmVisibility::PRIVATE
		delegate.members.add(newField)
		val mutableFieldDeclaration = compilationUnit.toMemberDeclaration(newField) as MutableFieldDeclaration
		initializer.apply(mutableFieldDeclaration)
		return mutableFieldDeclaration
	}
	
	override addMethod(String name, Procedure1<MutableMethodDeclaration> initializer) {
		val newMethod = TypesFactory::eINSTANCE.createJvmOperation
		newMethod.visibility = JvmVisibility::PUBLIC
		newMethod.simpleName = name
		newMethod.returnType = compilationUnit.toJvmTypeReference(compilationUnit.typeReferenceProvider.primitiveVoid)
		delegate.members.add(newMethod)
		val mutableMethodDeclaration = compilationUnit.toMemberDeclaration(newMethod) as MutableMethodDeclaration
		initializer.apply(mutableMethodDeclaration)
		return mutableMethodDeclaration
	}
	
	override findConstructor(TypeReference... parameterTypes) {
		declaredConstructors.findFirst[constructor | constructor.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override findField(String name) {
		declaredFields.findFirst[field | field.simpleName == name]
	}
	
	override findMethod(String name, TypeReference... parameterTypes) {
		declaredMethods.findFirst[method | method.simpleName == name && method.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override getDeclaredMethods() {
		declaredMembers.filter(typeof(MutableMethodDeclaration))
	}
	
	override getDeclaredFields() {
		declaredMembers.filter(typeof(MutableFieldDeclaration))
	}
	
	override getDeclaredClasses() {
		declaredMembers.filter(typeof(MutableClassDeclaration))
	}
	
	override getDeclaredConstructors() {
		declaredMembers.filter(typeof(MutableConstructorDeclaration))
	}
	
	override getDeclaredInterfaces() {
		declaredMembers.filter(typeof(MutableInterfaceDeclaration))
	}
	
}

class JvmInterfaceDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements MutableInterfaceDeclaration {
	
	override getExtendedInterfaces() {
		val filtered = delegate.superTypes.filter[(it.type as JvmGenericType).interface]
		filtered.map[compilationUnit.toTypeReference(it)].toList
	}
	
	override setExtendedInterfaces(Iterable<? extends TypeReference> superinterfaces) {
		delegate.superTypes.clear
		for (typeRef : superinterfaces) {
			switch typeRef { TypeReferenceImpl : {
				delegate.superTypes += typeRef.delegate.toJavaCompliantTypeReference
			}}
		}
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
}

class JvmAnnotationTypeDeclarationImpl extends JvmTypeDeclarationImpl<JvmAnnotationType> implements MutableAnnotationTypeDeclaration {
	
}

class JvmEnumerationTypeDeclarationImpl extends JvmTypeDeclarationImpl<JvmEnumerationType> implements MutableEnumerationTypeDeclaration {
	
}

class JvmClassDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements MutableClassDeclaration {
	
	override getImplementedInterfaces() {
		val filtered = delegate.superTypes.filter[(it.type as JvmGenericType).interface]
		filtered.map[compilationUnit.toTypeReference(it)].toList
	}
	
	override getExtendedClass() {
		compilationUnit.toTypeReference(delegate.superTypes.findFirst[
			switch it: type {
				JvmGenericType case !interface : true
				default : false
			}
		])
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
	
	override setExtendedClass(TypeReference superclass) {
		val newTypeRef = 
			switch superclass {
				TypeReferenceImpl : superclass.delegate.toJavaCompliantTypeReference
				case null : compilationUnit.typeReferences.getTypeForName(typeof(Object), compilationUnit.xtendFile)
			}
		val oldType = delegate.superTypes.findFirst[it.type instanceof JvmGenericType && !(type as JvmGenericType).isInterface]
		if (oldType != null)
			delegate.superTypes.remove(oldType)
		delegate.superTypes.add(newTypeRef)
	}
	
	override setImplementedInterfaces(Iterable<? extends TypeReference> superInterfaces) {
		val oldInterfaces = delegate.superTypes.filter[it.type instanceof JvmGenericType && (type as JvmGenericType).isInterface]
		delegate.superTypes.removeAll(oldInterfaces)
		delegate.superTypes.addAll(superInterfaces.filter(typeof(TypeReferenceImpl)).map[delegate.toJavaCompliantTypeReference])
	}

	override findField(String name) {
		declaredMembers.filter(typeof(MutableFieldDeclaration)).findFirst[it.simpleName == name]
	}
	
	override findMethod(String name, TypeReference[] parameterTypes) {
		declaredMembers.filter(typeof(MutableMethodDeclaration)).findFirst[
			it.simpleName == name 
			&& it.parameters.map[type].toList == parameterTypes.toList
		]
	}

}

abstract class JvmExecutableDeclarationImpl<T extends JvmExecutable> extends JvmMemberDeclarationImpl<T> implements MutableExecutableDeclaration {
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
	override isVarArgs() {
		delegate.varArgs
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toParameterDeclaration(it)]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
	override getBody() {
		val expression = compilationUnit.jvmTypesBuilder.getExpression(delegate)
		compilationUnit.toExpression(expression)
	}
	
	override setBody(Expression body) {
		if (body == null) {
			compilationUnit.jvmTypesBuilder.removeExistingBody(delegate)
		} else {
			compilationUnit.jvmTypesBuilder.setBody(delegate, (body as ExpressionImpl).delegate)
		}
	}
	
	override setExceptions(TypeReference... exceptions) {
		delegate.exceptions.clear
		for (exceptionType : exceptions) {
			if (exceptionType != null) {
				delegate.exceptions.add(compilationUnit.toJvmTypeReference(exceptionType))
			}
		}
	}
	
	override setVarArgs(boolean isVarArgs) {
		delegate.setVarArgs(isVarArgs)
	}
	
	override addTypeParameter(String name, TypeReference... upperBounds) {
		val param = TypesFactory::eINSTANCE.createJvmTypeParameter
		param.name = name
		delegate.typeParameters.add(param)
		for (upper : upperBounds) {
			val typeRef = compilationUnit.toJvmTypeReference(upper)
			val jvmUpperBound = TypesFactory::eINSTANCE.createJvmUpperBound
			jvmUpperBound.setTypeReference(typeRef)
			param.constraints.add(jvmUpperBound)
		}
		return compilationUnit.toTypeParameterDeclaration(param)
	}
	
	override setBody(CompilationStrategy compilationStrategy) {
		compilationUnit.setCompilationStrategy(delegate, compilationStrategy)
	}
	
	override addParameter(String name, TypeReference type) {
		val param = TypesFactory::eINSTANCE.createJvmFormalParameter
		param.name = name
		param.parameterType = compilationUnit.toJvmTypeReference(type)
		delegate.parameters.add(param)
		return compilationUnit.toParameterDeclaration(param)
	}
	
}

class JvmParameterDeclarationImpl extends JvmAnnotationTargetImpl<JvmFormalParameter> implements MutableParameterDeclaration {

	override getType() {
		compilationUnit.toTypeReference(delegate.parameterType)
	}
	
	override getDeclaringExecutable() {
		compilationUnit.toMemberDeclaration(delegate.eContainer as JvmMember) as MutableExecutableDeclaration
	}
	
	override setSimpleName(String name) {
		delegate.name = name
	}
	
}

class JvmMethodDeclarationImpl extends JvmExecutableDeclarationImpl<JvmOperation> implements MutableMethodDeclaration {
	
	override isAbstract() {
		delegate.isAbstract
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
//	override isOverride() {
//		throw new UnsupportedOperationException("Auto-Jvm function stub")
//	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override getReturnType() {
		compilationUnit.toTypeReference(delegate.returnType)
	}

	override setReturnType(TypeReference type) {
		delegate.setReturnType((type as TypeReferenceImpl).lightWeightTypeReference.toJavaCompliantTypeReference)
	}
	
	override setAbstract(boolean isAbstract) {
		delegate.setAbstract(isAbstract)
	}
	
	override setFinal(boolean isFinal) {
		delegate.setFinal(isFinal)
	}
	
//	override setOverride(boolean isOverride) {
//		delegate.setOverride(isOverride)
//	}
	
	override setStatic(boolean isStatic) {
		delegate.setStatic(isStatic)
	}
	
}

class JvmConstructorDeclarationImpl extends JvmExecutableDeclarationImpl<JvmConstructor> implements MutableConstructorDeclaration {
	
	override getSimpleName() {
		declaringType.simpleName
	}
	
}

class JvmFieldDeclarationImpl extends JvmMemberDeclarationImpl<JvmField> implements MutableFieldDeclaration {
	
	override getInitializer() {
		compilationUnit.toExpression(compilationUnit.jvmTypesBuilder.getExpression(delegate))
	}
	
	override setInitializer(Expression initializer) {
		if (initializer == null) {
			compilationUnit.jvmTypesBuilder.removeExistingBody(delegate)
		} else {
			compilationUnit.jvmTypesBuilder.setInitializer(delegate, (initializer as ExpressionImpl).delegate)
		}
	}
	
	override setInitializer(CompilationStrategy initializer) {
		compilationUnit.setCompilationStrategy(delegate, initializer)
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
	
	override MutableClassDeclaration getDeclaringType() {
		super.getDeclaringType() as MutableClassDeclaration
	}

	override setFinal(boolean isFinal) {
		delegate.setFinal(isFinal)
	}
	
	override setStatic(boolean isStatic) {
		delegate.setStatic(isStatic)
	}
	
	override setType(TypeReference type) {
		delegate.setType((type as TypeReferenceImpl).lightWeightTypeReference.toJavaCompliantTypeReference)
	}
	
}

class JvmTypeParameterDeclarationImpl extends TypeParameterDeclarationImpl implements MutableAnnotationTarget, MutableTypeParameterDeclaration {
	
	override MutableTypeParameterDeclarator getTypeParameterDeclarator() {
		compilationUnit.toMemberDeclaration(delegate.eContainer as JvmExecutable) as MutableTypeParameterDeclarator
	}
	
	override setSimpleName(String name) {
		delegate.name = name
	}
	
	override remove() {
		if (delegate.eContainer == null)
			return;
		delegate.eContainer.eContents.remove(delegate)
		if (delegate.eContainer != null)
			throw new IllegalStateException("Couldn't remove "+delegate)
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
	override addAnnotation(Type annotationType) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override MutableAnnotationReference findAnnotation(Type annotationType) {
		return null
	}
	
	override Iterable<? extends MutableAnnotationReference> getAnnotations() {
		return emptyList
	}
	
	override getQualifiedName() {
		delegate.identifier
	}
	
}

class JvmAnnotationTypeElementDeclarationImpl extends JvmMemberDeclarationImpl<JvmOperation> implements MutableAnnotationTypeElementDeclaration {
	
	override getDefaultValue() {
		return compilationUnit.translateAnnotationValue(delegate.defaultValue)
	}
	
	override getType() {
		compilationUnit.toTypeReference( delegate.returnType )
	}
	
	override getDefaultValueExpression() {
		return null
	}
	
}

class JvmAnnotationReferenceImpl extends AbstractElementImpl<JvmAnnotationReference> implements MutableAnnotationReference {
	
	override getAnnotationTypeDeclaration() {
		compilationUnit.toTypeDeclaration(delegate.annotation) as AnnotationTypeDeclaration
	}
	
	override getExpression(String property) {
		return null
	}
	
	override getValue(String property) {
		val annotationValue = delegate.values.findFirst[
			valueName == property || (valueName == null && property == 'value')
		]
		if (annotationValue != null)
			return compilationUnit.translateAnnotationValue(annotationValue)
		
		val op = delegate.annotation.declaredOperations.findFirst[simpleName == property]
		if (op != null && op.defaultValue != null) {
			return compilationUnit.translateAnnotationValue(op.defaultValue)
		}
		return null
	}
	
	override set(String name, String... values) {
		val newValue = TypesFactory::eINSTANCE.createJvmStringAnnotationValue
		if (name != null)
			newValue.setOperation(findOperation(name))
		newValue.values.addAll(values)
		delegate.getValues.add(newValue)
	}
	
	override set(String name, boolean... values) {
		val newValue = TypesFactory::eINSTANCE.createJvmBooleanAnnotationValue
		if (name != null)
			newValue.setOperation(findOperation(name))
		newValue.values.addAll(values)
		delegate.getValues.add(newValue)
	}
	
	override set(String name, int... values) {
		val newValue = TypesFactory::eINSTANCE.createJvmIntAnnotationValue
		if (name != null)
			newValue.setOperation(findOperation(name))
		newValue.values.addAll(values)
		delegate.getValues.add(newValue)
	}
	
	override remove(String name) {
		val found = delegate.values.findFirst[operation.simpleName==name]
		if (found != null) {
			delegate.values.remove(found)
			return true;
		}
		return false;
	}
	
	private def findOperation(String name) {
		val jvmAnnoType = (annotationTypeDeclaration as JvmAnnotationTypeDeclarationImpl).delegate
		val jvmOperation = jvmAnnoType.declaredOperations.findFirst[it.simpleName == name]
		if (jvmOperation == null) {
			throw new IllegalArgumentException("The annotation property '"+name+"' is not declared on the annotation type '"+jvmAnnoType.identifier+"'.")
		}
		return jvmOperation
	} 
}
