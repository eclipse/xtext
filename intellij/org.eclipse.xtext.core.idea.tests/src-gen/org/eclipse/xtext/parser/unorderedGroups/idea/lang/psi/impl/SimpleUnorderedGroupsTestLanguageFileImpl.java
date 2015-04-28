package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SimpleUnorderedGroupsTestLanguageFileImpl extends BaseXtextFile {

	public SimpleUnorderedGroupsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SimpleUnorderedGroupsTestLanguageFileType.INSTANCE;
	}

}
