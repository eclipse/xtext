package org.eclipse.xtext.parser.parameters.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class TwoParametersTestLanguageFileImpl extends BaseXtextFile {

	public TwoParametersTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, TwoParametersTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return TwoParametersTestLanguageFileType.INSTANCE;
	}

}
