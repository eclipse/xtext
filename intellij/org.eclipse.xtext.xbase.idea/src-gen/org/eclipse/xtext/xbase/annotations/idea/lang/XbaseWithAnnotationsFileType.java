package org.eclipse.xtext.xbase.annotations.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class XbaseWithAnnotationsFileType extends LanguageFileType {

	public static final XbaseWithAnnotationsFileType INSTANCE = new XbaseWithAnnotationsFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "___xbasewithannotations";

	private XbaseWithAnnotationsFileType() {
		super(XbaseWithAnnotationsLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "XbaseWithAnnotations files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "XbaseWithAnnotations";
	}

}
