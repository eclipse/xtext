/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.compiler

import com.google.common.collect.Lists
import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts
import org.eclipse.xtend.core.macro.CodeGenerationContextImpl
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendGenerator extends JvmModelGenerator implements IGenerator2 {
	
	@Inject IBatchTypeResolver typeResolver;
	@Inject OperationCanceledManager operationCanceledManager

	@Inject ElementIssueProvider.Factory issueProviderFactory
	
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)
		callMacroProcessors(input)
	}
	
	override beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		issueProviderFactory.attachData(input)
	}
	
	override afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		issueProviderFactory.detachData(input)
	}
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		doGenerate(input, fsa as IFileSystemAccess)
	}
	
	def void callMacroProcessors(Resource input) {
		val ctxs = ActiveAnnotationContexts.find(input);
		if (ctxs === null)
			return;
		try {
			ctxs.before(ActiveAnnotationContexts.AnnotationCallback.GENERATION);
			for (context : ctxs.contexts.values) {
				try {
					switch processor : context.processorInstance {
						CodeGenerationParticipant<NamedElement> : {
							val codeGenServices = new CodeGenerationContextImpl => [
								unit = context.compilationUnit
							]
							val elements = context.annotatedSourceElements.map[context.compilationUnit.toXtendMemberDeclaration(it as XtendMember)]
							processor.doGenerateCode(elements, codeGenServices)
						}
					}
				} catch (Throwable t) {
					operationCanceledManager.propagateAsErrorIfCancelException(t)
					context.handleProcessingError(input, t)
				}
			}
		} finally {
			ctxs.after(ActiveAnnotationContexts.AnnotationCallback.GENERATION);
		}
	}
	
	override protected createImportingStringConcatenation(SharedAppendableState state, ITypeReferenceOwner owner) {
		new MacroAwareStringConcatenation(state, owner)
	}
	
	/**
	 * Convert a given input string to a Java string.
	 * 
	 * Unicode escaping is handled by the {@link UnicodeAwarePostProcessor}.
	 */
	override doConvertToJavaString(String input) {
		Strings.convertToJavaString(input, false)
	}
	
	override protected _getMembersToBeCompiled(JvmGenericType it) {
		if (it.local) {
			members.filter[
				it instanceof JvmOperation
			]
		} else {
			_getMembersToBeCompiled(it as JvmDeclaredType)
		}
	}
	
	def protected getAddedDeclarations(JvmGenericType it, AnonymousClass anonymousClass) {
		val result = <JvmMember>newArrayList
		val constructor = anonymousClass.constructorCall.constructor
		if (constructor.parameters.size >= 1)
			result.add(0, constructor)
		result += declaredFields
		result += declaredOperations.filter [
			val function = sourceElements.head as XtendFunction
			return !function.override
		]
		result += members.filter(JvmDeclaredType)
		return result
	}
	
	override compile(JvmExecutable executable, XExpression expression, JvmTypeReference returnType, ITreeAppendable appendable, GeneratorConfig config) {
		compileLocalTypeStubs(executable, appendable, config)
		super.compile(executable, expression, returnType, appendable, config)
	}
	
	override reassignThisType(ITreeAppendable b, JvmDeclaredType declaredType) {
		if (b.hasObject('this')) {
			val element = b.getObject('this')
			if (element instanceof JvmDeclaredType) {
				if (element.local) {
					if (b.hasName('this'->element)) {
						b.declareVariable(element, b.getName('this'->element))
					} else {
						b.declareVariable(element, '')
					}
				} else {
					val proposedName = element.simpleName+'.this'
					b.declareVariable(element, proposedName)
				}
			}
		}
		if (declaredType !== null)
			b.declareVariable(declaredType, 'this');
	}
	
	def compileLocalTypeStubs(JvmFeature feature, ITreeAppendable appendable, GeneratorConfig config) {
		feature.localClasses.filter[ !anonymous ].forEach[
			appendable.newLine
			val anonymousClass = sourceElements.head as AnonymousClass
			val childAppendable = appendable.trace(anonymousClass)
			childAppendable.append('abstract class ')
			childAppendable.traceSignificant(anonymousClass).append(simpleName)
			if (typeParameters.empty)
				childAppendable.append(" ")
			generateExtendsClause(childAppendable, null)
		
			childAppendable.append('{').increaseIndentation
			
			if (needSyntheticThisVariable(anonymousClass, it)) {
				val thisName = childAppendable.declareSyntheticVariable('this' -> it, '_this' + it.simpleName)
				childAppendable.newLine.append("final ").append(simpleName).append(' ').append(thisName).append(' = this;')
				// avoid generating empty lines with just two spaces
				// https://github.com/eclipse/xtext-extras/issues/772
				childAppendable.blankLine
			}
			childAppendable.forEach(getAddedDeclarations(anonymousClass), [
					separator = memberSeparator()
				], [
					val memberAppendable = childAppendable.traceWithComments(it)
					memberAppendable.openScope
					if (it instanceof JvmOperation) {
						val tracedAppendable = childAppendable.trace(it)
						tracedAppendable.newLine
						generateJavaDoc(tracedAppendable, config)
						generateVisibilityModifier(tracedAppendable)
						tracedAppendable.append('abstract ')
						generateTypeParameterDeclaration(tracedAppendable, null)
						if (it.returnType === null) {
							tracedAppendable.append("void")
						} else {
							it.returnType.serializeSafely("Object", tracedAppendable)
						}
						tracedAppendable.append(" ")
						tracedAppendable.traceSignificant(it).append(simpleName)
						tracedAppendable.append("(")
						generateParameters(tracedAppendable, null)
						tracedAppendable.append(")")
						generateThrowsClause(tracedAppendable, null)
						tracedAppendable.append(";")
					} else if (it instanceof JvmField) {
						val tracedAppendable = childAppendable.trace(it)
						tracedAppendable.newLine
						generateJavaDoc(tracedAppendable, config)
						annotations.generateAnnotations(tracedAppendable, true, config)
						if (isStatic)
							tracedAppendable.append("static ")
						if (isFinal && isStatic)
							tracedAppendable.append("final ")
						if (isTransient)
							tracedAppendable.append("transient ")
						if (isVolatile)
							tracedAppendable.append("volatile ")
						type.serializeSafely("Object", tracedAppendable)
						tracedAppendable.append(" ")
						tracedAppendable.traceSignificant(it).append(simpleName)
						if (isFinal && isStatic) {
							if (constantValue !== null) {
								tracedAppendable.append(" = ")
								generateJavaConstant(constantValue, tracedAppendable)
							} else {
								generateInitialization(tracedAppendable, config)
							}
						}
						tracedAppendable.append(";")
					} else {
						generateMember(memberAppendable, config)
					} 
					memberAppendable.closeScope
				])
			childAppendable.decreaseIndentation.newLine.append('}')
			// avoid generating empty lines with just two spaces
			// https://github.com/eclipse/xtext-extras/issues/772
			appendable.blankLine
		]
	}
	
	private def generateJavaConstant(Object value, ITreeAppendable appendable) {
		if (value instanceof Float)
			appendable.append(value.toString).append('f')
		else if (value instanceof Long)
			appendable.append(value.toString).append('l')
		else if (value instanceof Character)
			appendable.append(Integer.toString(value.charValue))
		else if (value instanceof CharSequence)
			appendable.append('"').append(doConvertToJavaString(value.toString)).append('"')
		else if (value instanceof Number || value instanceof Boolean)
			appendable.append(value.toString)
		else
			appendable.append('null /* ERROR: illegal constant value */')
	}
	
	private def boolean needSyntheticThisVariable(AnonymousClass anonymousClass, JvmDeclaredType localType) {
		val references = Lists.newArrayListWithCapacity(1)
		try {
			EcoreUtil2.findCrossReferences(anonymousClass, newImmutableSet(localType), [
					referrer, referenced, reference, index |
				if (referrer.eContainer instanceof XAbstractFeatureCall) {
					val containingFeature = referrer.eContainer as XAbstractFeatureCall
					if (containingFeature.actualReceiver == referrer && containingFeature.feature instanceof JvmMember
							&& !isVisible(containingFeature.feature as JvmMember, localType)) {
						// We reference a feature that would not be visible if accessed through a synthetic _this variable
						references.clear
						throw new StopCollecting
					}
				}
				val enclosingType = EcoreUtil2.getContainerOfType(referrer, XtendTypeDeclaration)
				if (enclosingType !== null && enclosingType != anonymousClass) {
					if (references.empty)
						references.add(referrer)
					return
				}
				val enclosingLambda = EcoreUtil2.getContainerOfType(referrer, XClosure)
				if (enclosingLambda !== null && EcoreUtil.isAncestor(anonymousClass, enclosingLambda)) {
					if (references.empty)
						references.add(referrer)
				}
			])
		} catch(StopCollecting e) {
			// ok
		}
		
		return !references.empty
	}
	
	/**
	 * Determine whether the given member is visible without considering the class hierarchy.
	 */
	private def isVisible(JvmMember member, JvmDeclaredType context) {
		val visibility = member.visibility
		if (visibility == JvmVisibility.PUBLIC)
			return true
		val type = if (member instanceof JvmDeclaredType) member else member.declaringType
		if (type == context || EcoreUtil.isAncestor(context, type))
			return true
		if (type !== null && (visibility == JvmVisibility.DEFAULT || visibility == JvmVisibility.PROTECTED)) {
			if (Strings.isEmpty(context.packageName) && Strings.isEmpty(type.packageName)
					|| context.packageName == type.packageName)
				return true
		}
	}
	
	private static class StopCollecting extends Exception {
		static final long serialVersionUID=-6188090786919774877L
	}
	
	override generateVisibilityModifier(JvmMember it, ITreeAppendable result) {
		if (visibility == JvmVisibility.PRIVATE) {
			if (declaringType === null) {
				return result
			}
			if (declaringType.local && it instanceof JvmOperation) {
				val declarator = declaringType as JvmGenericType
				if (!declarator.anonymous) {
					return result
				}
			}
		} else if (visibility == JvmVisibility.PUBLIC) {
			if (declaringType instanceof JvmGenericType && (declaringType as JvmGenericType).isInterface) {
				return result
			}
		}
		super.generateVisibilityModifier(it, result)
	}
	
	override generateMembersInBody(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		if (it.local) {
			appendable.append('{').increaseIndentation
			val anonymousClass = sourceElements.head as AnonymousClass
			if (!appendable.hasName('this' -> it) && needSyntheticThisVariable(anonymousClass, it)) {
				val resolvedTypes = typeResolver.resolveTypes(anonymousClass)
				val actualType = resolvedTypes.getActualType(anonymousClass)
				val thisName = appendable.declareSyntheticVariable('this' -> it, '_this')
				appendable.newLine.append("final ").append(actualType).append(' ').append(thisName).append(' = this;')
			}
			val fieldsWithInitializer = declaredFields.filter [
				if (compilationStrategy !== null) {
					return true
				} else if (compilationTemplate !== null) {
					return true
				} else if (!(isFinal && isStatic)) {
					val expression = associatedExpression
					if (expression !== null && config.generateExpressions) {
						return true
					}
				}
				false
			]
			if (!fieldsWithInitializer.empty) {
				appendable.newLine.append('{').increaseIndentation
				appendable.forEach(fieldsWithInitializer, [
					separator = memberSeparator()
				], [
					val memberAppendable = appendable.traceWithComments(it)
					memberAppendable.openScope
					appendable.newLine
					val tracedAppendable = appendable.trace(it)
					tracedAppendable.traceSignificant(it).append(simpleName)
					generateInitialization(tracedAppendable, config)
					tracedAppendable.append(";")

					memberAppendable.closeScope
				])
				appendable.decreaseIndentation.newLine.append('}')
			}
			appendable.forEach(membersToBeCompiled, [
					separator = memberSeparator()
				], [
					val memberAppendable = appendable.traceWithComments(it)
					memberAppendable.openScope
					generateMember(memberAppendable, config)
					memberAppendable.closeScope
				])
			appendable.decreaseIndentation.newLine.append('}')
		} else {
			super.generateMembersInBody(it, appendable, config)
		}
		
	}
	
}