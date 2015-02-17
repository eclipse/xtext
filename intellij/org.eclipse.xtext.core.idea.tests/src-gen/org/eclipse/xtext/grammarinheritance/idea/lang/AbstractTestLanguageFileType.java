package org.eclipse.xtext.grammarinheritance.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class AbstractTestLanguageFileType extends LanguageFileType {

	public static final AbstractTestLanguageFileType INSTANCE = new AbstractTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private AbstractTestLanguageFileType() {
		super(AbstractTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "AbstractTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "AbstractTestLanguage";
	}

}
