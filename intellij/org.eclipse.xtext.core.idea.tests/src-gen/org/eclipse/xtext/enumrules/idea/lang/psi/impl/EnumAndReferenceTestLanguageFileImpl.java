package org.eclipse.xtext.enumrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageFileType;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EnumAndReferenceTestLanguageFileImpl extends BaseXtextFile {

	public EnumAndReferenceTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EnumAndReferenceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EnumAndReferenceTestLanguageFileType.INSTANCE;
	}

}
