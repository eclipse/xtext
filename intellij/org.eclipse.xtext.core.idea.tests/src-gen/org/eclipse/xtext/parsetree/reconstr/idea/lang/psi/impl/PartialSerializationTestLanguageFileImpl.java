package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class PartialSerializationTestLanguageFileImpl extends BaseXtextFile {

	public PartialSerializationTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, PartialSerializationTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return PartialSerializationTestLanguageFileType.INSTANCE;
	}

}
