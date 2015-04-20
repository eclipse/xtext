package org.eclipse.xtext.formatting2.internal.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageFileType;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class FormatterTestLanguageFileImpl extends BaseXtextFile {

	public FormatterTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, FormatterTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return FormatterTestLanguageFileType.INSTANCE;
	}

}
