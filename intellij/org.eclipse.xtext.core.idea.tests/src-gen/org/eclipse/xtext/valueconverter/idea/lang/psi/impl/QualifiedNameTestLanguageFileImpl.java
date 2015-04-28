package org.eclipse.xtext.valueconverter.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageFileType;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class QualifiedNameTestLanguageFileImpl extends BaseXtextFile {

	public QualifiedNameTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, QualifiedNameTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return QualifiedNameTestLanguageFileType.INSTANCE;
	}

}
