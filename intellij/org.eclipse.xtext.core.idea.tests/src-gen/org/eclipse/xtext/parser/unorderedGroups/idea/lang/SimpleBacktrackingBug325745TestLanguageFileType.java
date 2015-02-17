package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SimpleBacktrackingBug325745TestLanguageFileType extends LanguageFileType {

	public static final SimpleBacktrackingBug325745TestLanguageFileType INSTANCE = new SimpleBacktrackingBug325745TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private SimpleBacktrackingBug325745TestLanguageFileType() {
		super(SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "SimpleBacktrackingBug325745TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "SimpleBacktrackingBug325745TestLanguage";
	}

}
