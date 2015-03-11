package org.eclipse.xtext.xbase.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class XbaseFileType extends LanguageFileType {

	public static final XbaseFileType INSTANCE = new XbaseFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "___xbase";

	private XbaseFileType() {
		super(XbaseLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Xbase files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Xbase";
	}

}
