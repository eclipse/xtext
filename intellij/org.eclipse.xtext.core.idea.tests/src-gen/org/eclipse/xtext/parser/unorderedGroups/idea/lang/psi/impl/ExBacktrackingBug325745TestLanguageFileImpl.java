package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ExBacktrackingBug325745TestLanguageFileImpl extends BaseXtextFile {

	public ExBacktrackingBug325745TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ExBacktrackingBug325745TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ExBacktrackingBug325745TestLanguageFileType.INSTANCE;
	}

}
