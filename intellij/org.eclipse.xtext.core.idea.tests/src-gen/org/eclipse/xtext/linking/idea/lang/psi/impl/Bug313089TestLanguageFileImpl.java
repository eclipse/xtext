package org.eclipse.xtext.linking.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug313089TestLanguageFileImpl extends BaseXtextFile {

	public Bug313089TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug313089TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug313089TestLanguageFileType.INSTANCE;
	}

}
