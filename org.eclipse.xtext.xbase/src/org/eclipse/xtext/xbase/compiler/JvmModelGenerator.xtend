/*******************************************************************************
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmByteAnnotationValue
import org.eclipse.xtext.common.types.JvmCharAnnotationValue
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmIntAnnotationValue
import org.eclipse.xtext.common.types.JvmLongAnnotationValue
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension
import org.eclipse.xtext.documentation.IFileHeaderProvider
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.trace.ITraceURIConverter
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.output.ImportingStringConcatenation
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

import static org.eclipse.xtext.common.types.TypesPackage.Literals.*
import static org.eclipse.xtext.util.JavaVersion.*
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.generator.trace.AbsoluteURI
import java.util.Map
import org.eclipse.xtext.generator.trace.SourceRelativeURI
import static com.google.common.collect.Maps.newHashMap
import org.eclipse.emf.common.util.URI

/**
 * A generator implementation that processes the 
 * derived {@link IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
class JvmModelGenerator implements IGenerator {

	@Inject protected extension ILogicalContainerProvider
	@Inject protected extension TypeReferences 
	@Inject protected extension TreeAppendableUtil
	@Inject protected extension JvmTypeExtensions
	@Inject protected extension LoopExtensions
	@Inject protected extension ErrorSafeExtensions
	
	@Inject CommonTypeComputationServices commonServices
	@Inject XbaseCompiler compiler
	@Inject ILocationInFileProvider locationProvider
	@Inject IEObjectDocumentationProvider documentationProvider
	@Inject IFileHeaderProvider fileHeaderProvider
	@Inject IJvmModelAssociations jvmModelAssociations
	@Inject JavaKeywords keywords
	@Inject IGeneratorConfigProvider generatorConfigProvider
	@Inject ITraceURIConverter converter
	@Inject IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider
	@Inject IScopeProvider scopeProvider
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (obj : input.contents) {
			obj.internalDoGenerate(fsa)
		}
	}
	
	def dispatch void internalDoGenerate(EObject obj, IFileSystemAccess fsa) {}
	
	def dispatch void internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		if (DisableCodeGenerationAdapter.isDisabled(type))
			return;
		if(type.qualifiedName !== null)
			fsa.generateFile(type.qualifiedName.replace('.', '/') + '.java', type.generateType(generatorConfigProvider.get(type)))
	}
	
	protected def createImportManager(JvmDeclaredType type) {
		new ImportManager(true, type)
	}
	
	def CharSequence generateType(JvmDeclaredType type, GeneratorConfig config) {
		val importManager = createImportManager(type)
		val bodyAppendable = createAppendable(type, importManager, config)
		bodyAppendable.openScope
		bodyAppendable.assignThisAndSuper(type, config)
		generateBody(type, bodyAppendable, config)
		bodyAppendable.closeScope
		val importAppendable = createAppendable(type, importManager, config)
		generateFileHeader(type, importAppendable, config)
		if (type.packageName !== null) {
			importAppendable.append("package ").append(type.packageName).append(";");
			importAppendable.newLine.newLine
		}
		for(i: importManager.imports) {
			importAppendable.append("import ").append(i).append(";").newLine
		}
		if (!importManager.imports.empty)
			importAppendable.newLine
		importAppendable.append(bodyAppendable)
		return importAppendable
	}
	
	
	def dispatch ITreeAppendable generateBody(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateJavaDoc(appendable, config)
		val childAppendable = appendable.trace(it)
		annotations.generateAnnotations(childAppendable, true, config)
		generateModifier(childAppendable, config)
		if (isInterface) {
			childAppendable.append("interface ")
		} else {
			childAppendable.append("class ")
		}
		childAppendable.traceSignificant(it).append(simpleName.makeJavaIdentifier)
		generateTypeParameterDeclaration(childAppendable, config)
		if (typeParameters.empty)
			childAppendable.append(" ")
		generateExtendsClause(childAppendable, config)
		generateMembersInBody(childAppendable, config)
		if(!anonymous && !(it.eContainer instanceof JvmType)) 
			appendable.newLine
	}
	
	def generateMembersInBody(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append('{').increaseIndentation
		appendable.forEach(membersToBeCompiled, [
				separator = [ITreeAppendable it | newLine]
			], [
				val memberAppendable = appendable.traceWithComments(it)
				memberAppendable.openScope
				generateMember(memberAppendable, config)
				memberAppendable.closeScope
			])
		appendable.decreaseIndentation.newLine.append('}')
	}
	
	/**
	 * @deprecated Additional annotations should be created in the JVM model.
	 */
	@Deprecated
	def generateAnnotationsWithSyntheticSuppressWarnings(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		val noSuppressWarningsFilter = [JvmAnnotationReference it | annotation?.identifier != SuppressWarnings.name]
		annotations.filter(noSuppressWarningsFilter).generateAnnotations(appendable, true, config)
		if (it.eContainer === null)
			appendable.append("@SuppressWarnings(\"all\")").newLine
	}

	def dispatch ITreeAppendable generateBody(JvmEnumerationType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateJavaDoc(appendable, config)
		val childAppendable = appendable.trace(it)
		annotations.generateAnnotations(childAppendable, true, config)
		generateModifier(childAppendable, config)
		childAppendable.append("enum ")
		childAppendable.traceSignificant(it).append(simpleName.makeJavaIdentifier)
		childAppendable.append(" ")
		generateExtendsClause(childAppendable, config)
		childAppendable.append("{").increaseIndentation
		childAppendable.forEach(literals, [
				separator = [ITreeAppendable it | append(',').newLine]  suffix = ';'
			], [
				generateEnumLiteral(childAppendable.trace(it), config)
			])
		childAppendable.forEach(membersToBeCompiled.filter[!(it instanceof JvmEnumerationLiteral)], [
				separator = [ITreeAppendable it | newLine]
			], [ 
				generateMember(childAppendable.trace(it), config)
			])
		childAppendable.decreaseIndentation.newLine.append("}")
		if(!(it.eContainer instanceof JvmType)) 
			appendable.newLine
	}
	
	def void generateEnumLiteral(JvmEnumerationLiteral it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		generateJavaDoc(appendable, config)
		annotations.generateAnnotations(appendable, true, config)
		appendable.append(simpleName.makeJavaIdentifier)
		// TODO: constructor args
	}
	
	def dispatch ITreeAppendable generateBody(JvmAnnotationType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateJavaDoc(appendable, config)
		val childAppendable = appendable.trace(it)
		annotations.generateAnnotations(childAppendable, true, config)
		generateModifier(childAppendable, config)
		childAppendable.append("@interface ")
		childAppendable.traceSignificant(it).append(simpleName.makeJavaIdentifier)
		childAppendable.append(" {")
		for (innerType: membersToBeCompiled.filter(JvmDeclaredType)) {
			val innerTypeAppendable = childAppendable.trace(innerType)
			innerTypeAppendable.increaseIndentation
			generateMember(innerType, innerTypeAppendable, config)
			innerTypeAppendable.decreaseIndentation
		}
		for (operation : membersToBeCompiled.filter(JvmOperation)) {
			generateAnnotationMethod(operation, childAppendable, config)
		}
		childAppendable.newLine.append("}")
		if(!(it.eContainer instanceof JvmType)) 
			appendable.newLine
	}
	
	def generateAnnotationMethod(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.increaseIndentation.newLine
		appendable.openScope
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, true, config)
		generateModifier(tracedAppendable, config)
		returnType.serializeSafely("Object", tracedAppendable)
		tracedAppendable.append(" ")
		tracedAppendable.traceSignificant(it).append(simpleName.makeJavaIdentifier)
		tracedAppendable.append("()")
		generateDefaultExpression(tracedAppendable, config)
		tracedAppendable.append(";")
		appendable.decreaseIndentation
		appendable.closeScope
	}

	def void generateDefaultExpression(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		if (compilationStrategy !== null) {
			appendable.append(" default ")
			appendable.increaseIndentation
			compilationStrategy.apply(appendable)
			appendable.decreaseIndentation
		} else if (compilationTemplate !== null) {
			appendable.append(" default ").increaseIndentation
			appendCompilationTemplate(appendable, it)
			appendable.decreaseIndentation
		} else if (config.generateExpressions) {
			val body = associatedExpression
			if(body !== null) {
				if(body.hasErrors()) {
					appendable.append("/* skipped default expression with errors */")
				} else {
					appendable.append(" default ")
					compiler.compileAsJavaExpression(body, appendable, returnType)
				}
			} else if (defaultValue !== null) {
				if(defaultValue.hasErrors()) {
					appendable.append("/* skipped default expression with errors */")
				} else {
					appendable.append(" default ")
					defaultValue.toJavaLiteral(appendable, config)
				}
			}
		}
	}
	
	/**
	 * @since 2.16
	 */
	protected def void appendCompilationTemplate(ITreeAppendable appendable, JvmIdentifiableElement it) {
		switch appendable {
			TreeAppendable: {
				val target = createImportingStringConcatenation(appendable.state, new StandardTypeReferenceOwner(commonServices, it));
				target.append(compilationTemplate)
				appendable.append(target)			
			} 
		default: {
			throw new IllegalStateException("unexpected appendable: " + appendable.getClass.name)
		}
		
		}
	}
	
	protected def ImportingStringConcatenation createImportingStringConcatenation(SharedAppendableState state, ITypeReferenceOwner owner) {
		return new ImportingStringConcatenation(state, owner)
	}
	
	def dispatch generateModifier(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateVisibilityModifier(it, appendable)
		if (!interface) {
			if (isStatic && !isDeclaredWithinInterface)
				appendable.append("static ")
			if (isAbstract)
				appendable.append("abstract ")
		}
		if (isFinal)
			appendable.append("final ")
		if (isStrictFloatingPoint)
			appendable.append("strictfp ")
	}
	
	def private boolean isDeclaredWithinInterface (JvmMember it) {
		return declaringType instanceof JvmGenericType && (declaringType as JvmGenericType).isInterface
	}
	
	def dispatch generateModifier(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateVisibilityModifier(it, appendable)
	}
	
	def dispatch generateModifier(JvmField it, ITreeAppendable appendable, GeneratorConfig config) {
		generateVisibilityModifier(it, appendable)
		if (isStatic)
			appendable.append("static ")
		if (isFinal)
			appendable.append("final ")
		if (isTransient)
			appendable.append("transient ")
		if (isVolatile)
			appendable.append("volatile ")
	}
		
	def dispatch generateModifier(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		generateVisibilityModifier(it, appendable)
		if (isAbstract && !isDeclaredWithinInterface)
			appendable.append("abstract ")
		if (isStatic)
			appendable.append("static ")
		if (!isAbstract && !isStatic && config.getJavaSourceVersion.isAtLeast(JAVA8)
				&& isDeclaredWithinInterface)
			appendable.append("default ")
		if (isFinal)
			appendable.append("final ")
		if (isSynchronized)
			appendable.append("synchronized ")
		if (isStrictFloatingPoint)
			appendable.append("strictfp ")
		if (isNative)
			appendable.append("native ")
	}
	
	def generateVisibilityModifier(JvmMember it, ITreeAppendable result) {
		result.append(visibility.javaName)
	}
	
	def dispatch generateModifier(JvmConstructor it, ITreeAppendable appendable, GeneratorConfig config) {
		generateVisibilityModifier(it, appendable)
	}
	
	/**
	 * Returns the visibility modifier and a space as suffix if not empty
	 */
	def javaName(JvmVisibility visibility) {
		if (visibility !== null)
			return switch visibility {
					case JvmVisibility.PRIVATE : 'private '
					case JvmVisibility.PUBLIC : 'public '
					case JvmVisibility.PROTECTED : 'protected '
					case JvmVisibility.DEFAULT : ''
				}
		else 
			return ''
	}
		
	def void generateExtendsClause(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		val implicitSuperType = switch it {
			JvmAnnotationType: 'java.lang.Annotation'
			JvmEnumerationType: "java.lang.Enum<"+identifier+">"
			default: 'java.lang.Object'
		} 
		if (it instanceof JvmAnnotationType || (it instanceof JvmGenericType && (it as JvmGenericType).isInterface)) {
			val withoutObject = superTypes.filter [ typeRef | typeRef.identifier != implicitSuperType ]
			appendable.forEachSafely(withoutObject, [
					prefix = 'extends ' separator =  ', ' suffix = ' '
				], [
					it, app | serializeSafely(app)
				])
		} else {
			val withoutObject = superTypes.filter [ typeRef | typeRef.identifier != implicitSuperType ]
			val superClazz = withoutObject.filter(typeRef | typeRef.type instanceof JvmGenericType && !(typeRef.type as JvmGenericType).isInterface).head
			val superInterfaces = withoutObject.filter(typeRef | typeRef != superClazz)
			if (superClazz !== null) {
				val hasErrors = superClazz.hasErrors()
				if(hasErrors) 
					appendable.append('/* ')
				try {
					appendable.append('extends ')
					superClazz.serializeSafely(appendable)
					appendable.append(' ')
				} catch (Exception ignoreMe) {}
				if(hasErrors) 
					appendable.append(' */')
			} 
			appendable.forEachSafely(superInterfaces, [
					prefix = 'implements ' separator = ', ' suffix = ' '
				], [
					it, app | serializeSafely(app)
				])
		}
	}
	
	def dispatch ITreeAppendable generateMember(JvmMember it, ITreeAppendable appendable, GeneratorConfig config) {
		throw new UnsupportedOperationException("generateMember not implemented for elements of type "
			+ it?.^class?.name
		)
	}
	
	def dispatch generateMember(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		appendable.openScope
		appendable.assignThisAndSuper(it, config)
		try {
			generateBody(it, appendable, config)
		} finally {
			appendable.closeScope
		}
	}
	
	def dispatch generateMember(JvmField it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, true, config)
		generateModifier(tracedAppendable, config)
		type.serializeSafely("Object", tracedAppendable)
		tracedAppendable.append(" ")
		val name = tracedAppendable.declareVariable(it, simpleName.makeJavaIdentifier)
		tracedAppendable.traceSignificant(it).append(name)
		generateInitialization(tracedAppendable, config)
		tracedAppendable.append(";")
	}
	
	def dispatch generateMember(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		appendable.openScope
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, true, config)
		generateModifier(tracedAppendable, config)
		generateTypeParameterDeclaration(tracedAppendable, config)
		if (returnType === null) {
			tracedAppendable.append("void")
		} else {
			returnType.serializeSafely("Object", tracedAppendable)
		}
		tracedAppendable.append(" ")
		tracedAppendable.traceSignificant(it).append(simpleName.makeJavaIdentifier)
		tracedAppendable.append("(")
		generateParameters(tracedAppendable, config)
		tracedAppendable.append(")")
		generateThrowsClause(tracedAppendable, config)
		if (isAbstract || !hasBody) {
			tracedAppendable.append(";")
		} else {
			tracedAppendable.append(" ")
			generateExecutableBody(tracedAppendable, config)
		}
		appendable.closeScope
		appendable
	}
	
	def dispatch generateMember(JvmConstructor it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		appendable.openScope
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, true, config)
		generateModifier(tracedAppendable, config)
		generateTypeParameterDeclaration(tracedAppendable, config)
		tracedAppendable.traceSignificant(it).append(simpleName.makeJavaIdentifier)
		tracedAppendable.append("(")
		generateParameters(tracedAppendable, config)
		tracedAppendable.append(")")
		generateThrowsClause(tracedAppendable, config)
		tracedAppendable.append(" ")
		generateExecutableBody(tracedAppendable, config)
		appendable.closeScope
		appendable
	}
	
	def void generateInitialization(JvmField it, ITreeAppendable appendable, GeneratorConfig config) {
		if (compilationStrategy !== null) {
			val errors = directErrorsOrLogicallyContainedErrors
			if (errors.isEmpty) {
				appendable.append(" = ")
				appendable.increaseIndentation
				compilationStrategy.apply(appendable)
				appendable.decreaseIndentation
			} else {
				appendable.append(" /* Skipped initializer because of errors */")
			}
		} else if (compilationTemplate !== null) {
			val errors = directErrorsOrLogicallyContainedErrors
			if (errors.isEmpty) {
				appendable.append(" = ").increaseIndentation
				appendCompilationTemplate(appendable, it)
				appendable.decreaseIndentation
			} else {
				appendable.append(" /* Skipped initializer because of errors */")
			}
		} else {
			val expression = associatedExpression
			if (expression !== null && config.generateExpressions) {
				if(expression.hasErrors()) {
					appendable.append(" /* Skipped initializer because of errors */")
				} else {
					appendable.append(" = ")
					compiler.compileAsJavaExpression(expression, appendable, type)
				}
			}
		}
	}
		
	def void generateTypeParameterDeclaration(JvmTypeParameterDeclarator it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEach(typeParameters, [
				prefix = '<' separator = ', ' suffix = '> '
			], [
				it| generateTypeParameterDeclaration(appendable, config)
			])
	}
	
	def void generateTypeParameterDeclaration(JvmTypeParameter it, ITreeAppendable appendable, GeneratorConfig config) {
		val tracedAppendable = appendable.trace(it)
		tracedAppendable.traceSignificant(it).append(name)
		generateTypeParameterConstraints(tracedAppendable, config)
	}
	
	def void generateTypeParameterConstraints(JvmTypeParameter it, ITreeAppendable appendable, GeneratorConfig config) {
		val upperBounds = constraints.filter(JvmUpperBound)
		appendable.forEachSafely(upperBounds, [
				prefix = ' extends ' separator = ' & '
			], [
				it, app | typeReference.serializeSafely(app)
			])
	}
	
	def void generateThrowsClause(JvmExecutable it, ITreeAppendable appendable, GeneratorConfig config) {
		val toBeGenerated = <JvmType, JvmTypeReference> newLinkedHashMap
		exceptions.forEach[if(!toBeGenerated.containsKey(type)) toBeGenerated.put(type, it)]
		appendable.forEachSafely(toBeGenerated.values, [
				prefix = ' throws ' separator = ', '
			], [
				it, app |  app.trace(it).append(it.type)
			])
	}
	
	def void generateParameters(JvmExecutable it, ITreeAppendable appendable, GeneratorConfig config) {
		if (!parameters.isEmpty) {
			for (i : 0 .. parameters.size - 1) {
				val last = i + 1 == parameters.size
				val p = parameters.get(i)
				p.generateParameter(appendable, last && it.varArgs, config)
				if (!last)
					appendable.append(", ")
			}
		}
	}
	
	def void generateParameter(JvmFormalParameter it, ITreeAppendable appendable, boolean vararg, GeneratorConfig config) {
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, false, config)
		tracedAppendable.append("final ")
		if (vararg) {
			if (! (parameterType instanceof JvmGenericArrayTypeReference)) {
				tracedAppendable.append("/* Internal Error: Parameter was vararg but not an array type. */");
			} else {
				(parameterType as JvmGenericArrayTypeReference).componentType.serializeSafely("Object", tracedAppendable)
			}
			tracedAppendable.append("...")
		} else {
			parameterType.serializeSafely("Object", tracedAppendable)
		}
		tracedAppendable.append(" ")
		val name = tracedAppendable.declareVariable(it, makeJavaIdentifier(simpleName))
		tracedAppendable.traceSignificant(it).append(name)
	}
	
	def hasBody(JvmExecutable it) {
		compilationTemplate !== null || compilationStrategy !== null || associatedExpression !== null
	}
	
	/**
	 * Returns the errors that are produced for elements that are directly contained
	 * in this feature (e.g. unresolved type proxies) or that are associated with
	 * the expression that may be logically contained in the given feature.
	 */
	private def getDirectErrorsOrLogicallyContainedErrors(JvmFeature feature) {
		var errors = feature.errors
		if(errors.empty) {
			val expression = feature.associatedExpression
			if (expression !== null) {
				errors = expression.errors
			}
		}
		return errors
	}

	def void generateExecutableBody(JvmExecutable op, ITreeAppendable appendable, GeneratorConfig config) {
		if (op.compilationStrategy !== null) {
			var errors = op.directErrorsOrLogicallyContainedErrors
			if(errors.empty) {
				appendable.increaseIndentation.append("{").newLine
				op.compilationStrategy.apply(appendable)
				appendable.decreaseIndentation.newLine.append("}")
			} else {
				op.generateBodyWithIssues(appendable, errors)
			}
		} else if (op.compilationTemplate !== null) {
			val errors = op.directErrorsOrLogicallyContainedErrors
			if(errors.empty) {
				appendable.increaseIndentation.append("{").newLine
				appendCompilationTemplate(appendable, op)
				appendable.decreaseIndentation.newLine.append("}")
			} else {
				op.generateBodyWithIssues(appendable, errors)
			}
		} else {
			val expression = op.getAssociatedExpression
			if (expression !== null && config.generateExpressions) {
				val errors = expression.errors
				if(errors.empty) {
					val returnType = switch(op) { 
						JvmOperation: op.returnType
						JvmConstructor: Void.TYPE.getTypeForName(op) 
						default: null
					}
					appendable.append("{").increaseIndentation
					compile(op, expression, returnType, appendable, config)
					appendable.decreaseIndentation.newLine.append("}")
				} else {
					op.generateBodyWithIssues(appendable, errors)
				}
			} else if(op instanceof JvmOperation) {
				appendable.increaseIndentation.append("{").newLine
				appendable.append('throw new UnsupportedOperationException("')
				appendable.append(op.simpleName)
				appendable.append(' is not implemented");')
				appendable.decreaseIndentation.newLine.append("}")
			} else if (op instanceof JvmConstructor) {
				appendable.append("{").newLine.append("}")
			}
		}
	}
	
	def compile(JvmExecutable executable, XExpression expression, JvmTypeReference returnType, ITreeAppendable appendable, GeneratorConfig config) {
		compiler.compile(expression, appendable, returnType, executable.exceptions.toSet)
	}

	def void assignThisAndSuper(ITreeAppendable b, JvmDeclaredType declaredType, GeneratorConfig config) {
		b.reassignSuperType(declaredType, config)
		b.reassignThisType(declaredType)
	}
	
	private def reassignSuperType(ITreeAppendable b, JvmDeclaredType declaredType, GeneratorConfig config) {
		val superType = declaredType.extendedClass?.type
		if (b.hasObject('super')) {
			/*
			 * class A {}
			 * class B extends A { B.super.toString() }
			 * B.super resolves to A though the name is computed from the current 'this'
			 */
			val element = b.getObject('this') // if we have a super, there must be a 'this'
			if (element instanceof JvmDeclaredType) {
				val superElement = b.getObject('super')
				// Don't reassign the super of the enclosing type if it has already been reassigned
				val superVariable = b.getName(superElement)
				if ('super'.equals(superVariable)) {
					val proposedName = element.simpleName + '.super'
					b.declareVariable(superElement, proposedName)
				}
			}
		}
		if (config.getJavaSourceVersion.isAtLeast(JAVA8)) {
			for (JvmTypeReference interfaceRef : declaredType.extendedInterfaces) {
				val interfaze = interfaceRef.type
				val simpleVarName = interfaze.simpleName + '.super'
				if (b.hasObject(simpleVarName)) {
					val element = b.getObject(simpleVarName)
					if (element != interfaceRef) {
						// This can happen when the type extends multiple interfaces with the same simple name
						val qualifiedVarName = interfaze.qualifiedName + '.super'
						b.declareVariable(interfaze, qualifiedVarName)
					}
				} else {
					b.declareVariable(interfaze, simpleVarName)
				}
			}
		}
		if (superType !== null)
			b.declareVariable(superType, 'super');
	}
	
	protected def reassignThisType(ITreeAppendable b, JvmDeclaredType declaredType) {
		if (b.hasObject('this')) {
			val element = b.getObject('this')
			if (element instanceof JvmDeclaredType) {
				if (element.local) {
					b.declareVariable(element, '')
				} else {
					val proposedName = element.simpleName+'.this'
					b.declareVariable(element, proposedName)
				}
			}
		}
		if (declaredType !== null)
			b.declareVariable(declaredType, 'this');
	}
	
	/**
	 * @since 2.16
	 */
	def generateBodyWithIssues(JvmExecutable op, ITreeAppendable appendable, Iterable<Issue> errors) {
		generateBodyWithIssues(appendable, errors)
	}
	
	def generateBodyWithIssues(ITreeAppendable appendable, Iterable<Issue> errors) {
		appendable.append('{').increaseIndentation.newLine
			.append('throw new Error("Unresolved compilation problems:"')
		appendable.increaseIndentation
		errors.forEach[appendable.newLine.append('+ "\\n').append(doConvertToJavaString(message)).append('"')]
		appendable.append(');').decreaseIndentation.decreaseIndentation.newLine
			.append('}')
	}
	
	/**
	 * Convert a given input string to a Java string. Non-ascii characters will
	 * be replaced by a unicode escape sequence by default.
	 */
	protected def doConvertToJavaString(String input) {
		Strings.convertToJavaString(input, true)
	}
	
	def void generateFileHeader(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		val fileHeaderAdapter = it.eAdapters.filter(FileHeaderAdapter).head
		if (fileHeaderAdapter !== null && !fileHeaderAdapter.headerText.nullOrEmpty) {
			generateDocumentation(fileHeaderAdapter.headerText, fileHeaderProvider.getFileHeaderNodes(eResource),
				appendable, config)
		}
	}

	def void generateJavaDoc(EObject it, ITreeAppendable appendable, GeneratorConfig config) {
		val adapter = it.eAdapters.filter(DocumentationAdapter).head
		if(adapter !== null && !adapter.documentation.nullOrEmpty) {
			// TODO we should track the source of the documentation in the documentation adapter
			val sourceElements = it.sourceElements
			if (sourceElements.size == 1 && documentationProvider instanceof IEObjectDocumentationProviderExtension) {
				val documentationNodes = (documentationProvider as IEObjectDocumentationProviderExtension).getDocumentationNodes(sourceElements.head)
				addJavaDocImports(appendable, documentationNodes)
				generateDocumentation(adapter.documentation, documentationNodes, appendable, config)
			} else {
				generateDocumentation(adapter.documentation, emptyList, appendable, config)
			}
		}
	} 
	
	def addJavaDocImports(EObject it, ITreeAppendable appendable,List<INode> documentationNodes) {
		for(node : documentationNodes){
			for(region : javaDocTypeReferenceProvider.computeTypeRefRegions(node)) {
				val text = region.text
				if(text !== null && text.length > 0){
					val fqn = qualifiedNameConverter.toQualifiedName(text)
					val context = NodeModelUtils.findActualSemanticObjectFor(node)
					if(fqn.segmentCount == 1 && context !== null){
						val scope = scopeProvider.getScope(context, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
						val candidate = scope.getSingleElement(fqn)
						if(candidate !== null) {
							val jvmType = 	(
											if(candidate.EObjectOrProxy.eIsProxy)
												EcoreUtil.resolve(candidate.EObjectOrProxy, context)
											else
												candidate.EObjectOrProxy
											) as JvmType
							if(jvmType instanceof JvmDeclaredType && !jvmType.eIsProxy) {
								val referencedType = jvmType as JvmDeclaredType
								val contextDeclarator = EcoreUtil2.getContainerOfType(it,JvmDeclaredType)
								if(referencedType.packageName != contextDeclarator.packageName){
									val importManager = getImportManager(appendable)
									importManager.addImportFor(jvmType)
								}
							}
						}
					}
				}
			}
		}
	}

	def getImportManager(ITreeAppendable appendable) {
		val stateField = appendable.getClass.getDeclaredField("state")
		stateField.setAccessible(true)
		val stateValue = stateField.get(appendable)
		val importManagerField = stateValue.getClass.getDeclaredField("importManager")
		importManagerField.setAccessible(true)
		importManagerField.get(stateValue) as ImportManager
	}

	def protected generateDocumentation(String text, List<INode> documentationNodes, ITreeAppendable appendable, GeneratorConfig config) {
		val doc = new StringConcatenation
			doc.append("/**")
			doc.newLine
			doc.append(" * ")
			doc.append(text, " * ")
			doc.newLine
			doc.append(" */")
		if (!documentationNodes.empty) {
			var documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION
			for(node: documentationNodes) {
				documentationTrace = documentationTrace.merge(node.textRegionWithLineInformation) 
			}
			appendable.trace(new LocationData(documentationTrace, null)).append(doc.toString)
			appendable.newLine

		} else {
			appendable.append(doc.toString).newLine
		}
	}
	
	def void generateAnnotations(Iterable<JvmAnnotationReference> annotations, ITreeAppendable appendable, boolean withLineBreak, GeneratorConfig config) {
		val sep = [ITreeAppendable it |  if(withLineBreak) newLine else append(' ') ]
		appendable.forEachSafely(annotations, [
				separator = sep suffix = sep
			], [
				it, app | it.generateAnnotation(app, config)
			])
	}

	def void generateAnnotation(JvmAnnotationReference it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append("@")
		appendable.append(annotation)
		appendable.forEach(explicitValues, [
				prefix = '(' separator = ', ' suffix = ')'
			], [
				toJava(appendable, config)
			])
	}
	 
	def void toJava(JvmAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		if (operation !== null) {
			if (operation.simpleName === null) {
				return
			}
			appendable.append(operation.simpleName);
			appendable.append(" = ")
		} else if ((eContainer as JvmAnnotationReference).explicitValues.size > 1) { // more than one value
			appendable.append("value = ")
		}
		toJavaLiteral(appendable, config)
	}
		
	def dispatch void toJavaLiteral(JvmAnnotationAnnotationValue value, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(value.values, [generateAnnotation(appendable, config)])
	}
		
	def dispatch void toJavaLiteral(JvmShortAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmIntAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmLongAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmByteAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmDoubleAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(
				switch(it) {
					case Double.isNaN(it) : "Double.NaN"
					case Double.POSITIVE_INFINITY : "Double.POSITIVE_INFINITY" 
					case Double.NEGATIVE_INFINITY : "Double.NEGATIVE_INFINITY"
					default: toString + "d" 
				})
		])
	}
	
	def dispatch void toJavaLiteral(JvmFloatAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(
				switch(it) {
					case Float.isNaN(it) : "Float.NaN"
					case Float.POSITIVE_INFINITY : "Float.POSITIVE_INFINITY" 
					case Float.NEGATIVE_INFINITY : "Float.NEGATIVE_INFINITY"
					default: toString + "f" 
				})
		])
	}
	
	def dispatch void toJavaLiteral(JvmCharAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append("'" + doConvertToJavaString(toString) + "'")
		])
	}
		
	def dispatch void toJavaLiteral(JvmStringAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append('"' + doConvertToJavaString(toString) + '"')
		])
	}
		
	def dispatch void toJavaLiteral(JvmTypeAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(type).append(".class")
		])
	} 
	
	def dispatch void toJavaLiteral(JvmEnumAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(declaringType)
			appendable.append(".")
			appendable.append(simpleName.makeJavaIdentifier)
		])
	} 
		
	def dispatch void toJavaLiteral(JvmBooleanAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(toString)			
		])
	} 
	
	def dispatch void toJavaLiteral(JvmCustomAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		if(values.isEmpty)
			appendable.append('{}')
		else 
			appendable.forEachWithShortcut(values.filter(XExpression), [
				compiler.toJavaExpression(it, appendable)
			])
	}
		
	def TreeAppendable createAppendable(EObject context, ImportManager importManager, GeneratorConfig config) {
		val cachingConverter = new ITraceURIConverter() {
			
			Map<URI, SourceRelativeURI> uriForTraceCache = newHashMap();
			
			override SourceRelativeURI getURIForTrace(IProjectConfig config, AbsoluteURI uri) {
				if (!uriForTraceCache.containsKey(uri.getURI)) {
					val result = converter.getURIForTrace(config, uri);
					uriForTraceCache.put(uri.getURI, result);
				}
				return uriForTraceCache.get(uri.getURI);
			}

			override SourceRelativeURI getURIForTrace(Resource resource) {
				if (!uriForTraceCache.containsKey(resource.getURI)) {
					val result = converter.getURIForTrace(resource);
					uriForTraceCache.put(resource.getURI, result);
				}
				return uriForTraceCache.get(resource.getURI);
			}
			
		}
		val appendable = new TreeAppendable(importManager, cachingConverter, locationProvider, jvmModelAssociations, context, "  ", "\n")
		appendable.state.generatorConfig = config
		return appendable
	}
	
	def JvmGenericType containerType(EObject context) {
		if(context === null) 
			null
		else if(context instanceof JvmGenericType)
			context
		else containerType(context.eContainer)
	}
	
	def protected String makeJavaIdentifier(String name) {
		if (name === null) {
			return "__unknown__";
		} else if (keywords.isJavaKeyword(name)) {
			name+"_"
		} else {
			name
		}
	}
	
	def dispatch Iterable<JvmMember> getMembersToBeCompiled(JvmEnumerationType type) {
		val syntheticEnumMethods = #{ type.identifier + "." + 'valueOf(java.lang.String)', type.identifier + "." + 'values()' }
		type.members.filter[
			!(it instanceof JvmOperation && syntheticEnumMethods.contains(identifier))  
		]
	}

	def dispatch Iterable<JvmMember> getMembersToBeCompiled(JvmDeclaredType it) {
		members.filter[
			!(it instanceof JvmConstructor && (it as JvmConstructor).singleSyntheticDefaultConstructor)
		]
	}
	
	def dispatch Iterable<JvmMember> getMembersToBeCompiled(JvmGenericType it) {
		if (it.anonymous) {
			members.filter[
				!(it instanceof JvmConstructor)
			]
		} else {
			_getMembersToBeCompiled(it as JvmDeclaredType)
		}
	}
	
	protected def getSourceElements(EObject jvmElement) {
		return jvmModelAssociations.getSourceElements(jvmElement)
	}
}
