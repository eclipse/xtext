package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class BacktrackingBug325745TestLanguageFileImpl extends BaseXtextFile {

	public BacktrackingBug325745TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, BacktrackingBug325745TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return BacktrackingBug325745TestLanguageFileType.INSTANCE;
	}

}
