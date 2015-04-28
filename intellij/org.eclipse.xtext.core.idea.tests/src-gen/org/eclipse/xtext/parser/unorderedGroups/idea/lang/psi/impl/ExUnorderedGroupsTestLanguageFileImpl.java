package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ExUnorderedGroupsTestLanguageFileImpl extends BaseXtextFile {

	public ExUnorderedGroupsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ExUnorderedGroupsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ExUnorderedGroupsTestLanguageFileType.INSTANCE;
	}

}
