package org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class InheritanceTest3LanguageFileImpl extends BaseXtextFile {

	public InheritanceTest3LanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, InheritanceTest3LanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return InheritanceTest3LanguageFileType.INSTANCE;
	}

}
