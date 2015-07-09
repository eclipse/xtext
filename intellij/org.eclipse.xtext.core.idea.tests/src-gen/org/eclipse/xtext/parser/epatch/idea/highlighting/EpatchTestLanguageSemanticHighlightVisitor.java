package org.eclipse.xtext.parser.epatch.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

public class EpatchTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EpatchTestLanguageSemanticHighlightVisitor() {
		EpatchTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
