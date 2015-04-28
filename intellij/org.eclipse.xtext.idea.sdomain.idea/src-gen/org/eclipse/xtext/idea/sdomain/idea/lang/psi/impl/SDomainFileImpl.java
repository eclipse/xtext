package org.eclipse.xtext.idea.sdomain.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SDomainFileImpl extends BaseXtextFile {

	public SDomainFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SDomainLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SDomainFileType.INSTANCE;
	}

}
