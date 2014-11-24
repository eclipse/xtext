package org.eclipse.xtext.idea.common.types.idea.lang.types.psi.search;

import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

public class RefactoringTestLanguageJvmElementsReferencesSearch extends JvmElementsReferencesSearch {

	public RefactoringTestLanguageJvmElementsReferencesSearch() {
		super(RefactoringTestLanguageLanguage.INSTANCE);
	}

}
