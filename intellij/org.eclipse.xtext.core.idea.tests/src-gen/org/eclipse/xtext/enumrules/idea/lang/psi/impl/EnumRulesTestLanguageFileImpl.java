package org.eclipse.xtext.enumrules.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageFileType;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EnumRulesTestLanguageFileImpl extends BaseXtextFile {

	public EnumRulesTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EnumRulesTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EnumRulesTestLanguageFileType.INSTANCE;
	}

}
