package org.eclipse.xtext.resource.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EObjectAtOffsetTestLanguageFileType extends LanguageFileType {

	public static final EObjectAtOffsetTestLanguageFileType INSTANCE = new EObjectAtOffsetTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private EObjectAtOffsetTestLanguageFileType() {
		super(EObjectAtOffsetTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "EObjectAtOffsetTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "EObjectAtOffsetTestLanguage";
	}

}
