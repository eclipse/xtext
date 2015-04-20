package org.eclipse.xtext.generator.ecore.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageFileType;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EcoreFragmentTestLanguageFileImpl extends BaseXtextFile {

	public EcoreFragmentTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EcoreFragmentTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EcoreFragmentTestLanguageFileType.INSTANCE;
	}

}
