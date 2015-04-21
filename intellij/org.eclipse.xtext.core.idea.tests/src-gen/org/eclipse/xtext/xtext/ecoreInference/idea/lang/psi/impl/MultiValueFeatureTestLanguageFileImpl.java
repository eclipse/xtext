package org.eclipse.xtext.xtext.ecoreInference.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageFileType;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class MultiValueFeatureTestLanguageFileImpl extends BaseXtextFile {

	public MultiValueFeatureTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, MultiValueFeatureTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return MultiValueFeatureTestLanguageFileType.INSTANCE;
	}

}
