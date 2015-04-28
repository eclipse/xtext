package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ReferenceGrammarTestLanguageFileType extends LanguageFileType {

	public static final ReferenceGrammarTestLanguageFileType INSTANCE = new ReferenceGrammarTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "referencegrammartestlanguage";

	private ReferenceGrammarTestLanguageFileType() {
		super(ReferenceGrammarTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "ReferenceGrammarTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "ReferenceGrammarTestLanguage";
	}

}
