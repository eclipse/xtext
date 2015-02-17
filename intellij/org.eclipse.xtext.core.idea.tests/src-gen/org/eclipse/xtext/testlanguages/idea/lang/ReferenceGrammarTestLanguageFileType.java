package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ReferenceGrammarTestLanguageFileType extends LanguageFileType {

	public static final ReferenceGrammarTestLanguageFileType INSTANCE = new ReferenceGrammarTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private ReferenceGrammarTestLanguageFileType() {
		super(ReferenceGrammarTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "ReferenceGrammarTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "ReferenceGrammarTestLanguage";
	}

}
