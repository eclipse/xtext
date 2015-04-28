package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug299395TestLanguageFileImpl extends BaseXtextFile {

	public Bug299395TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug299395TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug299395TestLanguageFileType.INSTANCE;
	}

}
