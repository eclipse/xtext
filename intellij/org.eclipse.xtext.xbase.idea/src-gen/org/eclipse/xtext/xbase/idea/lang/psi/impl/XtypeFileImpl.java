package org.eclipse.xtext.xbase.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.lang.XtypeFileType;
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class XtypeFileImpl extends BaseXtextFile {

	public XtypeFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, XtypeLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return XtypeFileType.INSTANCE;
	}

}
