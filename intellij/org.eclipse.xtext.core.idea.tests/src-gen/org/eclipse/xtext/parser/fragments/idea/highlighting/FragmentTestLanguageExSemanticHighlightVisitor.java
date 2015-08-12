package org.eclipse.xtext.parser.fragments.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;

public class FragmentTestLanguageExSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public FragmentTestLanguageExSemanticHighlightVisitor() {
		FragmentTestLanguageExLanguage.INSTANCE.injectMembers(this);
	}
}
