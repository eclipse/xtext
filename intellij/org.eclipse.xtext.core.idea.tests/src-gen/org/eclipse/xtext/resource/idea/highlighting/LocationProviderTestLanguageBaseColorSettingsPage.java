package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class LocationProviderTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public LocationProviderTestLanguageBaseColorSettingsPage() {
		LocationProviderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return LocationProviderTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
