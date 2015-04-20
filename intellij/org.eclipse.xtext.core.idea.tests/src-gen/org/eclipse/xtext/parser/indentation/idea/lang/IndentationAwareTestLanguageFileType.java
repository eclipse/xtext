package org.eclipse.xtext.parser.indentation.idea.lang;

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

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "IndentationAwareTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "IndentationAwareTestLanguage";
	}

}
