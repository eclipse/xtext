package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.Bug362902Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug362902BaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug362902BaseColorSettingsPage() {
		Bug362902Language.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug362902HighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug362902HighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug362902HighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug362902HighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug362902Language.INSTANCE.getDisplayName();
	}
}