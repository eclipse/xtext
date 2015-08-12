package org.eclipse.xtext.formatting2.regionaccess.internal.idea.highlighting;

import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class RegionAccessTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public RegionAccessTestLanguageBaseColorSettingsPage() {
		RegionAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return RegionAccessTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
