package org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ConcreteTestLanguageFileImpl extends BaseXtextFile {

	public ConcreteTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ConcreteTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ConcreteTestLanguageFileType.INSTANCE;
	}

}
