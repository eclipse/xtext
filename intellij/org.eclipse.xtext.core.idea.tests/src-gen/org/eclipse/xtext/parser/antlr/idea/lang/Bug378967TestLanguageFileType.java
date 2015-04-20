package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug378967TestLanguageFileType extends LanguageFileType {

	public static final Bug378967TestLanguageFileType INSTANCE = new Bug378967TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug378967testlanguage";

	private Bug378967TestLanguageFileType() {
		super(Bug378967TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug378967TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug378967TestLanguage";
	}

}
