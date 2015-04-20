package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SerializationErrorTestLanguageFileImpl extends BaseXtextFile {

	public SerializationErrorTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SerializationErrorTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SerializationErrorTestLanguageFileType.INSTANCE;
	}

}
