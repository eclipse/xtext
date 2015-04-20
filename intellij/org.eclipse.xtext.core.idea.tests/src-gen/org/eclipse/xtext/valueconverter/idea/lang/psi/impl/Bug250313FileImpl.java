package org.eclipse.xtext.valueconverter.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313FileType;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug250313FileImpl extends BaseXtextFile {

	public Bug250313FileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug250313Language.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug250313FileType.INSTANCE;
	}

}
