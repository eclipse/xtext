package org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class InheritanceTest2LanguageFileImpl extends BaseXtextFile {

	public InheritanceTest2LanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, InheritanceTest2LanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return InheritanceTest2LanguageFileType.INSTANCE;
	}

}
