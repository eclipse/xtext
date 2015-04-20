package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class FowlerDslTestLanguageFileType extends LanguageFileType {

	public static final FowlerDslTestLanguageFileType INSTANCE = new FowlerDslTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "fowlerdsltestlanguage";

	private FowlerDslTestLanguageFileType() {
		super(FowlerDslTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "FowlerDslTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "FowlerDslTestLanguage";
	}

}
