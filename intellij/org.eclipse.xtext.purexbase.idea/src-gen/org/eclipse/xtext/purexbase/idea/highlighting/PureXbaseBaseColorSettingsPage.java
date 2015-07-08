package org.eclipse.xtext.purexbase.idea.highlighting;

import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class PureXbaseBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public PureXbaseBaseColorSettingsPage() {
		PureXbaseLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", PureXbaseHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", PureXbaseHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", PureXbaseHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", PureXbaseHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return PureXbaseLanguage.INSTANCE.getDisplayName();
	}
}