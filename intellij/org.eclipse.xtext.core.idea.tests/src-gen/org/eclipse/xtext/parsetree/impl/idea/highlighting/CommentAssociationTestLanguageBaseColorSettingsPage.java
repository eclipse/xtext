package org.eclipse.xtext.parsetree.impl.idea.highlighting;

import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class CommentAssociationTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public CommentAssociationTestLanguageBaseColorSettingsPage() {
		CommentAssociationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", CommentAssociationTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", CommentAssociationTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", CommentAssociationTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", CommentAssociationTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return CommentAssociationTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}