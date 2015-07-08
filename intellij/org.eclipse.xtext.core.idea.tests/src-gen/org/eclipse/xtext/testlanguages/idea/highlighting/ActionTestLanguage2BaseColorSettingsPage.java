package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ActionTestLanguage2BaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ActionTestLanguage2BaseColorSettingsPage() {
		ActionTestLanguage2Language.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ActionTestLanguage2HighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ActionTestLanguage2HighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ActionTestLanguage2HighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ActionTestLanguage2HighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ActionTestLanguage2Language.INSTANCE.getDisplayName();
	}
}