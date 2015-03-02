package org.eclipse.xtext.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.idea.lang.XtextFileType;
import org.eclipse.xtext.idea.lang.XtextLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class XtextFileImpl extends BaseXtextFile {

	public XtextFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, XtextLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return XtextFileType.INSTANCE;
	}

}
