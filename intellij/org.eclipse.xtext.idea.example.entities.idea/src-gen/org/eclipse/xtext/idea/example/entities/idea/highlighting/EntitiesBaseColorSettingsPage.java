package org.eclipse.xtext.idea.example.entities.idea.highlighting;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EntitiesBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EntitiesBaseColorSettingsPage() {
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EntitiesLanguage.INSTANCE.getDisplayName();
	}
}
