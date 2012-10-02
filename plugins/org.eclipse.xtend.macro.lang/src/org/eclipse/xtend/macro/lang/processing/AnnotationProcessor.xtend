/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.macro.lang.processing

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.macro.lang.MacroAnnotationExtensions
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation
import org.eclipse.xtend.macro.lang.macro.TargetType
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation

/**
 * The annotation processor is registered with the compilation-particpant extenions point
 * and is called during model inference of Xtend files.
 * 
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
public class AnnotationProcessor implements IJvmModelInferrer {
	
	override hashCode() {
		getClass.hashCode
	}
	
	override equals(Object obj) {
		if (obj?.getClass == this.getClass) {
			return true
		}
		super.equals(obj)
	}
	
	static val LOG = Logger::getLogger(typeof(AnnotationProcessor))
	
	@Inject IJvmModelAssociator associator
	@Inject MacroInterpreter interpreter
	@Inject Provider<ProcessingContextImpl> processingContextProvider
	@Inject Provider<RegistrationContextImpl> registratorContextProvider
	@Inject JvmTypesBuilder jvmTypesBuilder

	@Inject extension XAnnotationExtensions
	@Inject extension MacroAnnotationExtensions

	/**
	 * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
	 */
	override infer(EObject e, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		switch e {
			XtendFile : {
				
				// lookup all elements annotated with a macro annotation
				val Map<MacroAnnotation, List<XtendAnnotationTarget>> annotatedElements = newHashMap
				searchAnnotatedElements(e) [
					if (!annotatedElements.containsKey(key)) {
						annotatedElements.put(key, newArrayList)
					}
					annotatedElements.get(key) += value
				]
				
				// exit if no macro annotations are used
				if (annotatedElements.empty)
					return;
				
				// do the processing
				invokeRegistrators(e, annotatedElements, acceptor, CancelIndicator::NullImpl)
				if (!preIndexingPhase) {
					invokeProcessors(e, annotatedElements, CancelIndicator::NullImpl)
				}
			} 
			default: 
				LOG.error("Couldn't handle invocation for "+e)
		}
	}
	
	/**
	 * recursively looks for macro annotations on XtendAnnotationTargets 
	 */
	def private void searchAnnotatedElements(EObject element, IAcceptor<Pair<MacroAnnotation, XtendAnnotationTarget>> acceptor) {
		switch element {
			XtendFile : {
				element.xtendTypes.forEach [
					searchAnnotatedElements(acceptor)
				]
			}
			XtendClass : {
				element.registerMacroAnnotations(acceptor)
				element.members.forEach [
					searchAnnotatedElements(acceptor)
				]
			}
			XtendFunction : {
				element.registerMacroAnnotations(acceptor)
				element.parameters.forEach [
					searchAnnotatedElements(acceptor)
				]
			}
			XtendConstructor : {
				element.registerMacroAnnotations(acceptor)
				element.parameters.forEach [
					searchAnnotatedElements(acceptor)
				]
			}
			XtendAnnotationTarget : {
				element.registerMacroAnnotations(acceptor)
			}
		}
	}
	
	def private void registerMacroAnnotations(XtendAnnotationTarget candidate, IAcceptor<Pair<MacroAnnotation, XtendAnnotationTarget>> acceptor) {
		for (annotation : candidate.annotations.filter[ processed ]) {
			val macroAnno = annotation.macroAnnotation
			if (macroAnno != null) {
				if (macroAnno.hasErrors) {
					annotation.eResource.errors += new EObjectDiagnosticImpl(Severity::ERROR, "macro_has_errors", "The referenced macro annotation has compile errors.", annotation, null, -1, null)
				} else if (!macroAnno.isValidTarget(annotation)) {
					annotation.eResource.errors += new EObjectDiagnosticImpl(Severity::ERROR, "invalid_annotation_target", '''The macro annotation «macroAnno.name» can only be used on «macroAnno.targetType.join(',')»''', annotation, null, -1, null)
				} else {
					acceptor.accept(macroAnno -> candidate)
				}
			}
		}
	}
	
	def private boolean isValidTarget(MacroAnnotation it, XAnnotation annotation) {
		if (targetType.empty)
			return true
		return switch target : annotation.annotatedTarget {
			XtendClass : targetType.contains(TargetType::CLASS)
			XtendField : targetType.contains(TargetType::FIELD)
			XtendFunction : targetType.contains(TargetType::METHOD)
			XtendConstructor : targetType.contains(TargetType::CONSTRUCTOR)
			XtendParameter : targetType.contains(TargetType::PARAMETER)
			default : false
		}
	}

	def private void invokeRegistrators(XtendFile xtendFile, Map<MacroAnnotation, List<XtendAnnotationTarget>> annotatedElements, IJvmDeclaredTypeAcceptor acceptor, CancelIndicator cancelIndicator) {
		for (macroAnnotation :  annotatedElements.keySet.filter[registrator != null]) {
			val elements = macroAnnotation.getElements(annotatedElements)
			val ctx = new DefaultEvaluationContext
			
			val regstratorCtx = registratorContextProvider.get
			regstratorCtx.source = xtendFile
			regstratorCtx.typesBuilder = jvmTypesBuilder
			regstratorCtx.acceptor = acceptor
			regstratorCtx.associator = this.associator
			regstratorCtx.annotatedElements = elements
			
			ctx.newValue(QualifiedName::create('this'), regstratorCtx)
			ctx.newValue(QualifiedName::create('elements'), elements)
			ctx.newValue(QualifiedName::create('source'), xtendFile)
			
			try {
				val result = interpreter.evaluate(macroAnnotation.registrator?.expression, ctx, cancelIndicator)
				if (result.exception != null)
					throw result.exception
			} catch (Exception e) {
				LOG.error(e.message, e)
			}
		}
	}
	
	def private void invokeProcessors(XtendFile xtendFile, Map<MacroAnnotation, List<XtendAnnotationTarget>> annotatedElements, CancelIndicator cancelIndicator) {
		for (macroAnnotation : annotatedElements.keySet) {
			val ctx = new DefaultEvaluationContext
			val elements = macroAnnotation.getElements(annotatedElements)
			
			val processingCtx = processingContextProvider.get
			processingCtx.elements = elements
			processingCtx.source = xtendFile
			processingCtx.typesBuilder = jvmTypesBuilder
			
			ctx.newValue(QualifiedName::create('this'), processingCtx)
			ctx.newValue(QualifiedName::create('elements'), elements)
			ctx.newValue(QualifiedName::create('source'), xtendFile)
			
			try {
				val result = interpreter.evaluate(macroAnnotation.processor.expression, ctx, cancelIndicator)
				if (result.exception != null)
					handleError(xtendFile.eResource, elements, macroAnnotation, result.exception)
			} catch (Exception e) {
				LOG.error(e.message, e)
			}
		}
	}
	
	def private void handleError(Resource resource, List<XtendAnnotationTarget> annotatedElements, MacroAnnotation annotation, Throwable exception) {
		annotatedElements.forEach [
			annotations.filter[ annotationType.simpleName == annotation.name ].forEach [
				val message = switch exception {
					MacroEvaluationException: '''
						Problem during processing : [«exception.cause.getClass.simpleName»] «exception.message»
						in «exception.causer.eResource.URI.lastSegment» Line:«NodeModelUtils::getNode(exception.causer).startLine»
						
							«getHighlightedRange(exception.causer, 2 , 2)»
						
					'''.toString
					default : 'Problems during processing : ['+exception.getClass.simpleName+'] ' + (exception.message?:'')
				}
				resource.errors += new EObjectDiagnosticImpl(Severity::ERROR, 'macro_processing_problem', message, it, null, -1, null)
			]
		]
	}
	
	def private String getHighlightedRange(EObject obj, int linesBefore, int linesAfter) {
		val node = NodeModelUtils::findActualNodeFor(obj)
		val startLine = node.startLine - 1 - linesBefore
		val endLine = node.startLine + linesAfter
		val leafNodes = node.leafNodes.filter[!hidden]
		val document = node.rootNode.leafNodes.fold(new StringBuilder) [result, leafNode |
			if (leafNode == leafNodes.head) {
				result.append("\u2588")
			}
			result.append(leafNode .text)		
//			if (leafNode == leafNodes.last) {
//				result.append("\u2588")
//			} 
			return result
		]
		val result = new StringBuilder
		val lines = document.toString.split('\n')
		for (i : startLine .. endLine) {
			if (i >= 0 && i < lines.size) {
				result.append(lines.get(i)).append('\n')
			}
		}
		return result.toString
	}
	
	def private List<XtendAnnotationTarget> getElements(MacroAnnotation macroAnnotation, Map<MacroAnnotation, List<XtendAnnotationTarget>> annotatedElements) {
		annotatedElements.get(macroAnnotation).filter[e | isTargetType(e, macroAnnotation)].toList
	}
	
	def private boolean isTargetType(XtendAnnotationTarget target, MacroAnnotation annotation) {
		val types = <Class<?>>newArrayList
		for (targetType : annotation.targetType) {
			switch targetType {
				case TargetType::CLASS: {
					types += typeof(XtendClass)
				}
				case TargetType::FIELD: {
					types += typeof(XtendField)
				}
				case TargetType::METHOD: {
					types += typeof(XtendFunction)
				}
				case TargetType::CONSTRUCTOR: {
					types += typeof(XtendConstructor)
				}
				case TargetType::PARAMETER: {
					types += typeof(XtendParameter)
				}
			}
		}
		if (types.empty) {
			return true
		}
		return types.exists[ isInstance(target) ]
	}
}
