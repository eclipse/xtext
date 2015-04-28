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

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "XtextTerminalsTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "XtextTerminalsTestLanguage";
	}

}
