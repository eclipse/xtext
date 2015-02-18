package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ActionTestLanguageFileType extends LanguageFileType {

	public static final ActionTestLanguageFileType INSTANCE = new ActionTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "actiontestlanguage";

	private ActionTestLanguageFileType() {
		super(ActionTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "ActionTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "ActionTestLanguage";
	}

}
