package org.eclipse.xtext.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class XtextGrammarTestLanguageFileType extends LanguageFileType {

	public static final XtextGrammarTestLanguageFileType INSTANCE = new XtextGrammarTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private XtextGrammarTestLanguageFileType() {
		super(XtextGrammarTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "XtextGrammarTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "XtextGrammarTestLanguage";
	}

}
