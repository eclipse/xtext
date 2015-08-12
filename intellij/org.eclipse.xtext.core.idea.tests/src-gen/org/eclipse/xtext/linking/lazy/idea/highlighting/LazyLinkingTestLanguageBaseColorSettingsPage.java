package org.eclipse.xtext.linking.lazy.idea.highlighting;

import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class LazyLinkingTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public LazyLinkingTestLanguageBaseColorSettingsPage() {
		LazyLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return LazyLinkingTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
