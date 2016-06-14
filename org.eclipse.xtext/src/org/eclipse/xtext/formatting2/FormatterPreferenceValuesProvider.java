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
