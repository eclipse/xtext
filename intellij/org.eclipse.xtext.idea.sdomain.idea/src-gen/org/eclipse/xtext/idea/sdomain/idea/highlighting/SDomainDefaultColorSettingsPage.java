package org.eclipse.xtext.idea.sdomain.idea.highlighting;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SDomainDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SDomainDefaultColorSettingsPage() {
		SDomainLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SDomainSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", SDomainSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", SDomainSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", SDomainSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SDomainLanguage.INSTANCE.getDisplayName();
	}
}