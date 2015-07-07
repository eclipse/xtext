package org.eclipse.xtend.core.idea.highlighting;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class XtendDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public XtendDefaultColorSettingsPage() {
		XtendLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", XtendSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", XtendSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", XtendSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", XtendSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return XtendLanguage.INSTANCE.getDisplayName();
	}
}