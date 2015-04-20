package org.eclipse.xtext.testlanguages.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2FileType;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ActionTestLanguage2FileImpl extends BaseXtextFile {

	public ActionTestLanguage2FileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ActionTestLanguage2Language.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ActionTestLanguage2FileType.INSTANCE;
	}

}
