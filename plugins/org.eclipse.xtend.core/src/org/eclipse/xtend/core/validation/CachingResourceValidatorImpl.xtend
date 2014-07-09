package org.eclipse.xtend.core.validation

import com.google.inject.Inject
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.macro.ActiveAnnotationContext
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts
import org.eclipse.xtend.core.macro.AnnotationProcessor
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator

class CachingResourceValidatorImpl extends DerivedStateAwareResourceValidator {

	@Inject OnChangeEvictingCache cache
	
	@Inject AnnotationProcessor annotationProcessor

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
		for (error : resource.errors) {
			if (monitor.isCanceled) {
				return
			}
			issueFromXtextResourceDiagnostic(error, Severity.ERROR, acceptor)
		}

		for (warning : resource.warnings) {
			if (monitor.isCanceled)
				return;
			issueFromXtextResourceDiagnostic(warning, Severity.WARNING, acceptor)
		}
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
}
