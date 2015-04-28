package org.eclipse.xtext.parser.indentation.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageFileType;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class IndentationAwareTestLanguageFileImpl extends BaseXtextFile {

	public IndentationAwareTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, IndentationAwareTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return IndentationAwareTestLanguageFileType.INSTANCE;
	}

}
