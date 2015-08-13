package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class AssignmentFinderTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public AssignmentFinderTestLanguageBaseColorSettingsPage() {
		AssignmentFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return AssignmentFinderTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
