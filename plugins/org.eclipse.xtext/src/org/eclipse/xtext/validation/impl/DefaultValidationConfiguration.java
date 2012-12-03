/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.ConfigurableIssueCode;
import org.eclipse.xtext.validation.IValidatorConfiguration;
import org.eclipse.xtext.validation.IssueCode;

import com.google.common.collect.Maps;

/**
 * @author dhuebner - Initial contribution and API
 * @since 2.4
 */
public class DefaultValidationConfiguration implements IValidatorConfiguration {
	private Map<IssueCode, Severity> values = Maps.newHashMap();

	public DefaultValidationConfiguration(List<IssueCode> codes) {
		load(codes);
	}

	protected void load(final List<IssueCode> codes) {
		for (IssueCode issueCode : codes) {
			values.put(issueCode, convertToSeverity(issueCode));
		}
	}

	private Severity convertToSeverity(final IssueCode issueCode) {
		String severity = issueCode.getDefaultSeverity();
		Severity severityEnum = null;
		if (IssueCode.SEVERITY_ERROR.equals(severity)) {
			severityEnum = Severity.ERROR;
		} else if (ConfigurableIssueCode.SEVERITY_WARNING.equals(severity)) {
			severityEnum = Severity.WARNING;
		} else if (ConfigurableIssueCode.SEVERITY_INFO.equals(severity)) {
			severityEnum = Severity.INFO;
		} else if (ConfigurableIssueCode.SEVERITY_DERIVED.equals(severity)) {
			severityEnum = loadDerivedSeverity(issueCode);
		}
		return severityEnum;
	}

	private Severity loadDerivedSeverity(IssueCode issueCode) {
		return Severity.ERROR;
	}

	public Severity getSeverity(IssueCode code) {
		if (!values.containsKey(code)) {
			throw new IllegalArgumentException("Issue code " + code.getCode() + " was not registred.");
		}
		return values.get(code);
	}

	public boolean isIgnore(IssueCode code) {
		return getSeverity(code) == null;
	}

}
