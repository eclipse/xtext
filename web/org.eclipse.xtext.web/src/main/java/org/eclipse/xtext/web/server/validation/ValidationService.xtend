/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.validation

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.web.server.model.AbstractCachedService
import org.eclipse.xtext.web.server.model.IXtextWebDocument
import org.eclipse.xtext.web.server.model.UpdateDocumentService

/**
 * Service class for model validation.
 */
@Singleton
class ValidationService extends AbstractCachedService<ValidationResult> {
	
	@Inject IResourceValidator resourceValidator

	/**
	 * Return the validation result for the given document. The actual validation may have
	 * been computed as part of the background work scheduled after another service request,
	 * e.g. {@link UpdateDocumentService}. If that background processing has not been done
	 * yet, it is executed and then the validation issues are collected.
	 */
	override compute(IXtextWebDocument it, CancelIndicator cancelIndicator) {
		val issues = resourceValidator.validate(resource, CheckMode.ALL, cancelIndicator)
		val result = new ValidationResult
		issues.filter[severity != Severity.IGNORE].forEach[ issue |
			result.issues += new ValidationResult.Issue(issue.message, issue.severity.translate,
				issue.lineNumber, issue.column, issue.offset, issue.length)
		]
		return result
	}
	
	protected def translate(Severity severity) {
		switch severity {
			case WARNING : "warning"
			case ERROR : "error"
			case INFO : "info"
			default: "ignore"
		}
	}
}