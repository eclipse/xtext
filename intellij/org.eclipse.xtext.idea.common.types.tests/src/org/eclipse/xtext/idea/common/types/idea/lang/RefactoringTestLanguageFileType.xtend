package org.eclipse.xtext.idea.common.types.idea.lang;

class RefactoringTestLanguageFileType extends AbstractRefactoringTestLanguageFileType {

	public static final RefactoringTestLanguageFileType INSTANCE = new RefactoringTestLanguageFileType()
	
	new() {
		super(RefactoringTestLanguageLanguage.INSTANCE)
	}

}
