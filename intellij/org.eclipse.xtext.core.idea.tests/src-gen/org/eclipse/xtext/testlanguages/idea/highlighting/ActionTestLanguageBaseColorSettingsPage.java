package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ActionTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ActionTestLanguageBaseColorSettingsPage() {
		ActionTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ActionTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ActionTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ActionTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ActionTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ActionTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}