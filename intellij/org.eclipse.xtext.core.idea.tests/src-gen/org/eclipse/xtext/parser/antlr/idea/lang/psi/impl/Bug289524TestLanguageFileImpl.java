package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug289524TestLanguageFileImpl extends BaseXtextFile {

	public Bug289524TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug289524TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug289524TestLanguageFileType.INSTANCE;
	}

}
