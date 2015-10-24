/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Severity;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface Issue {

	String CODE_KEY = "CODE_KEY";
	String URI_KEY = "URI_KEY";
	/**
	 * @since 2.9
	 */
	String COLUMN_KEY = "COLUMN_KEY";
	String DATA_KEY = "DATA_KEY";
	
	/**
	 * Returns the severity of the issue. Defaults to {@link Severity#ERROR}.
	 */
	Severity getSeverity();

	String getMessage();

	String getCode();

	CheckType getType();

	URI getUriToProblem();

	/**
	 * Returns the one-based line number of the issue.
	 */
	Integer getLineNumber();
	
	/**
	 * Returns the column in the line of the issue. It's not the virtual column but literally
	 * the character offset in the column, e.g. tab ('\t') counts as one character.
	 * The first char in a line has column number 1, the number is one-based.
	 * 
	 * If no column information is available, returns -1.
	 * 
	 * @since 2.9
	 */
	Integer getColumn();

	Integer getOffset();

	Integer getLength();

	boolean isSyntaxError();

	/**
	 * @return the associated user data. May be <code>null</code> or empty but may not contain <code>null</code> entries.
	 */
	String[] getData();
	
	/**
	 * @author zarnekow - Initial contribution and API
	 */
	static class IssueImpl implements Issue {
		
		private static Logger LOG = Logger.getLogger(IssueImpl.class);

		private Integer length, lineNumber, offset, column;
		private String code, message;
		private boolean isSyntaxError = false;
		private URI uriToProblem;
		private Severity severity;
		private CheckType type;
		private String[] data;

		@Override
		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			if(length == null || length < 0) {
				LOG.error("Issue length was "+length);
				this.length = 0;
			} else {
				this.length = length;
			}
		}

		@Override
		public Integer getLineNumber() {
			return lineNumber;
		}

		public void setLineNumber(Integer lineNumber) {
			this.lineNumber = lineNumber;
		}
		
		/**
		 * @since 2.9
		 */
		@Override
		public Integer getColumn() {
			return column;
		}
		
		/**
		 * @since 2.9
		 */
		public void setColumn(Integer column) {
			this.column = column;
		}

		@Override
		public Integer getOffset() {
			return offset;
		}

		public void setOffset(Integer offset) {
			this.offset = offset;
		}

		@Override
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public URI getUriToProblem() {
			return uriToProblem;
		}

		public void setUriToProblem(URI uriToProblem) {
			this.uriToProblem = uriToProblem;
		}

		@Override
		public Severity getSeverity() {
			return severity == null ? Severity.ERROR : severity;
		}

		public void setSeverity(Severity severity) {
			this.severity = severity;
		}

		@Override
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		@Override
		public String[] getData() {
			return data;
		}

		public void setData(String[] data) {
			this.data = data;
		}

		@Override
		public CheckType getType() {
			return type;
		}

		public void setType(CheckType type) {
			this.type = type;
		}

		public void setSyntaxError(boolean isSyntaxError) {
			this.isSyntaxError = isSyntaxError;
		}

		@Override
		public boolean isSyntaxError() {
			return isSyntaxError;
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder(getSeverity().name());
			result.append(":").append(getMessage());
			result.append(" (");
			if (getUriToProblem() != null)
				result.append(getUriToProblem().trimFragment());
			result.append(" line : ").append(getLineNumber()).append(" column : ").append(getColumn()).append(")");
			return result.toString();
		}
	}
}
