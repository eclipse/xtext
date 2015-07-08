package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class MetamodelRefTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public MetamodelRefTestLanguageBaseColorSettingsPage() {
		MetamodelRefTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", MetamodelRefTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", MetamodelRefTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", MetamodelRefTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", MetamodelRefTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return MetamodelRefTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}