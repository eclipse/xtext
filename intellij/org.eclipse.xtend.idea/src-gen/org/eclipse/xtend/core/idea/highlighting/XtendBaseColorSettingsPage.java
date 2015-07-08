package org.eclipse.xtend.core.idea.highlighting;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class XtendBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public XtendBaseColorSettingsPage() {
		XtendLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", XtendHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", XtendHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", XtendHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", XtendHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return XtendLanguage.INSTANCE.getDisplayName();
	}
}