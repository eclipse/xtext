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

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "MetamodelRefTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "MetamodelRefTestLanguage";
	}

}
