package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EcoreTerminalsTestLanguageFileType extends LanguageFileType {

	public static final EcoreTerminalsTestLanguageFileType INSTANCE = new EcoreTerminalsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private EcoreTerminalsTestLanguageFileType() {
		super(EcoreTerminalsTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "EcoreTerminalsTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "EcoreTerminalsTestLanguage";
	}

}
