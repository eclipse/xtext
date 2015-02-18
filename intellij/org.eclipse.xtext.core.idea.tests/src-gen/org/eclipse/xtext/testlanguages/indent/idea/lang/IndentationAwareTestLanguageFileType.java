package org.eclipse.xtext.testlanguages.indent.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class IndentationAwareTestLanguageFileType extends LanguageFileType {

	public static final IndentationAwareTestLanguageFileType INSTANCE = new IndentationAwareTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "indentationawaretestlanguage";

	private IndentationAwareTestLanguageFileType() {
		super(IndentationAwareTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "IndentationAwareTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "IndentationAwareTestLanguage";
	}

}
