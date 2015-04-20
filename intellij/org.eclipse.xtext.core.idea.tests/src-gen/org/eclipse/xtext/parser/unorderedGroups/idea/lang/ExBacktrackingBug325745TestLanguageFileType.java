package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ExBacktrackingBug325745TestLanguageFileType extends LanguageFileType {

	public static final ExBacktrackingBug325745TestLanguageFileType INSTANCE = new ExBacktrackingBug325745TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "exbacktrackingbug325745testlanguage";

	private ExBacktrackingBug325745TestLanguageFileType() {
		super(ExBacktrackingBug325745TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "ExBacktrackingBug325745TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "ExBacktrackingBug325745TestLanguage";
	}

}
