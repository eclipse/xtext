package org.eclipse.xtext.parser.epatch.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EpatchTestLanguageFileType extends LanguageFileType {

	public static final EpatchTestLanguageFileType INSTANCE = new EpatchTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "epatchtestlanguage";

	private EpatchTestLanguageFileType() {
		super(EpatchTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "EpatchTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "EpatchTestLanguage";
	}

}
