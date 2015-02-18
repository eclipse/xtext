package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ActionTestLanguage2FileType extends LanguageFileType {

	public static final ActionTestLanguage2FileType INSTANCE = new ActionTestLanguage2FileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "actiontestlanguage2";

	private ActionTestLanguage2FileType() {
		super(ActionTestLanguage2Language.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "ActionTestLanguage2 files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "ActionTestLanguage2";
	}

}
