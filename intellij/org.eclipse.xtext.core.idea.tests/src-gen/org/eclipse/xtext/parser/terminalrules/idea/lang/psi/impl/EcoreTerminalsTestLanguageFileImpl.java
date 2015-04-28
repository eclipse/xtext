package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EcoreTerminalsTestLanguageFileImpl extends BaseXtextFile {

	public EcoreTerminalsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EcoreTerminalsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EcoreTerminalsTestLanguageFileType.INSTANCE;
	}

}
