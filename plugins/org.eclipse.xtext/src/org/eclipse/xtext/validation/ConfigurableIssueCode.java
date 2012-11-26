/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public class ConfigurableIssueCode extends IssueCode {

	public final static String SEVERITY_WARNING = "warning";
	public final static String SEVERITY_IGNORE = "ignore";

	private final String defaultSeverity;

	public ConfigurableIssueCode(String code, String defaultSeverity) {
		super(code);
		this.defaultSeverity = defaultSeverity;
	}

	public static ConfigurableIssueCode create(String code, String defaultSeverity) {
		ConfigurableIssueCode iCode = new ConfigurableIssueCode(code, defaultSeverity);
		return iCode;
	}

	@Override
	public String getDefaultSeverity() {
		return defaultSeverity;
	}

}
