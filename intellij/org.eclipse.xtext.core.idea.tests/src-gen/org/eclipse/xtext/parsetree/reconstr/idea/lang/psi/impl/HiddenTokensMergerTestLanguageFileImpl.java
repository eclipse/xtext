package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class HiddenTokensMergerTestLanguageFileImpl extends BaseXtextFile {

	public HiddenTokensMergerTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, HiddenTokensMergerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return HiddenTokensMergerTestLanguageFileType.INSTANCE;
	}

}
