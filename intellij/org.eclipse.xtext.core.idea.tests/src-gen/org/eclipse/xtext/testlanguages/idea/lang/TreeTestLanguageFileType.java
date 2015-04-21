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

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "TreeTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "TreeTestLanguage";
	}

}
