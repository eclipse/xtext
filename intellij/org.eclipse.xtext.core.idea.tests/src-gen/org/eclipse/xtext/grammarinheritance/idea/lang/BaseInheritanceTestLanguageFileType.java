package org.eclipse.xtext.grammarinheritance.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class BaseInheritanceTestLanguageFileType extends LanguageFileType {

	public static final BaseInheritanceTestLanguageFileType INSTANCE = new BaseInheritanceTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "baseinheritancetestlanguage";

	private BaseInheritanceTestLanguageFileType() {
		super(BaseInheritanceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "BaseInheritanceTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "BaseInheritanceTestLanguage";
	}

}
