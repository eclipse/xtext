package org.eclipse.xtend.core.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class XtendFileImpl extends BaseXtextFile {

	public XtendFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, XtendLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return XtendFileType.INSTANCE;
	}

}
