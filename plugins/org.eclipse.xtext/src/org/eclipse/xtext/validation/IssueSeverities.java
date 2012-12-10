/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.IPreferenceValues;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class IssueSeverities {
	
	private IPreferenceValues preferenceValues;
	private Map<String, ConfigurableIssueCode> configurableIssueCodes;

	public IssueSeverities(IPreferenceValues preferenceValues, Map<String, ConfigurableIssueCode> configurableIssueCodes) {
		this.preferenceValues = preferenceValues;
		this.configurableIssueCodes = configurableIssueCodes;
	}

	public Severity getSeverity(String code) {
		if (!configurableIssueCodes.containsKey(code))
			return Severity.ERROR;
		return preferenceValues.getPreference(configurableIssueCodes.get(code));
	}
	
	public boolean isIgnored(String code) {
		return getSeverity(code) == null;
	}
}
