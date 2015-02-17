package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class HiddenTerminalsTestLanguageFileType extends LanguageFileType {

	public static final HiddenTerminalsTestLanguageFileType INSTANCE = new HiddenTerminalsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private HiddenTerminalsTestLanguageFileType() {
		super(HiddenTerminalsTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "HiddenTerminalsTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "HiddenTerminalsTestLanguage";
	}

}
