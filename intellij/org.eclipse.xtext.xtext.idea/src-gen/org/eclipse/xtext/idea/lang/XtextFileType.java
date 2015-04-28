package org.eclipse.xtext.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class XtextFileType extends LanguageFileType {

	public static final XtextFileType INSTANCE = new XtextFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "xtext";

	private XtextFileType() {
		super(XtextLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Xtext files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Xtext";
	}

}
