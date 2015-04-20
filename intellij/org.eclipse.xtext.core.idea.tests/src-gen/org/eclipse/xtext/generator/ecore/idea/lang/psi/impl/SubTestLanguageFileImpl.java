package org.eclipse.xtext.generator.ecore.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageFileType;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SubTestLanguageFileImpl extends BaseXtextFile {

	public SubTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SubTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SubTestLanguageFileType.INSTANCE;
	}

}
