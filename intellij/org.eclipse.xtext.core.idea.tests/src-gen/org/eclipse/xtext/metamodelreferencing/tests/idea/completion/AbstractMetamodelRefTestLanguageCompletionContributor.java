package org.eclipse.xtext.metamodelreferencing.tests.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.common.idea.completion.TerminalsCompletionContributor;

public class AbstractMetamodelRefTestLanguageCompletionContributor extends TerminalsCompletionContributor {
	public AbstractMetamodelRefTestLanguageCompletionContributor(AbstractXtextLanguage lang) {
		super(lang);
	}
}
