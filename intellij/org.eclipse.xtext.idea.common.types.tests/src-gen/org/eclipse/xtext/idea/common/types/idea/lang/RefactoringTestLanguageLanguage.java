package org.eclipse.xtext.idea.common.types.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class RefactoringTestLanguageLanguage extends AbstractXtextLanguage {

	public static final RefactoringTestLanguageLanguage INSTANCE = new RefactoringTestLanguageLanguage();

	private RefactoringTestLanguageLanguage() {
		super("org.eclipse.xtext.idea.common.types.RefactoringTestLanguage");
	}

}
