package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EcoreTerminalsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EcoreTerminalsTestLanguageBaseColorSettingsPage() {
		EcoreTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EcoreTerminalsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EcoreTerminalsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EcoreTerminalsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EcoreTerminalsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EcoreTerminalsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}