package org.eclipse.xtext.generator.ecore.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SubTestLanguageFileType extends LanguageFileType {

	public static final SubTestLanguageFileType INSTANCE = new SubTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private SubTestLanguageFileType() {
		super(SubTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "SubTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "SubTestLanguage";
	}

}
