package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage;

public class HiddenTokenSequencerTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public HiddenTokenSequencerTestLanguageSemanticHighlightVisitor() {
		HiddenTokenSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
