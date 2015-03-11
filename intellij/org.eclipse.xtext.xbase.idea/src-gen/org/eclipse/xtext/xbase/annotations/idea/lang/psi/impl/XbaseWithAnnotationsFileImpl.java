package org.eclipse.xtext.xbase.annotations.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsFileType;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class XbaseWithAnnotationsFileImpl extends BaseXtextFile {

	public XbaseWithAnnotationsFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, XbaseWithAnnotationsLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return XbaseWithAnnotationsFileType.INSTANCE;
	}

}
