package org.eclipse.xtext.parser.bug419429.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429FileType;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug419429FileImpl extends BaseXtextFile {

	public Bug419429FileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug419429Language.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug419429FileType.INSTANCE;
	}

}
