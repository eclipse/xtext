/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Stephane Galland - add calls to getValuesProvider()
 * @since 2.4
 */
public class IssueSeveritiesProvider {
	
	@Inject private IPreferenceValuesProvider valuesProvider;
	@Inject private ConfigurableIssueCodesProvider issueCodesProvider;
	@Inject private SeverityConverter severityConverter;
	
	protected IPreferenceValuesProvider getValuesProvider() {
		return valuesProvider;
	}
	
	public IssueSeverities getIssueSeverities(Resource context) {
		IPreferenceValues preferenceValues = getValuesProvider().getPreferenceValues(context);
		return new IssueSeverities(preferenceValues, issueCodesProvider.getConfigurableIssueCodes(), severityConverter);
	}
}
