/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.Arrays;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issueCode == null) ? 0 : issueCode.hashCode());
		result = prime * result + Arrays.hashCode(issueData);
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SyntaxErrorMessage other = (SyntaxErrorMessage) obj;
		if (issueCode == null) {
			if (other.issueCode != null)
				return false;
		} else if (!issueCode.equals(other.issueCode))
			return false;
		if (!Arrays.equals(issueData, other.issueData))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SyntaxErrorMessage [message=" + message + ", issueCode=" + issueCode + ", issueData="
				+ Arrays.toString(issueData) + "]";
	}

}
