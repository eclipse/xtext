package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class HiddenTerminalsTestLanguageFileType extends LanguageFileType {

	public static final HiddenTerminalsTestLanguageFileType INSTANCE = new HiddenTerminalsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "hiddenterminalstestlanguage";

	private HiddenTerminalsTestLanguageFileType() {
		super(HiddenTerminalsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "HiddenTerminalsTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "HiddenTerminalsTestLanguage";
	}

}
