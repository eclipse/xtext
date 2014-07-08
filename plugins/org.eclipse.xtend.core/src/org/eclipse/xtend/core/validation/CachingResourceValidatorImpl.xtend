package org.eclipse.xtend.core.validation

import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.macro.ActiveAnnotationContext
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts
import org.eclipse.xtend.core.macro.AnnotationProcessor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.util.internal.Stopwatches
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.validation.ResourceValidatorImpl
import org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import org.eclipse.xtext.xbase.typesystem.computation.DiagnosticOnFirstKeyword

class CachingResourceValidatorImpl extends DerivedStateAwareResourceValidator {

	static val log = Logger.getLogger(ResourceValidatorImpl)

	@Inject OnChangeEvictingCache cache
	@Inject AnnotationProcessor annotationProcessor
	@Inject extension IJvmModelAssociations
	@Inject extension JvmTypeExtensions 

	override validate(Resource resource, CheckMode mode, CancelIndicator mon) {
		try {
			return cache.get(mode, resource) [ |
				val result = doValidate(resource, mode, mon)
				if (mon != null && mon.canceled)
					throw new OperationCanceledException
				else
					result
			]
		} catch (OperationCanceledException exc) {
			return emptyList
		}
	}

	protected def List<Issue> doValidate(Resource resource, CheckMode mode, CancelIndicator mon) {
		val task = Stopwatches.forTask("ResourceValidatorImpl.validation")
		try {
			task.start
			val monitor = mon ?: CancelIndicator.NullImpl
			resolveProxies(resource, monitor)
			if (monitor.isCanceled)
				return #[]

			val result = Lists.newArrayListWithExpectedSize(resource.getErrors.size + resource.getWarnings.size)
			try {
				val acceptor = createAcceptor(result)

				if (mode.shouldCheck(CheckType.FAST)) {
					runActiveAnnotationValidation(resource, mon)
				}

				if (monitor.isCanceled)
					return #[]

				if (mode.shouldCheck(CheckType.FAST)) {
					for (error : resource.errors) {
						if (monitor.isCanceled)
							return #[]
						issueFromXtextResourceDiagnostic(error, Severity.ERROR, acceptor)
					}

					for (warning : resource.warnings) {
						if (monitor.isCanceled)
							return #[]
						issueFromXtextResourceDiagnostic(warning, Severity.WARNING, acceptor)
					}
				}

				if (monitor.isCanceled)
					return #[]
				val syntaxDiagFail = !result.isEmpty
				logCheckStatus(resource, syntaxDiagFail, "Syntax")

				validate(resource, mode, monitor, acceptor)
				if (monitor.isCanceled)
					return #[]
			} catch (RuntimeException e) {
				log.error(e.getMessage, e)
			}
			return result
		} finally {
			task.stop
		}
	}

	def runActiveAnnotationValidation(Resource resource, CancelIndicator indicator) {
		val contexts = ActiveAnnotationContexts.find(resource)
		if (contexts === null) {
			return
		}
		try {
			contexts.before(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
			for (ActiveAnnotationContext ctx : contexts.getContexts.values) {
				try {
					annotationProcessor.validationPhase(ctx, indicator)
				} catch (Throwable t) {
					ctx.handleProcessingError(resource, t)
				}
			}
		} finally {
			contexts.after(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
		}
		addWarningsForOrphanedJvmElements(resource, indicator)
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

	private def logCheckStatus(Resource resource, boolean parserDiagFail, String string) {
		if (log.isDebugEnabled) {
			log.debug(string + " check " + (if(parserDiagFail) "FAIL" else "OK") + "! Resource: " + resource.getURI)
		}
	}
}
