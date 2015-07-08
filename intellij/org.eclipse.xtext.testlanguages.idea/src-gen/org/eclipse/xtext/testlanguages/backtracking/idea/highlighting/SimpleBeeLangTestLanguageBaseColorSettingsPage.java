package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.google.common.collect.Iterables;	
import com.google.inject.Inject;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;


public class SimpleBeeLangTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	@Inject IHighlightingConfiguration highlightingConfiguration;
	
	private AttributesDescriptor[] descriptors;

	public SimpleBeeLangTestLanguageBaseColorSettingsPage() {
		SimpleBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
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
		return SimpleBeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}