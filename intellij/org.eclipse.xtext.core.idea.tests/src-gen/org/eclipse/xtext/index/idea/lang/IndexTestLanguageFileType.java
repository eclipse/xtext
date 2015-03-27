package org.eclipse.xtext.index.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class IndexTestLanguageFileType extends LanguageFileType {

	public static final IndexTestLanguageFileType INSTANCE = new IndexTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "indextestlanguage";

	private IndexTestLanguageFileType() {
		super(IndexTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "IndexTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "IndexTestLanguage";
	}

}
