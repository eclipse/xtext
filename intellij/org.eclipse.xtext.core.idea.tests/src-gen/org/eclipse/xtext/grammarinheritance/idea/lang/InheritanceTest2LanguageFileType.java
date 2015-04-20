package org.eclipse.xtext.grammarinheritance.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class InheritanceTest2LanguageFileType extends LanguageFileType {

	public static final InheritanceTest2LanguageFileType INSTANCE = new InheritanceTest2LanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "inheritancetest2language";

	private InheritanceTest2LanguageFileType() {
		super(InheritanceTest2LanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "InheritanceTest2Language files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "InheritanceTest2Language";
	}

}
