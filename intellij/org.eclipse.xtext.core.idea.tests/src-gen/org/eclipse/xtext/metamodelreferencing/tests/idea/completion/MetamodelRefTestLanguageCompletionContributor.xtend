package org.eclipse.xtext.metamodelreferencing.tests.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

class MetamodelRefTestLanguageCompletionContributor extends AbstractMetamodelRefTestLanguageCompletionContributor {
	new() {
		this(MetamodelRefTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
