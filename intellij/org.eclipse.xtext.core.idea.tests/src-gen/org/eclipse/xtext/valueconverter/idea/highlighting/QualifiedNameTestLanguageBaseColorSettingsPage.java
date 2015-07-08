package org.eclipse.xtext.valueconverter.idea.highlighting;

import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class QualifiedNameTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public QualifiedNameTestLanguageBaseColorSettingsPage() {
		QualifiedNameTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", QualifiedNameTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", QualifiedNameTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", QualifiedNameTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", QualifiedNameTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return QualifiedNameTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}