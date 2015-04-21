package org.eclipse.xtext.generator.grammarAccess.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageFileType;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class GrammarAccessTestLanguageFileImpl extends BaseXtextFile {

	public GrammarAccessTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, GrammarAccessTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return GrammarAccessTestLanguageFileType.INSTANCE;
	}

}
