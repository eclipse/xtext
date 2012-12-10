/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.IPreferenceKey;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public class ConfigurableIssueCode extends IPreferenceKey.AbstractKey<Severity>{
	
	public final static String SEVERITY_ERROR = "error";
	public final static String SEVERITY_WARNING = "warning";
	public final static String SEVERITY_INFO = "info";
	public final static String SEVERITY_IGNORE = "ignore";

	public final Severity severity;

	public ConfigurableIssueCode(String code) {
		this(code, Severity.ERROR);
	}
	
	public ConfigurableIssueCode(String code, Severity defaultSeverity) {
		super(code);
		this.severity = defaultSeverity;
	}
	
	public ConfigurableIssueCode(String code, ConfigurableIssueCode delegateTo) {
		super(code, delegateTo);
		severity = null;
	}

	public Severity getDefaultValue() {
		return severity;
	}

	public String valueToString(Severity value) {
		return severityToString(value);
	}

	public Severity stringToValue(String severityAsString) {
		return stringToSeverity(severityAsString);
	}
	
	public static String severityToString(Severity value) {
		if (value == null) {
			return SEVERITY_IGNORE;
		}
		switch (value) {
			case ERROR:
				return SEVERITY_ERROR;
			case WARNING:
				return SEVERITY_WARNING;
			case INFO:
				return SEVERITY_INFO;
		}
		throw new IllegalArgumentException("Unknown severity "+value);
	}

	public static Severity stringToSeverity(String severityAsString) {
		if (severityAsString == null)
			throw new IllegalArgumentException("Severity as string was null");
		if (severityAsString.equals(SEVERITY_ERROR)) {
			return Severity.ERROR;
		}
		if (severityAsString.equals(SEVERITY_WARNING)) {
			return Severity.WARNING;
		}
		if (severityAsString.equals(SEVERITY_INFO)) {
			return Severity.INFO;
		}
		if (severityAsString.equals(SEVERITY_IGNORE)) {
			return null;
		}
		throw new IllegalArgumentException("Unknown severity '"+severityAsString+"'.");
	}
	
	
}