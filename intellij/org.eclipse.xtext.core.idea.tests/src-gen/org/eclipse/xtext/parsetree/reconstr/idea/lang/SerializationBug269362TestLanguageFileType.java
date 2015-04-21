package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SerializationBug269362TestLanguageFileType extends LanguageFileType {

	public static final SerializationBug269362TestLanguageFileType INSTANCE = new SerializationBug269362TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "serializationbug269362testlanguage";

	private SerializationBug269362TestLanguageFileType() {
		super(SerializationBug269362TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "SerializationBug269362TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "SerializationBug269362TestLanguage";
	}

}
