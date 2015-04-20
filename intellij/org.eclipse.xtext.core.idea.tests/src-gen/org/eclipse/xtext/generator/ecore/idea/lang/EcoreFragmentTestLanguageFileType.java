package org.eclipse.xtext.generator.ecore.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EcoreFragmentTestLanguageFileType extends LanguageFileType {

	public static final EcoreFragmentTestLanguageFileType INSTANCE = new EcoreFragmentTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "ecorefragmenttestlanguage";

	private EcoreFragmentTestLanguageFileType() {
		super(EcoreFragmentTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "EcoreFragmentTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "EcoreFragmentTestLanguage";
	}

}
