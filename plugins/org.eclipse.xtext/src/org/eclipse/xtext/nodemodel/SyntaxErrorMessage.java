/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

/**
 * A syntax error message represents a parsing problem. May be produced due to
 * parser or lexer errors. 
 * @see org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntaxErrorMessage {

	private final String message;
	private final String issueCode;
	private final String[] issueData;

	public SyntaxErrorMessage(String message, String issueCode) {
		this(message, issueCode, null);
	}
	
	/**
	 * @param message the error message. May not be <code>null</code>.
	 * @param issueCode the issue code used to associate quick fixes with this error. May be <code>null</code>.
	 * @param issueData the issue data. Be careful to not modify the array after passing it to the
	 *   constructor since it will not create a pessimistic copy. May be <code>null</code>.
	 */
	public SyntaxErrorMessage(String message, String issueCode, String[] issueData) {
		if (message == null)
			throw new NullPointerException("message may not be null");
		this.message = message;
		this.issueCode = issueCode;
		this.issueData = issueData;
	}
	
	/**
	 * @return the issue code. May be <code>null</code>. 
	 */
	public String getIssueCode() {
		return issueCode;
	}

	/**
	 * @return the error message. Never <code>null</code>. 
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return the issue data. May be <code>null</code>. Callers should not modify the array since it is
	 *   no pessimistic copy.
	 */
	public String[] getIssueData() {
		return issueData;
	}

}
