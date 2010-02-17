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
	private final DiagnosticSeverity severity;
	private final String issueCode;
	
	public DiagnosticMessage(String message, DiagnosticSeverity severity, String issueCode) {
		this.message = message;
		this.severity = severity;
		this.issueCode = issueCode;
	}
	
	public String getIssueCode() {
		return issueCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public DiagnosticSeverity getSeverity() {
		return severity;
	}
}
