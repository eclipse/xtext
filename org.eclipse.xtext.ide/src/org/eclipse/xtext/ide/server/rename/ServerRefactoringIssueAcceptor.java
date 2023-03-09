/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.rename;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class ServerRefactoringIssueAcceptor implements RefactoringIssueAcceptor {
	public static class Issue {
		private Severity severity;

		private String message;
	}

	private List<Issue> issues = new ArrayList<>();

	@Override
	public void add(Severity severity, String message, URI uri, ResourceSet resourceSet) {
		addIssue(severity, message);
	}

	@Override
	public void add(Severity severity, String message, URI resourceUri) {
		addIssue(severity, message);
	}

	@Override
	public void add(Severity severity, String message, EObject element) {
		addIssue(severity, message);
	}

	@Override
	public void add(Severity severity, String message, EObject element, ITextRegion region) {
		addIssue(severity, message);
	}

	@Override
	public void add(Severity severity, String message, Exception exc, Logger log) {
		addIssue(severity, message);
	}

	@Override
	public void add(Severity severity, String message, Object... params) {
		Issue issue = new Issue();
		issue.severity = severity;
		issue.message = message;
		issues.add(issue);
	}

	protected boolean addIssue(Severity severity, String message) {
		Issue issue = new Issue();
		issue.severity = severity;
		issue.message = message;
		return issues.add(issue);
	}

	public Severity getMaximumSeverity() {
		if (issues.size() > 0) {
			Issue minBySeverity = IterableExtensions.minBy(issues, (i) -> i.severity);
			Severity severity = null;
			if (minBySeverity != null) {
				severity = minBySeverity.severity;
			}
			return severity;
		} else {
			return Severity.OK;
		}
	}

	public ResponseError toResponseError() {
		Severity maxSeverity = getMaximumSeverity();
		ResponseError responseError = new ResponseError();
		responseError.setMessage(getMessageBySeverity(maxSeverity));
		responseError.setCode(getCodeBySeverity(maxSeverity));
		List<Issue> bySeverity = IterableExtensions.sortBy(issues, (i) -> i.severity);
		List<String> messages = Lists.transform(Lists.reverse(bySeverity), (i) -> i.message);
		responseError.setData(Joiner.on("\n").join(messages));
		return responseError;
	}

	/**
	 * @since 2.22
	 */
	protected int getCodeBySeverity(Severity maxSeverity) {
		if (maxSeverity != null) {
			switch (maxSeverity) {
			case OK:
				return 0;
			case INFO:
				return 0;
			case WARNING:
				return 0;
			case ERROR:
				return ResponseErrorCode.UnknownErrorCode.getValue();
			case FATAL:
				return ResponseErrorCode.UnknownErrorCode.getValue();
			default:
				return 0;
			}
		}
		return 0;
	}

	/**
	 * @since 2.22
	 */
	protected String getMessageBySeverity(Severity maxSeverity) {
		if (maxSeverity != null) {
			switch (maxSeverity) {
			case OK:
				return "Refactoring is possible";
			case INFO:
				return "Refactoring is possible";
			case WARNING:
				return "Refactoring could cause issues";
			case ERROR:
				return "Refactoring has errors";
			case FATAL:
				return "Refactoring cannot be performed";
			default:
				return null;
			}
		}
		return null;
	}

	public void checkSeverity() {
		if (getMaximumSeverity().compareTo(Severity.WARNING) < 0) {
			throw new ResponseErrorException(toResponseError());
		}
	}
}
