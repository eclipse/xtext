package org.eclipse.xtext.resource.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageFileType;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EObjectAtOffsetTestLanguageFileImpl extends BaseXtextFile {

	public EObjectAtOffsetTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EObjectAtOffsetTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EObjectAtOffsetTestLanguageFileType.INSTANCE;
	}

}
