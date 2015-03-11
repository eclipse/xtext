package org.eclipse.xtext.parser.encoding.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EncodingTestLanguageFileType extends LanguageFileType {

	public static final EncodingTestLanguageFileType INSTANCE = new EncodingTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "encodingtestlanguage";

	private EncodingTestLanguageFileType() {
		super(EncodingTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "EncodingTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "EncodingTestLanguage";
	}

}
