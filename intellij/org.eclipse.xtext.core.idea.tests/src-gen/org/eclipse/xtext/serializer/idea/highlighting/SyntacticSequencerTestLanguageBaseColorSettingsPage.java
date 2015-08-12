package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SyntacticSequencerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SyntacticSequencerTestLanguageBaseColorSettingsPage() {
		SyntacticSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SyntacticSequencerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
