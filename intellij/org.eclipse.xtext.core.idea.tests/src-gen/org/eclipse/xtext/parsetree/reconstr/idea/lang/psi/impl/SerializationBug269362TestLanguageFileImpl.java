package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SerializationBug269362TestLanguageFileImpl extends BaseXtextFile {

	public SerializationBug269362TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SerializationBug269362TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SerializationBug269362TestLanguageFileType.INSTANCE;
	}

}
