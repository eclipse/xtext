package org.eclipse.xtext.parser.parameters.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ParametersTestLanguageFileImpl extends BaseXtextFile {

	public ParametersTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ParametersTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ParametersTestLanguageFileType.INSTANCE;
	}

}
