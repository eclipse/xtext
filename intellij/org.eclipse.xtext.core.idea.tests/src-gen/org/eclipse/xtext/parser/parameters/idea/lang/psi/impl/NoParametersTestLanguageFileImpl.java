package org.eclipse.xtext.parser.parameters.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class NoParametersTestLanguageFileImpl extends BaseXtextFile {

	public NoParametersTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, NoParametersTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return NoParametersTestLanguageFileType.INSTANCE;
	}

}
