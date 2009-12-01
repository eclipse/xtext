/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface Issue {
	enum Severity {
		WARNING,ERROR, INFO
	}

	String CODE_KEY = "CODE_KEY";
	String URI_KEY = "URI_KEY";
	
	Severity getSeverity();
	String getMessage();
	Integer getCode();
	URI getUriToProblem();
	Integer getLineNumber();
	Integer getOffset();
	Integer getLength();
	boolean isSyntaxError();
	
	static class IssueImpl implements Issue {
		
		private Integer length,lineNumber,offset,code;
		private String message;
		private boolean isSyntaxError = false;
		private URI uriToProblem;
		private Severity severity;
		public Integer getLength() {
			return length;
		}
		public void setLength(Integer length) {
			this.length = length;
		}
		public Integer getLineNumber() {
			return lineNumber;
		}
		public void setLineNumber(Integer lineNumber) {
			this.lineNumber = lineNumber;
		}
		public Integer getOffset() {
			return offset;
		}
		public void setOffset(Integer offset) {
			this.offset = offset;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public URI getUriToProblem() {
			return uriToProblem;
		}
		public void setUriToProblem(URI uriToProblem) {
			this.uriToProblem = uriToProblem;
		}
		public Severity getSeverity() {
			return severity;
		}
		public void setSeverity(Severity severity) {
			this.severity = severity;
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		
		public void setSyntaxError(boolean isSyntaxError) {
			this.isSyntaxError = isSyntaxError;
		}
		
		public boolean isSyntaxError() {
			return isSyntaxError;
		}
	}
}
