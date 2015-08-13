package org.eclipse.xtext.parser.fragments.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageFileType;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class FragmentTestLanguageFileImpl extends BaseXtextFile {

	public FragmentTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, FragmentTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return FragmentTestLanguageFileType.INSTANCE;
	}

}
