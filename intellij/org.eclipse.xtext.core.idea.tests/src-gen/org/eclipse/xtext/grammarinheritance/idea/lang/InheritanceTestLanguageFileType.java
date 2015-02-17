package org.eclipse.xtext.grammarinheritance.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class InheritanceTestLanguageFileType extends LanguageFileType {

	public static final InheritanceTestLanguageFileType INSTANCE = new InheritanceTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private InheritanceTestLanguageFileType() {
		super(InheritanceTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "InheritanceTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "InheritanceTestLanguage";
	}

}
