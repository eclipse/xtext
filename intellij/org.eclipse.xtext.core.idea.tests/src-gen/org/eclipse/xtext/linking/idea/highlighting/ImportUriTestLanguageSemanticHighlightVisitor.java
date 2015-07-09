package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage;

public class ImportUriTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public ImportUriTestLanguageSemanticHighlightVisitor() {
		ImportUriTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
