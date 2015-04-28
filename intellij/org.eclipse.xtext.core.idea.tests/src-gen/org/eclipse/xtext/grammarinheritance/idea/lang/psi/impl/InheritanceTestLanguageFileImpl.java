package org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class InheritanceTestLanguageFileImpl extends BaseXtextFile {

	public InheritanceTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, InheritanceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return InheritanceTestLanguageFileType.INSTANCE;
	}

}
