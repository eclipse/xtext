package org.eclipse.xtext.purexbase.idea.highlighting;

import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.google.common.collect.Iterables;	
import com.google.inject.Inject;

import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;


public class PureXbaseBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	@Inject IHighlightingConfiguration highlightingConfiguration;
	
	private AttributesDescriptor[] descriptors;

	public PureXbaseBaseColorSettingsPage() {
		PureXbaseLanguage.INSTANCE.injectMembers(this);
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
		return PureXbaseLanguage.INSTANCE.getDisplayName();
	}
}