package org.eclipse.xtext.idea.common.types.idea.highlighting;

import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.google.common.collect.Iterables;	
import com.google.inject.Inject;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;


public class RefactoringTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	@Inject IHighlightingConfiguration highlightingConfiguration;
	
	private AttributesDescriptor[] descriptors;

	public RefactoringTestLanguageBaseColorSettingsPage() {
		RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			Iterables.toArray(highlightingConfiguration.getAttributeDescriptors(), AttributesDescriptor.class);
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return RefactoringTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}