package org.eclipse.xtext.xbase.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.lang.XbaseFileType;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class XbaseFileImpl extends BaseXtextFile {

	public XbaseFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, XbaseLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return XbaseFileType.INSTANCE;
	}

}
