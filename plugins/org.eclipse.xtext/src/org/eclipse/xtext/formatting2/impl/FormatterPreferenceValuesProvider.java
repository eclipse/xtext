package org.eclipse.xtext.formatting2.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;

import com.google.inject.Inject;

public class FormatterPreferenceValuesProvider implements IPreferenceValuesProvider {

	private @Inject IWhitespaceInformationProvider whitespaceInfo;
	private @Inject IPreferenceValuesProvider valuesProvider;

	public IPreferenceValues getPreferenceValues(final Resource resource) {
		final IPreferenceValues preferenceValues = internalGetRawPreferenceValues(resource);
		final String indent = whitespaceInfo.getIndentationInformation(resource.getURI()).getIndentString();
		final String lineSep = whitespaceInfo.getLineSeparatorInformation(resource.getURI()).getLineSeparator();

		return new IPreferenceValues() {

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
