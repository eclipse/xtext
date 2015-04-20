package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class UnicodeTestLanguageFileImpl extends BaseXtextFile {

	public UnicodeTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, UnicodeTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return UnicodeTestLanguageFileType.INSTANCE;
	}

}
