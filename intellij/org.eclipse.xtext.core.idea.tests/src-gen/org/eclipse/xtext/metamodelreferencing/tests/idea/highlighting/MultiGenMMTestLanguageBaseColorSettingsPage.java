package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class MultiGenMMTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public MultiGenMMTestLanguageBaseColorSettingsPage() {
		MultiGenMMTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", MultiGenMMTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", MultiGenMMTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", MultiGenMMTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", MultiGenMMTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return MultiGenMMTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}