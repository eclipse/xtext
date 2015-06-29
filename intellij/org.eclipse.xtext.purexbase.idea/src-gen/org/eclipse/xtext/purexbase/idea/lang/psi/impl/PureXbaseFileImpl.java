package org.eclipse.xtext.purexbase.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseFileType;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class PureXbaseFileImpl extends BaseXtextFile {

	public PureXbaseFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, PureXbaseLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return PureXbaseFileType.INSTANCE;
	}

}
