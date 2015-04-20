package org.eclipse.xtext.parser.datatyperules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageFileType;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class DatatypeRulesTestLanguageFileImpl extends BaseXtextFile {

	public DatatypeRulesTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, DatatypeRulesTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return DatatypeRulesTestLanguageFileType.INSTANCE;
	}

}
