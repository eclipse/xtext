package org.eclipse.xtext.serializer.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageFileType;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SyntacticSequencerTestLanguageFileImpl extends BaseXtextFile {

	public SyntacticSequencerTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SyntacticSequencerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SyntacticSequencerTestLanguageFileType.INSTANCE;
	}

}
