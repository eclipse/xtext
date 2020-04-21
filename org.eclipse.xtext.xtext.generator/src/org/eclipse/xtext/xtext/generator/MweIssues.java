/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

/**
 * {@link Issues} implementation for MWE2 workflows.
 */
public class MweIssues implements Issues {
	private final XtextGenerator owner;

	private final org.eclipse.emf.mwe.core.issues.Issues delegate;

	public MweIssues(XtextGenerator owner, org.eclipse.emf.mwe.core.issues.Issues delegate) {
		this.owner = owner;
		this.delegate = delegate;
	}

	@Override
	public void addError(String message) {
		delegate.addError(owner, message);
	}

	@Override
	public void addError(String message, Object source) {
		delegate.addError(owner, message, source);
	}

	@Override
	public void addWarning(String message) {
		delegate.addWarning(owner, message);
	}

	@Override
	public void addWarning(String message, Object source) {
		delegate.addWarning(owner, message, source);
	}

	public XtextGenerator getOwner() {
		return owner;
	}

	public org.eclipse.emf.mwe.core.issues.Issues getDelegate() {
		return delegate;
	}
}
