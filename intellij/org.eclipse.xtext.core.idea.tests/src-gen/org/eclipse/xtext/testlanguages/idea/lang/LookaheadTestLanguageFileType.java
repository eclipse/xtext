package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class LookaheadTestLanguageFileType extends LanguageFileType {

	public static final LookaheadTestLanguageFileType INSTANCE = new LookaheadTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "lookaheadtestlanguage";

	private LookaheadTestLanguageFileType() {
		super(LookaheadTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "LookaheadTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "LookaheadTestLanguage";
	}

}
