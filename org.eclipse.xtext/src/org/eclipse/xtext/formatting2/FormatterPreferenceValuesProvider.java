/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;

import com.google.inject.Inject;

/**
 * Default {@link IPreferenceValuesProvider} for a formatter.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public class FormatterPreferenceValuesProvider implements IPreferenceValuesProvider {

	@Inject 
	private IWhitespaceInformationProvider whitespaceInfo;
	@Inject
	private IPreferenceValuesProvider valuesProvider;

	@Override
	public IPreferenceValues getPreferenceValues(final Resource resource) {
		final IPreferenceValues preferenceValues = internalGetRawPreferenceValues(resource);
		final String indent = whitespaceInfo.getIndentationInformation(resource.getURI()).getIndentString();
		final String lineSep = whitespaceInfo.getLineSeparatorInformation(resource.getURI()).getLineSeparator();

		return new IPreferenceValues() {

			@Override
			public String getPreference(PreferenceKey key) {
				if (key == FormatterPreferenceKeys.indentation) {
					return indent;
				}
				if (key == FormatterPreferenceKeys.lineSeparator) {
					return lineSep;
				}
				return preferenceValues.getPreference(key);
			}

		};
	}

	protected IPreferenceValues internalGetRawPreferenceValues(final Resource resource) {
		return valuesProvider.getPreferenceValues(resource);
	}

}
