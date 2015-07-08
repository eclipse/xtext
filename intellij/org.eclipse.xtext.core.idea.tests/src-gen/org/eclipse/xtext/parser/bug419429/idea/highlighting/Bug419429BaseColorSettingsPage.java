package org.eclipse.xtext.parser.bug419429.idea.highlighting;

import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug419429BaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug419429BaseColorSettingsPage() {
		Bug419429Language.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug419429HighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug419429HighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug419429HighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug419429HighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug419429Language.INSTANCE.getDisplayName();
	}
}