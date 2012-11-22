/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.diagnostics.Severity;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public class IssueCode {

	private String code;
	private Severity severity;

	public IssueCode(String code) {
		this(code, Severity.ERROR);
	}

	public IssueCode(String code, Severity severity) {
		this.code = code;
		this.severity = severity;
	}

	public String getCode() {
		return code;
	}

	public Severity getSeverity() {
		return severity;
	}

}
