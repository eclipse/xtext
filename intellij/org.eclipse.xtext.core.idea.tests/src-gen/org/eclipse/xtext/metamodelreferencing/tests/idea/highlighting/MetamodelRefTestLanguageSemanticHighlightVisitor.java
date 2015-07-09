package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

public class MetamodelRefTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public MetamodelRefTestLanguageSemanticHighlightVisitor() {
		MetamodelRefTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
