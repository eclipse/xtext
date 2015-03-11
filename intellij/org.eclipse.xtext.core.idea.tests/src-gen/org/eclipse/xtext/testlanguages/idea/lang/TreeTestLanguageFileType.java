package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class TreeTestLanguageFileType extends LanguageFileType {

	public static final TreeTestLanguageFileType INSTANCE = new TreeTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "treetestlanguage";

	private TreeTestLanguageFileType() {
		super(TreeTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "TreeTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "TreeTestLanguage";
	}

}
