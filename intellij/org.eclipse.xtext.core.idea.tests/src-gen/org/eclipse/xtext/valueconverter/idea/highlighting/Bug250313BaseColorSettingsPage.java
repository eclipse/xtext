package org.eclipse.xtext.valueconverter.idea.highlighting;

import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug250313BaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug250313BaseColorSettingsPage() {
		Bug250313Language.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug250313HighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug250313HighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug250313HighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug250313HighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug250313Language.INSTANCE.getDisplayName();
	}
}