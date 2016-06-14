/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class IssueSeverities {
	
	private final static Logger log = Logger.getLogger(IssueSeverities.class);
	
	private IPreferenceValues preferenceValues;
	private Map<String, PreferenceKey> configurableIssueCodes;
	private SeverityConverter converter;

	public IssueSeverities(IPreferenceValues preferenceValues, Map<String, PreferenceKey> configurableIssueCodes, SeverityConverter converter) {
		this.preferenceValues = preferenceValues;
		this.configurableIssueCodes = configurableIssueCodes;
		this.converter = converter;
	}

	/**
	 * @return the Severity for the given severity code. Never returns <code>null</code>
	 */
	public Severity getSeverity(String code) {
		if (!configurableIssueCodes.containsKey(code)) {
			log.error("Configurable issue code '" + code + "' is not registered. Check the binding for " + ConfigurableIssueCodesProvider.class.getName());
			return Severity.IGNORE;
		}
		final String value = preferenceValues.getPreference(configurableIssueCodes.get(code));
		try {
			return converter.stringToSeverity(value);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			return Severity.IGNORE;
		}
	}
	
	public boolean isIgnored(String code) {
		return getSeverity(code) == Severity.IGNORE;
	}
}
