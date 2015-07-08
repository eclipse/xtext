package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class AssignmentFinderTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public AssignmentFinderTestLanguageBaseColorSettingsPage() {
		AssignmentFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", AssignmentFinderTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", AssignmentFinderTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", AssignmentFinderTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", AssignmentFinderTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return AssignmentFinderTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}