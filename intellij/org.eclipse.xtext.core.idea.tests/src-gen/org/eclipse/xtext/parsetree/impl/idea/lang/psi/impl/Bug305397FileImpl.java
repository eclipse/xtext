package org.eclipse.xtext.parsetree.impl.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397FileType;
import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug305397FileImpl extends BaseXtextFile {

	public Bug305397FileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug305397Language.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug305397FileType.INSTANCE;
	}

}
