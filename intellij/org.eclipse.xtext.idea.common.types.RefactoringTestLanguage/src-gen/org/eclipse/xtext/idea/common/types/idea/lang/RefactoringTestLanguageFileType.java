package org.eclipse.xtext.idea.common.types.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class RefactoringTestLanguageFileType extends LanguageFileType {

	public static final RefactoringTestLanguageFileType INSTANCE = new RefactoringTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "typesRefactoring";

	private RefactoringTestLanguageFileType() {
		super(RefactoringTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "RefactoringTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "RefactoringTestLanguage";
	}

}
