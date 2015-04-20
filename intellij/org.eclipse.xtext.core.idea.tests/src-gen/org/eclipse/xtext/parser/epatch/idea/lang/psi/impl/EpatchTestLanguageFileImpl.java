package org.eclipse.xtext.parser.epatch.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageFileType;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EpatchTestLanguageFileImpl extends BaseXtextFile {

	public EpatchTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EpatchTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EpatchTestLanguageFileType.INSTANCE;
	}

}
