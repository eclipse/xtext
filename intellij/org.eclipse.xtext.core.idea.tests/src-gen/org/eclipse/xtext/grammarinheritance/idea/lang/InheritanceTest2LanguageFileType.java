package org.eclipse.xtext.grammarinheritance.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class InheritanceTest2LanguageFileType extends LanguageFileType {

	public static final InheritanceTest2LanguageFileType INSTANCE = new InheritanceTest2LanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private InheritanceTest2LanguageFileType() {
		super(InheritanceTest2LanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "InheritanceTest2Language files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "InheritanceTest2Language";
	}

}
