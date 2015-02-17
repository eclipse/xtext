package org.eclipse.xtext.serializer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ContextFinderTestLanguageFileType extends LanguageFileType {

	public static final ContextFinderTestLanguageFileType INSTANCE = new ContextFinderTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private ContextFinderTestLanguageFileType() {
		super(ContextFinderTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "ContextFinderTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "ContextFinderTestLanguage";
	}

}
