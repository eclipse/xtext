package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class XtextTerminalsTestLanguageFileType extends LanguageFileType {

	public static final XtextTerminalsTestLanguageFileType INSTANCE = new XtextTerminalsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "xtextterminalstestlanguage";

	private XtextTerminalsTestLanguageFileType() {
		super(XtextTerminalsTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "XtextTerminalsTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "XtextTerminalsTestLanguage";
	}

}
