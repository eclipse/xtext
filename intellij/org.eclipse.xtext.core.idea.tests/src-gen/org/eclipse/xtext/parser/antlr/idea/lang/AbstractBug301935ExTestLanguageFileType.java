package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import org.eclipse.xtext.idea.Icons;
import org.jetbrains.annotations.NonNls;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;

public class AbstractBug301935ExTestLanguageFileType extends LanguageFileType {

	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug301935extestlanguage";

	protected AbstractBug301935ExTestLanguageFileType(final Language language) {
		super(language);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug301935ExTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return Icons.DSL_FILE_TYPE;
	}

	@Override
	public String getName() {
		return "Bug301935ExTestLanguage";
	}

}
