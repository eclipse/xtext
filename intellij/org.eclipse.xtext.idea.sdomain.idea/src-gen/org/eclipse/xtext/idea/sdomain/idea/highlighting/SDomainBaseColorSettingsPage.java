package org.eclipse.xtext.idea.sdomain.idea.highlighting;

import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.google.common.collect.Iterables;	
import com.google.inject.Inject;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;


public class SDomainBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	@Inject IHighlightingConfiguration highlightingConfiguration;
	
	private AttributesDescriptor[] descriptors;

	public SDomainBaseColorSettingsPage() {
		SDomainLanguage.INSTANCE.injectMembers(this);
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
		return SDomainLanguage.INSTANCE.getDisplayName();
	}
}