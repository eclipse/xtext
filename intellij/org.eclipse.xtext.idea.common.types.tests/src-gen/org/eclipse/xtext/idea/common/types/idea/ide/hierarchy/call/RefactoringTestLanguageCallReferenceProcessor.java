package org.eclipse.xtext.idea.common.types.idea.ide.hierarchy.call;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;

public class RefactoringTestLanguageCallReferenceProcessor extends JvmExecutableCallReferenceProcessor {

	public RefactoringTestLanguageCallReferenceProcessor() {
		super(RefactoringTestLanguageLanguage.INSTANCE);
	}

}
