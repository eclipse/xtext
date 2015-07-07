package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.idea.lang.XtextLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class XtextDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public XtextDefaultColorSettingsPage() {
		XtextLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", XtextSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", XtextSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", XtextSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", XtextSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return XtextLanguage.INSTANCE.getDisplayName();
	}
}