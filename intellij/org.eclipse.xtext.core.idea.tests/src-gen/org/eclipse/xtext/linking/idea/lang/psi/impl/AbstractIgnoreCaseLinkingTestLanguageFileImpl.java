package org.eclipse.xtext.linking.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class AbstractIgnoreCaseLinkingTestLanguageFileImpl extends BaseXtextFile {

	public AbstractIgnoreCaseLinkingTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return AbstractIgnoreCaseLinkingTestLanguageFileType.INSTANCE;
	}

}
