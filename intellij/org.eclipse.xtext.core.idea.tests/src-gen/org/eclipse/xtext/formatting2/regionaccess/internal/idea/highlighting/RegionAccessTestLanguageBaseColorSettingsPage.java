package org.eclipse.xtext.formatting2.regionaccess.internal.idea.highlighting;

import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class RegionAccessTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public RegionAccessTestLanguageBaseColorSettingsPage() {
		RegionAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", RegionAccessTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", RegionAccessTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", RegionAccessTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", RegionAccessTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return RegionAccessTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}