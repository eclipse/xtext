package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class XtextGrammarTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public XtextGrammarTestLanguageBaseColorSettingsPage() {
		XtextGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", XtextGrammarTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", XtextGrammarTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", XtextGrammarTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", XtextGrammarTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return XtextGrammarTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}