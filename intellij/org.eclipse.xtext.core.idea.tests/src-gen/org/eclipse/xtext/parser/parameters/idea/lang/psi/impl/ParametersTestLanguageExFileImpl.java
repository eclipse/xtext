package org.eclipse.xtext.parser.parameters.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ParametersTestLanguageExFileImpl extends BaseXtextFile {

	public ParametersTestLanguageExFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ParametersTestLanguageExLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ParametersTestLanguageExFileType.INSTANCE;
	}

}
