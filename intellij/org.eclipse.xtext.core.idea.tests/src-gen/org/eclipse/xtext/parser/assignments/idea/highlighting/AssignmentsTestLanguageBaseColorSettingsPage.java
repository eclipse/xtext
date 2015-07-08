package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class AssignmentsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public AssignmentsTestLanguageBaseColorSettingsPage() {
		AssignmentsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", AssignmentsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", AssignmentsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", AssignmentsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", AssignmentsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return AssignmentsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}