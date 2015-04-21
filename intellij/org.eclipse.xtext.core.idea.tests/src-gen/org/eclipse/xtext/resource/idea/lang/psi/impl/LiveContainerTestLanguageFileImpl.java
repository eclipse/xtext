package org.eclipse.xtext.resource.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageFileType;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class LiveContainerTestLanguageFileImpl extends BaseXtextFile {

	public LiveContainerTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, LiveContainerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return LiveContainerTestLanguageFileType.INSTANCE;
	}

}
