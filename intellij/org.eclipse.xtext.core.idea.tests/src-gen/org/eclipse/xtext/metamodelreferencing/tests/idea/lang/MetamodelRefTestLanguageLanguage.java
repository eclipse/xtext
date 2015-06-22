package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class MetamodelRefTestLanguageLanguage extends AbstractXtextLanguage {

	public static final MetamodelRefTestLanguageLanguage INSTANCE = new MetamodelRefTestLanguageLanguage();

	private MetamodelRefTestLanguageLanguage() {
		super("org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguage");
	}

}
