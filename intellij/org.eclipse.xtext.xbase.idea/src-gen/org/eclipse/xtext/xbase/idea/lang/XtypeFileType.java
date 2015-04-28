package org.eclipse.xtext.xbase.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class XtypeFileType extends LanguageFileType {

	public static final XtypeFileType INSTANCE = new XtypeFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "___xtype";

	private XtypeFileType() {
		super(XtypeLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Xtype files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Xtype";
	}

}
