package org.eclipse.xtext.parser.fragments.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExFileType;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class FragmentTestLanguageExFileImpl extends BaseXtextFile {

	public FragmentTestLanguageExFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, FragmentTestLanguageExLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return FragmentTestLanguageExFileType.INSTANCE;
	}

}
