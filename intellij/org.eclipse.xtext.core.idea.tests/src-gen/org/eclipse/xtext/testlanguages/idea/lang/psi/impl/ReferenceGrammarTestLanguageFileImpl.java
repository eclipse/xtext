package org.eclipse.xtext.testlanguages.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ReferenceGrammarTestLanguageFileImpl extends BaseXtextFile {

	public ReferenceGrammarTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ReferenceGrammarTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ReferenceGrammarTestLanguageFileType.INSTANCE;
	}

}
