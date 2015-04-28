package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class TerminalRulesTestLanguageFileImpl extends BaseXtextFile {

	public TerminalRulesTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, TerminalRulesTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return TerminalRulesTestLanguageFileType.INSTANCE;
	}

}
