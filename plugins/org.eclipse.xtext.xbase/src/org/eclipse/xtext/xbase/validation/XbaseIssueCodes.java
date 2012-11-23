/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.IssueCodes;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseIssueCodes extends IssueCodes {
	// Copied from org.eclipse.xtext.xbase.validation.IssueCodes:
	// public static final String FORBIDDEN_REFERENCE = XBASE_ISSUE_CODE_PREFIX	+ "forbidden_reference";

	private static final String XBASE_ISSUE_CODE_PREFIX = "org.eclipse.xtext.xbase.validation.IssueCodes.";

	public final XbaseIssueCode forbiddenReference = XbaseIssueCode.create(XBASE_ISSUE_CODE_PREFIX
			+ "forbidden_reference", Severity.ERROR, IProblem.ForbiddenReference);

}
