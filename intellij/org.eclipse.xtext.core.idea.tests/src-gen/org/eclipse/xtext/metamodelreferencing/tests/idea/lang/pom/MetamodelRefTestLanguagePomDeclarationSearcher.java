package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

public class MetamodelRefTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public MetamodelRefTestLanguagePomDeclarationSearcher() {
		super(MetamodelRefTestLanguageLanguage.INSTANCE);
	}

}
