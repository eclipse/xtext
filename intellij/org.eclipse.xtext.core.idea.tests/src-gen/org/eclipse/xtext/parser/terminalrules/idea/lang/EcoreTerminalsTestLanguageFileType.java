package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EcoreTerminalsTestLanguageFileType extends LanguageFileType {

	public static final EcoreTerminalsTestLanguageFileType INSTANCE = new EcoreTerminalsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "ecoreterminalstestlanguage";

	private EcoreTerminalsTestLanguageFileType() {
		super(EcoreTerminalsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "EcoreTerminalsTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "EcoreTerminalsTestLanguage";
	}

}
