package org.eclipse.xtext.parser.epatch.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EpatchTestLanguageFileType extends LanguageFileType {

	public static final EpatchTestLanguageFileType INSTANCE = new EpatchTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private EpatchTestLanguageFileType() {
		super(EpatchTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "EpatchTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "EpatchTestLanguage";
	}

}
