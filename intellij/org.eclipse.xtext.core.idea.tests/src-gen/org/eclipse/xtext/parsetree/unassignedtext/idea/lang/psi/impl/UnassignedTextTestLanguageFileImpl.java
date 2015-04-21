package org.eclipse.xtext.parsetree.unassignedtext.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageFileType;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class UnassignedTextTestLanguageFileImpl extends BaseXtextFile {

	public UnassignedTextTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, UnassignedTextTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return UnassignedTextTestLanguageFileType.INSTANCE;
	}

}
