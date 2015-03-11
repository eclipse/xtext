package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class BacktrackingBug325745TestLanguageFileType extends LanguageFileType {

	public static final BacktrackingBug325745TestLanguageFileType INSTANCE = new BacktrackingBug325745TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "backtrackingbug325745testlanguage";

	private BacktrackingBug325745TestLanguageFileType() {
		super(BacktrackingBug325745TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "BacktrackingBug325745TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "BacktrackingBug325745TestLanguage";
	}

}
