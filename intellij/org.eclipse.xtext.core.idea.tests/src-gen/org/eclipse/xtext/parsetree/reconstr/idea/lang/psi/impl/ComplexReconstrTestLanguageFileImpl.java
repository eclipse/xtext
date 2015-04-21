package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ComplexReconstrTestLanguageFileImpl extends BaseXtextFile {

	public ComplexReconstrTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ComplexReconstrTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ComplexReconstrTestLanguageFileType.INSTANCE;
	}

}
