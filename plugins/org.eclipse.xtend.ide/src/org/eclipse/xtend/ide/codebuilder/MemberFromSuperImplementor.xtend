package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.AnnotationLookup
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedExecutable
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration

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
		if(!overriddenOperation.declaration.abstract)
			methodBuilder.body = '''super.«
				FOR typeParam: overriddenOperation.resolvedTypeParameters BEFORE '<' SEPARATOR ',' AFTER '>'»«
					typeParam.simpleName»«
				ENDFOR
				»«overriddenOperation.declaration.simpleName»(«overriddenOperation.declaration.parameters.map[simpleName].join(', ')»)'''
		if(methodBuilder.isValid)
			methodBuilder.build(appendable)
	}

	def void appendConstructorFromSuper(XtendClass overrider, IResolvedConstructor superConstructor, ISourceAppender appendable) {
		// TODO type parameters
		val inferredType = associations.getInferredType(overrider)
		val constructorBuilder = codeBuilderFactory.createConstructorBuilder(inferredType)
		initializeExecutableBuilder(constructorBuilder, inferredType, superConstructor)
		constructorBuilder.body = if(superConstructor.resolvedParameterTypes.empty) 
				'' 
			else 
				'''super(«superConstructor.declaration.parameters.map[simpleName].join(', ')»)'''
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
			parameterBuilder.extensionFlag = annotationLookup.findAnnotation(declaredParameter, Extension) != null
		]
		builder.varArgsFlag = executable.varArgs
		builder.exceptions = overridden.resolvedExceptions
	}
	
}
