package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class PartialSerializationTestLanguageFileType extends LanguageFileType {

	public static final PartialSerializationTestLanguageFileType INSTANCE = new PartialSerializationTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "partialserializationtestlanguage";

	private PartialSerializationTestLanguageFileType() {
		super(PartialSerializationTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "PartialSerializationTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "PartialSerializationTestLanguage";
	}

}
