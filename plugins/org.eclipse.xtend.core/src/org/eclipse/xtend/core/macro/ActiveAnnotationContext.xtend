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
import org.eclipse.xtext.util.internal.StopWatches
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtend.core.xtend.XtendEnumLiteral

class ActiveAnnotationContext {
	@Property val List<XtendAnnotationTarget> annotatedSourceElements = newArrayList()
	@Property Object processorInstance
	@Property CompilationUnitImpl compilationUnit
}

class ActiveAnnotationContextProvider {
	
	@Inject OnChangeEvictingCache cache
	@Inject extension XAnnotationExtensions
	@Inject extension ProcessorInstanceForJvmTypeProvider
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	
	def List<? extends ActiveAnnotationContext> computeContext(XtendFile file) {
		//TODO measure and improve (is called twice for each xtendfile)
		val task = StopWatches::forTask('[macros] findActiveAnnotations')
		task.start
		try {
			cache.get('annotation context', file.eResource) [|
				val Map<JvmAnnotationType, ActiveAnnotationContext> annotatedElements = newHashMap
				val compilationUnit = compilationUnitProvider.get
				compilationUnit.xtendFile = file
				searchAnnotatedElements(file) [
					if (!annotatedElements.containsKey(key)) {
						val fa = new ActiveAnnotationContext
						fa.compilationUnit = compilationUnit
						val processorType = key.getProcessorType
						fa.setProcessorInstance(processorType.processorInstance)
						annotatedElements.put(key, fa)
					}
					annotatedElements.get(key).annotatedSourceElements += value.annotatedTarget
				]
				return annotatedElements.values.toList
			]
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