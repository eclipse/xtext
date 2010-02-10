/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntaxErrorMessage {

	private final String message;
	private final String issueCode;

	public SyntaxErrorMessage(String message, String issueCode) {
		this.message = message;
		this.issueCode = issueCode;
		if (issueCode != null)
			throw new UnsupportedOperationException("issueCodes are not yet supported for syntax errors");
	}
	
	public String getIssueCode() {
		return issueCode;
	}

	public String getMessage() {
		return message;
	}

}
