/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.IssueCode;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseIssueCode extends IssueCode {

	private int javaId = -1;

	public static XbaseIssueCode create(String code, Severity severity, int javaId) {
		XbaseIssueCode issueCode = new XbaseIssueCode();
		issueCode.setCode(code);
		issueCode.setSeverity(severity);
		issueCode.setJavaId(javaId);
		return issueCode;
	}

	public void setJavaId(int javaId) {
		this.javaId = javaId;
	}

	@Override
	public boolean hasJavaEqivalent() {
		return javaId >= 0;
	}

	public int getJavaId() {
		return javaId;
	}
}
