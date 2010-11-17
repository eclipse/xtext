/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntaxErrorMessage {

	private final String message;
	private final String issueCode;
	private final String[] issueData;

	public SyntaxErrorMessage(String message, String issueCode) {
		this(message, issueCode, null);
	}
	
	public SyntaxErrorMessage(String message, String issueCode, String[] issueData) {
		this.message = message;
		this.issueCode = issueCode;
		this.issueData = issueData;
	}
	
	public String getIssueCode() {
		return issueCode;
	}

	public String getMessage() {
		return message;
	}
	
	public String[] getIssueData() {
		return issueData;
	}

}
