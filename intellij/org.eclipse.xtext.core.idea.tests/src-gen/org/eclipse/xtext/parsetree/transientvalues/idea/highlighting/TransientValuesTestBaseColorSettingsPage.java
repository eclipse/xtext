package org.eclipse.xtext.parsetree.transientvalues.idea.highlighting;

import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class TransientValuesTestBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public TransientValuesTestBaseColorSettingsPage() {
		TransientValuesTestLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", TransientValuesTestHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", TransientValuesTestHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", TransientValuesTestHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", TransientValuesTestHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return TransientValuesTestLanguage.INSTANCE.getDisplayName();
	}
}