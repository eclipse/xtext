package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SimpleReconstrTestLanguageFileImpl extends BaseXtextFile {

	public SimpleReconstrTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SimpleReconstrTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SimpleReconstrTestLanguageFileType.INSTANCE;
	}

}
