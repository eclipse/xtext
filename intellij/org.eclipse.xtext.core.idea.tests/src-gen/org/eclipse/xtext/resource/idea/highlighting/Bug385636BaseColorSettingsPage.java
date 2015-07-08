package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.Bug385636Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug385636BaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug385636BaseColorSettingsPage() {
		Bug385636Language.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug385636HighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug385636HighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug385636HighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug385636HighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug385636Language.INSTANCE.getDisplayName();
	}
}