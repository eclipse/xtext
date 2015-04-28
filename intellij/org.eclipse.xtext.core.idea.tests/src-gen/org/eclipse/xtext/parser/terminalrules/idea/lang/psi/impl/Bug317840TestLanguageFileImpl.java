package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug317840TestLanguageFileImpl extends BaseXtextFile {

	public Bug317840TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug317840TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug317840TestLanguageFileType.INSTANCE;
	}

}
