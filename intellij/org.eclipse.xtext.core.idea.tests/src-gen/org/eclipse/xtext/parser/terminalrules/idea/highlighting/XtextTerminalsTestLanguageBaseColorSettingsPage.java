package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class XtextTerminalsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public XtextTerminalsTestLanguageBaseColorSettingsPage() {
		XtextTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", XtextTerminalsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", XtextTerminalsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", XtextTerminalsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", XtextTerminalsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return XtextTerminalsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}