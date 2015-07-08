package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.idea.lang.XtextLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class XtextBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public XtextBaseColorSettingsPage() {
		XtextLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", XtextHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", XtextHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", XtextHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", XtextHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return XtextLanguage.INSTANCE.getDisplayName();
	}
}