package org.eclipse.xtext.parsetree.transientvalues.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestFileType;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class TransientValuesTestFileImpl extends BaseXtextFile {

	public TransientValuesTestFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, TransientValuesTestLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return TransientValuesTestFileType.INSTANCE;
	}

}
