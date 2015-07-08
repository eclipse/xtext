package org.eclipse.xtext.parsetree.impl.idea.highlighting;

import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug305397BaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug305397BaseColorSettingsPage() {
		Bug305397Language.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug305397HighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug305397HighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug305397HighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug305397HighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug305397Language.INSTANCE.getDisplayName();
	}
}