/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
