package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SerializationErrorTestLanguageFileType extends LanguageFileType {

	public static final SerializationErrorTestLanguageFileType INSTANCE = new SerializationErrorTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "serializationerrortestlanguage";

	private SerializationErrorTestLanguageFileType() {
		super(SerializationErrorTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "SerializationErrorTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "SerializationErrorTestLanguage";
	}

}
