package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;

public class SequencerTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public SequencerTestLanguageSemanticHighlightVisitor() {
		SequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
