package org.eclipse.xtext.xtext.ecoreInference.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;

public class MultiValueFeatureTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public MultiValueFeatureTestLanguageSemanticHighlightVisitor() {
		MultiValueFeatureTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
