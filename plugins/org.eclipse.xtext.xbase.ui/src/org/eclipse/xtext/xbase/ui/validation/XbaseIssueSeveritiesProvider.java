/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.validation.ConfigurableIssueCode;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseIssueSeveritiesProvider extends IssueSeveritiesProvider {
	
	@Inject private IJavaProjectProvider projectProvider;
	@Inject private XbaseConfigurableIssueCodes configurableIssueCodes;

	@Override
	public IssueSeverities getIssueSeverities(Resource context) {
		final IJavaProject project = projectProvider.getJavaProject(context.getResourceSet());
		IPreferenceValues preferenceValues = getValuesProvider().getPreferenceValues(context);
		return new IssueSeverities(preferenceValues, configurableIssueCodes.getConfigurableIssueCodes()) {
			@Override
			public Severity getSeverity(String code) {
				// delegate to java
				if (code.startsWith(JavaCore.PLUGIN_ID)) {
					return ConfigurableIssueCode.stringToSeverity(project.getOption(code, true));
				}
				return super.getSeverity(code);
			}
		};
	}
}
