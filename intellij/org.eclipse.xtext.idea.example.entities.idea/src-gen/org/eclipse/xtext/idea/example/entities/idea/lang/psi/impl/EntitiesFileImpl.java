package org.eclipse.xtext.idea.example.entities.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesFileType;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EntitiesFileImpl extends BaseXtextFile {

	public EntitiesFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EntitiesLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EntitiesFileType.INSTANCE;
	}

}
