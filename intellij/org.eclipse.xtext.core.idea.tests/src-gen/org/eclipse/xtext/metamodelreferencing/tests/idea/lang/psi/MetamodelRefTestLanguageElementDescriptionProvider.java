package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

public class MetamodelRefTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public MetamodelRefTestLanguageElementDescriptionProvider() {
		super(MetamodelRefTestLanguageLanguage.INSTANCE);
	}

}
