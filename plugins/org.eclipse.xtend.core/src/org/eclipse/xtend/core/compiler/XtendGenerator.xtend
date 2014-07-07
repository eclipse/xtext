/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.compiler

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts
import org.eclipse.xtend.core.macro.CodeGenerationContextImpl
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendGenerator extends JvmModelGenerator {
	
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)
		callMacroProcessors(input)
	}
	
	def void callMacroProcessors(Resource input) {
		val ctxs = ActiveAnnotationContexts.find(input);
		if (ctxs == null)
			return;
		try {
			ctxs.before(ActiveAnnotationContexts.AnnotationCallback.GENERATION);
			for (context : ctxs.contexts.values) {
				try {
					switch processor : context.processorInstance {
						CodeGenerationParticipant<NamedElement> : {
							val codeGenServices = new CodeGenerationContextImpl => [
								fileSystemSupport = context.compilationUnit.fileSystemSupport
								fileLocations = context.compilationUnit.fileLocations
							]
							val elements = context.annotatedSourceElements.map[context.compilationUnit.toXtendMemberDeclaration(it as XtendMember)]
							processor.doGenerateCode(elements, codeGenServices)
						}
					}
				} catch (Throwable t) {
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
			if (declaredType != null)
				b.declareVariable(declaredType, 'this');
		} else {
			if (declaredType != null)
				b.declareVariable(declaredType, 'this');
		}
	}
	
	def compileLocalTypeStubs(JvmFeature feature, ITreeAppendable appendable, GeneratorConfig config) {
		feature.localClasses.filter[ !anonymous ].forEach[
			appendable.newLine
			val anonymousClass = it.sourceElements.head as AnonymousClass
			val childAppendable = appendable.trace(anonymousClass)
			childAppendable.append('abstract class ')
			childAppendable.traceSignificant(anonymousClass).append(simpleName)
			if (typeParameters.empty)
				childAppendable.append(" ")
			generateExtendsClause(childAppendable, null)
		
			childAppendable.append('{').increaseIndentation
			
			if (needSyntheticThisVariable(anonymousClass, it)) {
				val thisName = childAppendable.declareSyntheticVariable('this' -> it, '_this' + it.simpleName)
				childAppendable.newLine.append("final ").append(simpleName).append(' ').append(thisName).append(' = this;').newLine
			}
			childAppendable.forEach(getAddedDeclarations(anonymousClass), [
					separator = [newLine]
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
						if (it.returnType == null) {
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
						type.serializeSafely("Object", tracedAppendable)
						tracedAppendable.append(" ")
						tracedAppendable.traceSignificant(it).append(simpleName)
						tracedAppendable.append(";")
					} else {
						generateMember(memberAppendable, config)
					} 
					memberAppendable.closeScope
				])
			childAppendable.decreaseIndentation.newLine.append('}')
			appendable.newLine
		]
	}
	
	private def boolean needSyntheticThisVariable(AnonymousClass anonymousClass, JvmDeclaredType localType) {
		val references = newArrayList
		try {
			val acceptor = new EcoreUtil2.ElementReferenceAcceptor() {
				override accept(EObject referrer, EObject referenced, EReference reference, int index) {
					val enclosingType = EcoreUtil2.getContainerOfType(referrer, XtendTypeDeclaration)
					if (enclosingType != null && enclosingType != anonymousClass) {
						references.add(referrer)
						throw new StopCollecting
					} else {
						val enclosingLambda = EcoreUtil2.getContainerOfType(referrer, XClosure)
						if (enclosingLambda != null && EcoreUtil.isAncestor(anonymousClass, enclosingLambda)) {
							references.add(referrer)
							throw new StopCollecting
						}
					}
				}
			}
			EcoreUtil2.findCrossReferences(anonymousClass, newImmutableSet(localType), acceptor)
		} catch(StopCollecting e) {
			// ok
		}
		
		return !references.empty
	}
	
	private static class StopCollecting extends Exception {
	}
	
	override generateVisibilityModifier(JvmMember it, ITreeAppendable result) {
		if (visibility == JvmVisibility.PRIVATE && declaringType.local) {
			if (it instanceof JvmOperation) {
				val declarator = declaringType as JvmGenericType
				if (!declarator.anonymous) {
					return result
				}
			}
		}
		super.generateVisibilityModifier(it, result)
	}
	
	override generateMembersInBody(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		if (it.local) {
			appendable.append('{').increaseIndentation
			val fieldsWithInitializer = declaredFields.filter [
				if (compilationStrategy != null) {
					return true
				} else if (compilationTemplate != null) {
					return true
				} else {
					val expression = associatedExpression
					if (expression != null && config.generateExpressions) {
						return true
					}
				}
				false
			]
			if (!fieldsWithInitializer.empty) {
				appendable.newLine.append('{').increaseIndentation
				appendable.forEach(fieldsWithInitializer, [
					separator = [ITreeAppendable it | newLine]
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
					separator = [ITreeAppendable it | newLine]
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