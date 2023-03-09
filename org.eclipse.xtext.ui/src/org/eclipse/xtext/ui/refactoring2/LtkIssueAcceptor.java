/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class LtkIssueAcceptor implements RefactoringIssueAcceptor {

	@Inject
	private StatusWrapper status;

	@Override
	public void add(RefactoringIssueAcceptor.Severity severity, String message, URI uri, ResourceSet resourceSet) {
		status.add(convert(severity), message, uri, resourceSet);
	}

	@Override
	public void add(RefactoringIssueAcceptor.Severity severity, String message, URI resourceUri) {
		status.add(convert(severity), message, resourceUri);
	}

	@Override
	public void add(RefactoringIssueAcceptor.Severity severity, String message, EObject element) {
		status.add(convert(severity), message, element);
	}

	@Override
	public void add(RefactoringIssueAcceptor.Severity severity, String message, EObject element, ITextRegion region) {
		status.add(convert(severity), message, element, region);
	}

	@Override
	public void add(RefactoringIssueAcceptor.Severity severity, String message, Exception exc, Logger log) {
		status.add(convert(severity), message, exc, log);
	}

	@Override
	public void add(RefactoringIssueAcceptor.Severity severity, String message, Object... params) {
		status.add(convert(severity), message, params);
	}

	public RefactoringStatus getRefactoringStatus() {
		return status.getRefactoringStatus();
	}

	protected int convert(RefactoringIssueAcceptor.Severity severity) {
		int refactoringStatus = RefactoringStatus.OK;
		if (severity != null) {
			switch (severity) {
				case FATAL:
					refactoringStatus = RefactoringStatus.FATAL;
					break;
				case ERROR:
					refactoringStatus = RefactoringStatus.ERROR;
					break;
				case WARNING:
					refactoringStatus = RefactoringStatus.WARNING;
					break;
				case INFO:
					refactoringStatus = RefactoringStatus.INFO;
					break;
				default:
					break;
			}
		}
		return refactoringStatus;
	}
}
