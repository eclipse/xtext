package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;

public class LocationProviderTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public LocationProviderTestLanguageSemanticHighlightVisitor() {
		LocationProviderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
