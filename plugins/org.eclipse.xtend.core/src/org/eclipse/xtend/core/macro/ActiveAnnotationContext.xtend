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
import org.apache.log4j.Logger
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.internal.Stopwatches
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage

/**
 * @author Sven Efftinge
 */
@Accessors class ActiveAnnotationContext {
	val List<XtendAnnotationTarget> annotatedSourceElements = newArrayList()
	Object processorInstance
	CompilationUnitImpl compilationUnit
	
	def void handleProcessingError(Resource resource, Throwable t) {
		compilationUnit.handleProcessingError(annotatedSourceElements, resource, t)
	}
}

class ActiveAnnotationContexts extends AdapterImpl {
	
	enum AnnotationCallback {
		INDEXING,
		INFERENCE,
		VALIDATION,
		GENERATION
	}
	
	@Accessors val Map<JvmAnnotationType, ActiveAnnotationContext> contexts = newLinkedHashMap
	protected CompilationUnitImpl compilationUnit
	private boolean running
	
	def void before(AnnotationCallback phase) {
		compilationUnit.before(phase)
		running = true
	}
	
	def void after(AnnotationCallback phase) {
		running = false
		compilationUnit.after(phase)
	} 
	
	def static ActiveAnnotationContexts installNew(Resource resource) {
		var result = resource.eAdapters.filter(ActiveAnnotationContexts).head
		if (result != null) {
			result.contexts.clear
		} else {
			result = new ActiveAnnotationContexts
			resource.eAdapters += result
		}
		return result
	}
	
	override notifyChanged(Notification msg) {
		if (!running && !msg.touch && Resource.RESOURCE__CONTENTS == msg.getFeatureID(Resource)) {
			val resource = msg.notifier as Resource
			resource.eAdapters.remove(this)
			contexts.clear
			compilationUnit = null
		}
	}
	
	def static ActiveAnnotationContexts find(Resource resource) {
		resource.eAdapters.filter(ActiveAnnotationContexts).head
	}
}

/**
 * @author Sven Efftinge
 */
class ActiveAnnotationContextProvider {
	static val logger = Logger.getLogger(ActiveAnnotationContextProvider)
	
	@Inject extension XAnnotationExtensions
	@Inject extension ProcessorInstanceForJvmTypeProvider
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	@Inject OperationCanceledManager operationCanceledManager
	
	def ActiveAnnotationContexts computeContext(XtendFile file) {
		//TODO measure and improve (is called twice for each xtendfile)
		val task = Stopwatches.forTask('[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)')
		task.start
		try {
			val result = ActiveAnnotationContexts.installNew(file.eResource)
			val compilationUnit = compilationUnitProvider.get
			compilationUnit.xtendFile = file
			result.compilationUnit = compilationUnit
			searchAnnotatedElements(file) [
				if (!result.contexts.containsKey(key)) {
					val fa = new ActiveAnnotationContext
					fa.compilationUnit = compilationUnit
					val processorType = key.getProcessorType
					try {
						val processorInstance = processorType.processorInstance
						if (processorInstance == null) {
							throw new IllegalStateException("Couldn't instantiate the annotation processor of type '" + processorType.identifier + "'. This is usually the case when the processor resides in the same project as the annotated element.");
						}
						fa.setProcessorInstance(processorInstance)
					} catch (VirtualMachineError e) {
						throw e
					} catch (Throwable e) {
						operationCanceledManager.propagateAsErrorIfCancelException(e)
						val msg = switch e {
							ExceptionInInitializerError : e.exception.message
							default : e.message
						}
						file.eResource.errors.add(new EObjectDiagnosticImpl(Severity.ERROR, 
							IssueCodes.PROCESSING_ERROR, '''Problem while loading annotation processor: «msg»''', value,
							XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, -1, null))
					}
					result.contexts.put(key, fa)
				}
				result.contexts.get(key).annotatedSourceElements += value.annotatedTarget
			]
			return result
		} catch (Throwable e) {
			operationCanceledManager.propagateAsErrorIfCancelException(e)
			switch e {
				VirtualMachineError : throw e
				LinkageError: throw e // e.g. java.lang.UnsupportedClassVersionError: activetest/Processor : Unsupported major.minor version 51.0
				default : logger.warn("Error finding the elements to be processed by active annotations", e)
			}
			return ActiveAnnotationContexts.installNew(file.eResource)
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
				for (it : element.xtendTypes) {
					searchAnnotatedElements(acceptor)
				}
			}
			XtendClass : {
				element.registerMacroAnnotations(acceptor)
				for (it : element.members) {
					searchAnnotatedElements(acceptor)
				}
			}
			XtendInterface : {
				element.registerMacroAnnotations(acceptor)
				for (it : element.members) {
					searchAnnotatedElements(acceptor)
				}
			}
			XtendEnum : {
				element.registerMacroAnnotations(acceptor)
				for (it : element.members) {
					searchAnnotatedElements(acceptor)
				}
			}
			XtendAnnotationType : {
				element.registerMacroAnnotations(acceptor)
				for (it : element.members) {
					searchAnnotatedElements(acceptor)
				}
			}
			XtendFunction : {
				element.registerMacroAnnotations(acceptor)
				for (it : element.parameters) {
					searchAnnotatedElements(acceptor)
				}
			}
			XtendConstructor : {
				element.registerMacroAnnotations(acceptor)
				for (it : element.parameters) {
					searchAnnotatedElements(acceptor)
				}
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