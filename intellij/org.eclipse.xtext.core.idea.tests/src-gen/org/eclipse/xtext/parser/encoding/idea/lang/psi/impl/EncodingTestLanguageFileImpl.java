package org.eclipse.xtext.parser.encoding.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageFileType;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EncodingTestLanguageFileImpl extends BaseXtextFile {

	public EncodingTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EncodingTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EncodingTestLanguageFileType.INSTANCE;
	}

}
