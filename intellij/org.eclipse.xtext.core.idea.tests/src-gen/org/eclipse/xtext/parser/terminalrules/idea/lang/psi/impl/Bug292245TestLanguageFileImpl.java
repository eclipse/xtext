package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug292245TestLanguageFileImpl extends BaseXtextFile {

	public Bug292245TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug292245TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug292245TestLanguageFileType.INSTANCE;
	}

}
