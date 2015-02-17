package org.eclipse.xtext.resource.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;

public class LocationProviderTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public LocationProviderTestLanguageElementDescriptionProvider() {
		super(LocationProviderTestLanguageLanguage.INSTANCE);
	}

}
