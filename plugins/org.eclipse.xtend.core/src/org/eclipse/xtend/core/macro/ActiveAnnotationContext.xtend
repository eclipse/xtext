/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.util.internal.Stopwatches
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtend.core.validation.IssueCodes

/**
 * @author Sven Efftinge
 */
class ActiveAnnotationContext {
	@Property val List<XtendAnnotationTarget> annotatedSourceElements = newArrayList()
	@Property Object processorInstance
	@Property CompilationUnitImpl compilationUnit
}

/**
 * @author Sven Efftinge
 */
class ActiveAnnotationContextProvider {
	
	@Inject OnChangeEvictingCache cache
	@Inject extension XAnnotationExtensions
	@Inject extension ProcessorInstanceForJvmTypeProvider
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	
	def List<? extends ActiveAnnotationContext> computeContext(XtendFile file) {
		//TODO measure and improve (is called twice for each xtendfile)
		val task = Stopwatches.forTask('[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)')
		task.start
		try {
			cache.get('annotation context', file.eResource) [|
				val Map<JvmAnnotationType, ActiveAnnotationContext> annotatedElements = newLinkedHashMap
				val compilationUnit = compilationUnitProvider.get
				compilationUnit.xtendFile = file
				searchAnnotatedElements(file) [
					if (!annotatedElements.containsKey(key)) {
						val fa = new ActiveAnnotationContext
						fa.compilationUnit = compilationUnit
						val processorType = key.getProcessorType
						val processorInstance = processorType.processorInstance
						if (processorInstance != null) {
							fa.setProcessorInstance(processorInstance)
						} else {
							file.eResource.errors.add(new EObjectDiagnosticImpl(Severity.ERROR, 
								IssueCodes.PROCESSING_ERROR, "Couldn't instantiate the referenced annotation processor of type '"+processorType.identifier
								+"'. This is usually the case when the processor resides in the same project as the annotated element.", file, null, -1, null))
						}
						annotatedElements.put(key, fa)
					}
					annotatedElements.get(key).annotatedSourceElements += value.annotatedTarget
				]
				return annotatedElements.values.toList
			]
		} catch (Throwable e) {
			switch e {
				VirtualMachineError : throw e
				LinkageError: throw e // e.g. java.lang.UnsupportedClassVersionError: activetest/Processor : Unsupported major.minor version 51.0
			}
			return newArrayList
		} finally {
			task.stop
		}
	}
	
	/**
	 * recursively looks for macro annotations on XtendAnnotationTargets 
	 */
	def private void searchAnnotatedElements(EObject element, IAcceptor<Pair<JvmAnnotationType, XAnnotation>> acceptor) {
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
			XtendInterface : {
				element.registerMacroAnnotations(acceptor)
				element.members.forEach [
					searchAnnotatedElements(acceptor)
				]
			}
			XtendEnum : {
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
	
	def private void registerMacroAnnotations(XtendAnnotationTarget candidate, IAcceptor<Pair<JvmAnnotationType, XAnnotation>> acceptor) {
		for (annotation : candidate.annotations.filter[ processed ]) {
			val activeAnnotationDeclaration = annotation.tryFindAnnotationType
			if (activeAnnotationDeclaration != null) {
				if (isValid(annotation, activeAnnotationDeclaration)) {
					acceptor.accept(activeAnnotationDeclaration -> annotation)
				}
			}
		}
	}
	
	def private boolean isValid(XAnnotation annotation, JvmAnnotationType activeAnnotationDeclaration) {
		//TODO validate the annotationTarget against the annotation processor (compatible types, etc.)
		return annotation != null
	}
}