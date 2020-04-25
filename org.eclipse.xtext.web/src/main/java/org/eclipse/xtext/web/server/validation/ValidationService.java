/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.validation;

import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Service class for model validation.
 */
@Singleton
public class ValidationService extends AbstractCachedService<ValidationResult> {
	@Inject
	private IResourceValidator resourceValidator;

	/**
	 * Compute the validation result for the given document. This method should not
	 * be called directly from the service dispatcher; use
	 * {@link #getResult(XtextWebDocumentAccess)} instead in order to avoid
	 * duplicate computations.
	 */
	@Override
	public ValidationResult compute(IXtextWebDocument it, CancelIndicator cancelIndicator) {
		List<Issue> issues = resourceValidator.validate(it.getResource(), CheckMode.ALL, cancelIndicator);
		ValidationResult result = new ValidationResult();
		IterableExtensions.filter(issues, i -> !Severity.IGNORE.equals(i.getSeverity())).forEach(issue -> {
			result.getIssues().add(new ValidationResult.Issue(issue.getMessage(), translate(issue.getSeverity()),
					issue.getLineNumber(), issue.getColumn(), issue.getOffset(), issue.getLength()));
		});
		return result;
	}

	protected String translate(Severity severity) {
		if (severity != null) {
			switch (severity) {
			case WARNING:
				return "warning";
			case ERROR:
				return "error";
			case INFO:
				return "info";
			default:
				return "ignore";
			}
		} else {
			return "ignore";
		}
	}
}
