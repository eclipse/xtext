/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.macro.ActiveAnnotationContext
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts
import org.eclipse.xtend.core.macro.AnnotationProcessor
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.validation.IssueSeveritiesProvider
import org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions
import org.eclipse.xtext.xbase.typesystem.computation.DiagnosticOnFirstKeyword
import org.eclipse.xtext.service.OperationCanceledError

class CachingResourceValidatorImpl extends DerivedStateAwareResourceValidator {

	@Inject OnChangeEvictingCache cache
	@Inject AnnotationProcessor annotationProcessor
	@Inject IssueSeveritiesProvider issueSeveritiesProvider
	@Inject extension IJvmModelAssociations
	@Inject extension JvmTypeExtensions 
	@Inject OperationCanceledManager operationCanceledManager
	
	override validate(Resource resource, CheckMode mode, CancelIndicator mon) throws OperationCanceledError {
		return cache.get(mode, resource) [ |
			operationCanceledManager.checkCanceled(mon)
			return super.validate(resource, mode, mon)
		]
	}

	override protected collectResourceDiagnostics(Resource resource, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		runActiveAnnotationValidation(resource, monitor)
		addWarningsForOrphanedJvmElements(resource, monitor, acceptor)
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
				operationCanceledManager.checkCanceled(monitor)
				try {
					annotationProcessor.validationPhase(ctx, monitor)
				} catch (Throwable t) {
					operationCanceledManager.propagateAsErrorIfCancelException(t);
					ctx.handleProcessingError(resource, t)
				}
			}
		} finally {
			contexts.after(ActiveAnnotationContexts.AnnotationCallback.VALIDATION);
		}
	}

	private def addWarningsForOrphanedJvmElements(Resource resource, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		val issueSeverities = issueSeveritiesProvider.getIssueSeverities(resource)
		val severity = issueSeverities.getSeverity(IssueCodes.ORPHAN_ELEMENT)
		if (severity == Severity.IGNORE)
			return;
		for (jvmType : resource.contents.tail.filter(JvmDeclaredType)) {
			for (jvmMember : jvmType.eAllContents.filter(JvmMember).filter[!synthetic].toIterable) {
				operationCanceledManager.checkCanceled(monitor)
				val sourceElement = jvmMember.primarySourceElement
				if (sourceElement === null) {
					addWarningForOrphanedJvmElement(resource, jvmMember, severity, acceptor)
				}
			}
		}
	}

	private def addWarningForOrphanedJvmElement(Resource resource, JvmMember jvmElement, Severity severity, IAcceptor<Issue> acceptor) {
			new DiagnosticOnFirstKeyword(
				severity,
				IssueCodes.ORPHAN_ELEMENT,
				'''The generated «jvmElement.uiString» is not associated with a source element. The producing active annotation should use 'setPrimarySourceElement'.''',
				resource.contents.head,
				null
			).issueFromXtextResourceDiagnostic(severity ,acceptor)
	}
	
	private def getUiString(JvmMember member) {
		val uiString = new StringBuilder
		val type = switch(member) {
			JvmConstructor: "constructor"
			JvmField : "field"
			JvmOperation : "method"
			JvmDeclaredType : "type"
		}
		uiString.append(type).append(" '").append(member.getQualifiedName("."))
		if (member instanceof JvmExecutable) {
			val parameterTypes = member.parameters.join(", ")[parameterType.simpleName]
			uiString.append("(").append(parameterTypes).append(")")
		}
		uiString.append("'")
		uiString.toString
	}
}
