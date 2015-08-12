package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class MetamodelRefTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public MetamodelRefTestLanguageBaseColorSettingsPage() {
		MetamodelRefTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return MetamodelRefTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
