package org.eclipse.xtext.serializer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ContextFinderTestLanguageFileType extends LanguageFileType {

	public static final ContextFinderTestLanguageFileType INSTANCE = new ContextFinderTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "contextfindertestlanguage";

	private ContextFinderTestLanguageFileType() {
		super(ContextFinderTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "ContextFinderTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "ContextFinderTestLanguage";
	}

}
