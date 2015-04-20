package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class HiddenTerminalsTestLanguageFileImpl extends BaseXtextFile {

	public HiddenTerminalsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, HiddenTerminalsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return HiddenTerminalsTestLanguageFileType.INSTANCE;
	}

}
