package org.eclipse.xtext.enumrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class MultiRuleEnumTestLanguageFileType extends LanguageFileType {

	public static final MultiRuleEnumTestLanguageFileType INSTANCE = new MultiRuleEnumTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "multiruleenumtestlanguage";

	private MultiRuleEnumTestLanguageFileType() {
		super(MultiRuleEnumTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "MultiRuleEnumTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "MultiRuleEnumTestLanguage";
	}

}
