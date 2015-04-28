package org.eclipse.xtext.idea.common.types.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class RefactoringTestLanguageFileType extends LanguageFileType {

	public static final RefactoringTestLanguageFileType INSTANCE = new RefactoringTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "ideaTypesRefactoring";

	private RefactoringTestLanguageFileType() {
		super(RefactoringTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "RefactoringTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "RefactoringTestLanguage";
	}

}
