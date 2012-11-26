/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.validation.ConfigurableIssueCode;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseIssueCode extends ConfigurableIssueCode {

	public final static String SEVERITY_JAVA = "java";

	private String javaId;

	public XbaseIssueCode(String code, String defaultSeverity) {
		super(code, defaultSeverity);
	}

	public static XbaseIssueCode create(String code, String defaultSeverity, String javaId) {
		XbaseIssueCode issueCode = new XbaseIssueCode(code, defaultSeverity);
		issueCode.setJavaId(javaId);
		return issueCode;
	}

	public void setJavaId(String javaId) {
		this.javaId = javaId;
	}

	public boolean hasJavaEqivalent() {
		return javaId != null;
	}

	public String getJavaId() {
		return javaId;
	}
}
