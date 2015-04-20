package org.eclipse.xtext.resource.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EObjectAtOffsetTestLanguageFileType extends LanguageFileType {

	public static final EObjectAtOffsetTestLanguageFileType INSTANCE = new EObjectAtOffsetTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "eobjectatoffsettestlanguage";

	private EObjectAtOffsetTestLanguageFileType() {
		super(EObjectAtOffsetTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "EObjectAtOffsetTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "EObjectAtOffsetTestLanguage";
	}

}
