package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EObjectAtOffsetTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EObjectAtOffsetTestLanguageBaseColorSettingsPage() {
		EObjectAtOffsetTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EObjectAtOffsetTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
