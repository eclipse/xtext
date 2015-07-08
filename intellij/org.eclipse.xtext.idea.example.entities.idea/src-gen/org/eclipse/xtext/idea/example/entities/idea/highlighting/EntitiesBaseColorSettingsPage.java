package org.eclipse.xtext.idea.example.entities.idea.highlighting;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EntitiesBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EntitiesBaseColorSettingsPage() {
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EntitiesHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EntitiesHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EntitiesHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EntitiesHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EntitiesLanguage.INSTANCE.getDisplayName();
	}
}