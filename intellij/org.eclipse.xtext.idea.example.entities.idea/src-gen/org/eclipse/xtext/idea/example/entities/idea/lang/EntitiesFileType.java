package org.eclipse.xtext.idea.example.entities.idea.lang;

import javax.swing.Icon;

import org.jetbrains.annotations.NonNls;

import com.intellij.openapi.fileTypes.LanguageFileType;

public final class EntitiesFileType extends LanguageFileType {

	public static final EntitiesFileType INSTANCE = new EntitiesFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "entities";

	private EntitiesFileType() {
		super(EntitiesLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Entities files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Entities";
	}

}
