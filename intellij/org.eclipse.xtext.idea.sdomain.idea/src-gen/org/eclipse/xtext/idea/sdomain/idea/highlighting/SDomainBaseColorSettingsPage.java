package org.eclipse.xtext.idea.sdomain.idea.highlighting;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SDomainBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SDomainBaseColorSettingsPage() {
		SDomainLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SDomainHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SDomainHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SDomainHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SDomainHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SDomainLanguage.INSTANCE.getDisplayName();
	}
}