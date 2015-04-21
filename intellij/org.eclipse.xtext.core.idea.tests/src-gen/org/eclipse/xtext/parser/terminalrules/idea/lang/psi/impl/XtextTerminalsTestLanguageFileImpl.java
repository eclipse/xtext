package org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class XtextTerminalsTestLanguageFileImpl extends BaseXtextFile {

	public XtextTerminalsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, XtextTerminalsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return XtextTerminalsTestLanguageFileType.INSTANCE;
	}

}
