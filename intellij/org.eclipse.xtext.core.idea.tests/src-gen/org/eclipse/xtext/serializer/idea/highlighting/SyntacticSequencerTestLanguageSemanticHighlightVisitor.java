package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;

public class SyntacticSequencerTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SyntacticSequencerTestLanguageSemanticHighlightVisitor() {
		SyntacticSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
