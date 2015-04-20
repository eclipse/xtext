package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class MetamodelRefTestLanguageFileType extends LanguageFileType {

	public static final MetamodelRefTestLanguageFileType INSTANCE = new MetamodelRefTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "metamodelreftestlanguage";

	private MetamodelRefTestLanguageFileType() {
		super(MetamodelRefTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "MetamodelRefTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "MetamodelRefTestLanguage";
	}

}
