/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.AnnotationLookup
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedExecutable
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.common.types.JvmType

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class MemberFromSuperImplementor {
	
	@Inject IXtendJvmAssociations associations

	@Inject CodeBuilderFactory codeBuilderFactory

	@Inject AnnotationLookup annotationLookup 

	@Inject extension TypesFactory typesFactory

	def void appendOverrideFunction(XtendTypeDeclaration overrider, IResolvedOperation overriddenOperation, ISourceAppender appendable) {
		val inferredType = associations.getInferredType(overrider)
		val methodBuilder = codeBuilderFactory.createMethodBuilder(inferredType)
		initializeExecutableBuilder(methodBuilder, inferredType, overriddenOperation)
		methodBuilder.overrideFlag = true
		methodBuilder.methodName = overriddenOperation.declaration.simpleName
		methodBuilder.returnType = overriddenOperation.resolvedReturnType
		if (overriddenOperation.declaration.synchronized) {
			methodBuilder.synchronizedFlag = true
		}
		if(!overriddenOperation.resolvedTypeParameters.empty) {
			val typeParameters = newArrayList
			overriddenOperation.resolvedTypeParameters.forEach [ typeParam, idx |
				val newTypeParam = createJvmTypeParameter
				newTypeParam.name = typeParam.name
				overriddenOperation.getResolvedTypeParameterConstraints(idx).forEach[
					val upperBound = createJvmUpperBound
					upperBound.typeReference = it.toJavaCompliantTypeReference
					newTypeParam.constraints += upperBound
				]
				typeParameters.add(newTypeParam)
			]
			methodBuilder.typeParameters = typeParameters
		}
		if(!overriddenOperation.declaration.abstract) {
			val body = '''super.«
				FOR typeParam: overriddenOperation.resolvedTypeParameters BEFORE '<' SEPARATOR ', ' AFTER '>'»«
					typeParam.simpleName»«
				ENDFOR
				»«overriddenOperation.declaration.simpleName»(«overriddenOperation.declaration.parameters.map[simpleName].join(', ')»)'''
			val superTypeRef = getImplementedInterface(inferredType, overriddenOperation.declaration.declaringType)
			methodBuilder.bodyGenerator = [
				superTypeRef?.apply(it)
				append(body)
			] 
		}
		if(methodBuilder.isValid)
			methodBuilder.build(appendable)
	}
	
	private def (ISourceAppender)=>void getImplementedInterface(JvmDeclaredType subType, JvmDeclaredType superInterface) {
		if (superInterface instanceof JvmGenericType && (superInterface as JvmGenericType).isInterface) {
			if (subType.superTypes.exists[type == superInterface]) {
				return [append(superInterface).append('.')]
			}
			val interfaze = subType.superTypes.filter[type.isInterface].map[type as JvmDeclaredType]
				.findFirst[getImplementedInterface(superInterface) !== null]
			if (interfaze !== null) {
				return [append(interfaze).append('.')]
			}
		}
	}

	private def isInterface(JvmType type) {
		type instanceof JvmGenericType && (type as JvmGenericType).isInterface
	}

	def void appendConstructorFromSuper(XtendClass overrider, IResolvedConstructor superConstructor, ISourceAppender appendable) {
		// TODO type parameters
		val inferredType = associations.getInferredType(overrider)
		val constructorBuilder = codeBuilderFactory.createConstructorBuilder(inferredType)
		initializeExecutableBuilder(constructorBuilder, inferredType, superConstructor)
		constructorBuilder.bodyGenerator = [
			if (!superConstructor.resolvedParameterTypes.empty) 
				append('''super(«superConstructor.declaration.parameters.map[simpleName].join(', ')»)''')
		]
		if(constructorBuilder.isValid)
			constructorBuilder.build(appendable)
	}
	
	protected def initializeExecutableBuilder(AbstractExecutableBuilder builder, JvmDeclaredType overrider, IResolvedExecutable overridden) {
		val executable = overridden.declaration
		builder.context = overrider
		builder.visibility = overridden.declaration.visibility
		overridden.resolvedParameterTypes.forEach [it, index |
			val declaredParameter = executable.parameters.get(index)
			val parameterBuilder = builder.newParameterBuilder
			parameterBuilder.name = declaredParameter.simpleName
			parameterBuilder.type = it
			parameterBuilder.extensionFlag = annotationLookup.findAnnotation(declaredParameter, Extension) !== null
		]
		builder.varArgsFlag = executable.varArgs
		builder.exceptions = overridden.resolvedExceptions
	}
	
}
