package org.eclipse.xtext.xtext.ecoreInference.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageFileType;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class UnassignedRuleCallTestLanguageFileImpl extends BaseXtextFile {

	public UnassignedRuleCallTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, UnassignedRuleCallTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return UnassignedRuleCallTestLanguageFileType.INSTANCE;
	}

}
