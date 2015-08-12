package org.eclipse.xtext.parsetree.formatter.idea.highlighting;

import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ElementMatcherTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ElementMatcherTestLanguageBaseColorSettingsPage() {
		ElementMatcherTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ElementMatcherTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
