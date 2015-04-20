package org.eclipse.xtext.generator.ecore.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SubTestLanguageFileType extends LanguageFileType {

	public static final SubTestLanguageFileType INSTANCE = new SubTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "subtestlanguage";

	private SubTestLanguageFileType() {
		super(SubTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "SubTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "SubTestLanguage";
	}

}
