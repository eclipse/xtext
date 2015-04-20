package org.eclipse.xtext.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class XtextGrammarTestLanguageFileType extends LanguageFileType {

	public static final XtextGrammarTestLanguageFileType INSTANCE = new XtextGrammarTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "xtextgrammartestlanguage";

	private XtextGrammarTestLanguageFileType() {
		super(XtextGrammarTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "XtextGrammarTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "XtextGrammarTestLanguage";
	}

}
