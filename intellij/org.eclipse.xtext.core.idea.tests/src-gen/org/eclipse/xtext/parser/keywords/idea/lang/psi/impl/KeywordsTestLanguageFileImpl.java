package org.eclipse.xtext.parser.keywords.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageFileType;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class KeywordsTestLanguageFileImpl extends BaseXtextFile {

	public KeywordsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, KeywordsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return KeywordsTestLanguageFileType.INSTANCE;
	}

}
