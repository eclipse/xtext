package org.eclipse.xtext.parser.fragments.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

public class FragmentTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public FragmentTestLanguageSemanticHighlightVisitor() {
		FragmentTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
