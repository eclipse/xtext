package org.eclipse.xtext.enumrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class MultiRuleEnumTestLanguageFileType extends LanguageFileType {

	public static final MultiRuleEnumTestLanguageFileType INSTANCE = new MultiRuleEnumTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private MultiRuleEnumTestLanguageFileType() {
		super(MultiRuleEnumTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "MultiRuleEnumTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "MultiRuleEnumTestLanguage";
	}

}
