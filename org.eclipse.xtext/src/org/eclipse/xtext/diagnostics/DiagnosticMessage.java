/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DiagnosticMessage {

	private final String message;
	private final Severity severity;
	private final String issueCode;
	private final String[] issueData;
	
	public DiagnosticMessage(String message, Severity severity, String issueCode, String... issueData) {
		if (Severity.INFO == severity) {
			throw new IllegalArgumentException("Severity INFO is not supported for diagnostic messages.");
		}
		this.message = message;
		this.severity = severity;
		this.issueCode = issueCode;
		this.issueData = issueData;
	}
	
	public String getIssueCode() {
		return issueCode;
	}
	
	public String[] getIssueData() {
		return issueData;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Severity getSeverity() {
		return severity;
	}
}
