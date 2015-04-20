package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SimpleBacktrackingBug325745TestLanguageFileImpl extends BaseXtextFile {

	public SimpleBacktrackingBug325745TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SimpleBacktrackingBug325745TestLanguageFileType.INSTANCE;
	}

}
