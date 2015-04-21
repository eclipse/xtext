package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class UnorderedGroupsTestLanguageFileImpl extends BaseXtextFile {

	public UnorderedGroupsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, UnorderedGroupsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return UnorderedGroupsTestLanguageFileType.INSTANCE;
	}

}
