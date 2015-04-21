package org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class AbstractTestLanguageFileImpl extends BaseXtextFile {

	public AbstractTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, AbstractTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return AbstractTestLanguageFileType.INSTANCE;
	}

}
