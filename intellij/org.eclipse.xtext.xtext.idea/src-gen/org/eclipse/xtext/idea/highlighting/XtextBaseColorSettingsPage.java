package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.idea.lang.XtextLanguage;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.openapi.options.colors.AttributesDescriptor;

public class XtextBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	@Inject IHighlightingConfiguration highlightingConfiguration;
	
	private AttributesDescriptor[] descriptors;

	public XtextBaseColorSettingsPage() {
		XtextLanguage.INSTANCE.injectMembers(this);
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
		return XtextLanguage.INSTANCE.getDisplayName();
	}
}