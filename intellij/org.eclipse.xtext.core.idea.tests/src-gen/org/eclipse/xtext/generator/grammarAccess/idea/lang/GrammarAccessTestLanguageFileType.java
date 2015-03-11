package org.eclipse.xtext.generator.grammarAccess.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class GrammarAccessTestLanguageFileType extends LanguageFileType {

	public static final GrammarAccessTestLanguageFileType INSTANCE = new GrammarAccessTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "grammaraccesstestlanguage";

	private GrammarAccessTestLanguageFileType() {
		super(GrammarAccessTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "GrammarAccessTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "GrammarAccessTestLanguage";
	}

}
