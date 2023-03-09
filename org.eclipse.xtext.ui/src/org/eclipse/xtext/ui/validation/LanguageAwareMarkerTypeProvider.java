/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.markers.internal.MarkerTypesModel;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
@Singleton
public class LanguageAwareMarkerTypeProvider extends MarkerTypeProvider {

	protected String fastValidationMarker;
	protected String normalValidationMarker;
	protected String expensiveValidationMarker;
	
	@Inject
	public void initialize(LanguageInfo languageInfo, AbstractUIPlugin uiPlugin) {
		String bundleName = uiPlugin.getBundle().getSymbolicName();
		String languageName = languageInfo.getShortName().toLowerCase();
		setMarkerTypes(bundleName + "." + languageName);
	}
	
	protected void setMarkerTypes(String baseName) {
		MarkerTypesModel markerTypesModel = MarkerTypesModel.getInstance();
		String markerType = baseName + ".check.fast";
		if (markerTypesModel.getType(markerType) == null) {
			markerType = MarkerTypes.FAST_VALIDATION;
		}
		fastValidationMarker = markerType;
		markerType = baseName + ".check.normal";
		if (markerTypesModel.getType(markerType) == null) {
			markerType = MarkerTypes.NORMAL_VALIDATION;
		}
		normalValidationMarker = markerType;
		markerType = baseName + ".check.expensive";
		if (markerTypesModel.getType(markerType) == null) {
			markerType = MarkerTypes.EXPENSIVE_VALIDATION;
		}
		expensiveValidationMarker = markerType;
	}

	@Override
	public String getMarkerType(Issue issue) {
		CheckType type = issue.getType();
		if (type == null)
			return super.getMarkerType(issue);
		switch(type) {
			case FAST: return fastValidationMarker;
			case NORMAL: return normalValidationMarker;
			case EXPENSIVE: return expensiveValidationMarker;
			default: throw new IllegalStateException("issue.getType was " + issue.getType());
		}
	}
	
	@Override
	public CheckType getCheckType(String markerType) {
		if (fastValidationMarker.equals(markerType)) {
			return CheckType.FAST;
		}
		if (normalValidationMarker.equals(markerType)) {
			return CheckType.NORMAL;
		}
		if (expensiveValidationMarker.equals(markerType)) {
			return CheckType.EXPENSIVE;
		}
		return super.getCheckType(markerType);
	}
	
}
