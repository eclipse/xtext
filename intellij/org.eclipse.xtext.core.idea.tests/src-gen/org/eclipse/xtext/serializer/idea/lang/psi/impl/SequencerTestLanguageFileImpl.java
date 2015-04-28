package org.eclipse.xtext.serializer.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageFileType;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SequencerTestLanguageFileImpl extends BaseXtextFile {

	public SequencerTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SequencerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SequencerTestLanguageFileType.INSTANCE;
	}

}
