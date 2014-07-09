package org.eclipse.xtend.core.validation

import com.google.inject.Inject
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.macro.ActiveAnnotationContext
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts
import org.eclipse.xtend.core.macro.AnnotationProcessor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import org.eclipse.xtext.xbase.typesystem.computation.DiagnosticOnFirstKeyword

class CachingResourceValidatorImpl extends DerivedStateAwareResourceValidator {

	@Inject OnChangeEvictingCache cache
	@Inject AnnotationProcessor annotationProcessor
	@Inject extension IJvmModelAssociations
	@Inject extension JvmTypeExtensions 

	override validate(Resource resource, CheckMode mode, CancelIndicator mon) {
		try {
			return cache.get(mode, resource) [ |
				val result = super.validate(resource, mode, mon)
				if (mon != null && mon.canceled)
					throw new OperationCanceledException
				else
					result
			]
		} catch (OperationCanceledException exc) {
			return emptyList
		}
	}

	override protected collectResourceDiagnostics(Resource resource, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		runActiveAnnotationValidation(resource, monitor)
		addWarningsForOrphanedJvmElements(resource, monitor)
		super.collectResourceDiagnostics(resource, monitor, acceptor)
	}
	
	private def runActiveAnnotationValidation(Resource resource, CancelIndicator monitor) {
		val contexts = ActiveAnnotationContexts.find(resource)
		if (contexts === null) {
			return
		}
		try {
			contexts.before(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
			for (ActiveAnnotationContext ctx : contexts.getContexts.values) {
				if (monitor.canceled) {
					return
				}
				try {
					annotationProcessor.validationPhase(ctx, monitor)
				} catch (Throwable t) {
					ctx.handleProcessingError(resource, t)
				}
			}
		} finally {
			contexts.after(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
		}
	}

	private def addWarningsForOrphanedJvmElements(Resource resource, CancelIndicator monitor) {
		for (jvmType : resource.contents.tail.filter(JvmDeclaredType)) {
			for (jvmMember : jvmType.eAllContents.filter(JvmMember).filter[!synthetic].toIterable) {
				if (monitor.isCanceled) {
					return
				}
				val sourceElement = jvmMember.primarySourceElement
				if (sourceElement === null) {
					addWarningForOrphanedJvmElement(resource, jvmMember)
				}
			}
		}
	}

	private def addWarningForOrphanedJvmElement(Resource resource, JvmMember jvmElement) {
		resource.warnings.add(
			new DiagnosticOnFirstKeyword(
				Severity.WARNING,
				IssueCodes.ORPHAN_ELMENT,
				'''The generated element «jvmElement.qualifiedName» has no source element''',
				resource.contents.head,
				null
			))
	}
}
