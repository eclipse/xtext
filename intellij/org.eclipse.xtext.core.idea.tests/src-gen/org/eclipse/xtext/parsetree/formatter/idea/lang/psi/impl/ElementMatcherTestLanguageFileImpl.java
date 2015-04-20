package org.eclipse.xtext.parsetree.formatter.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageFileType;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ElementMatcherTestLanguageFileImpl extends BaseXtextFile {

	public ElementMatcherTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ElementMatcherTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ElementMatcherTestLanguageFileType.INSTANCE;
	}

}
