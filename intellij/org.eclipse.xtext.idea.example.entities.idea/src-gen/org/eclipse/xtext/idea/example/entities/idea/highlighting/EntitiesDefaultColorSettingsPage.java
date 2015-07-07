package org.eclipse.xtext.idea.example.entities.idea.highlighting;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EntitiesDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EntitiesDefaultColorSettingsPage() {
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EntitiesSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", EntitiesSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", EntitiesSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", EntitiesSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EntitiesLanguage.INSTANCE.getDisplayName();
	}
}