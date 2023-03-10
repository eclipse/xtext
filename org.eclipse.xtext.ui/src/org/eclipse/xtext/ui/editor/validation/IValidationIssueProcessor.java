/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Michael Clay - Initial contribution and API
 */
public interface IValidationIssueProcessor {
	void processIssues(List<Issue> issues, IProgressMonitor monitor);
}
