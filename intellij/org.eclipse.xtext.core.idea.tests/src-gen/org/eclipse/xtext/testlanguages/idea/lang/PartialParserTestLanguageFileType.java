package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class PartialParserTestLanguageFileType extends LanguageFileType {

	public static final PartialParserTestLanguageFileType INSTANCE = new PartialParserTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private PartialParserTestLanguageFileType() {
		super(PartialParserTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "PartialParserTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "PartialParserTestLanguage";
	}

}
