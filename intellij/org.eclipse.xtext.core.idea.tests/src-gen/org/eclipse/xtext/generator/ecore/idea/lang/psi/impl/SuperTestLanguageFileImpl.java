package org.eclipse.xtext.generator.ecore.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageFileType;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SuperTestLanguageFileImpl extends BaseXtextFile {

	public SuperTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SuperTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SuperTestLanguageFileType.INSTANCE;
	}

}
