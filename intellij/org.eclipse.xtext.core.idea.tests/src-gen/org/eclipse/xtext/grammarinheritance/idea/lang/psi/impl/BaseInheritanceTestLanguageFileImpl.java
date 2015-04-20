package org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class BaseInheritanceTestLanguageFileImpl extends BaseXtextFile {

	public BaseInheritanceTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, BaseInheritanceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return BaseInheritanceTestLanguageFileType.INSTANCE;
	}

}
