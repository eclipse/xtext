package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug297105TestLanguageFileImpl extends BaseXtextFile {

	public Bug297105TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug297105TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug297105TestLanguageFileType.INSTANCE;
	}

}
