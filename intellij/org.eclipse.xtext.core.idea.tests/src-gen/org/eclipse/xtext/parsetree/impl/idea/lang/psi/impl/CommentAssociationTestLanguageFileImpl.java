package org.eclipse.xtext.parsetree.impl.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageFileType;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class CommentAssociationTestLanguageFileImpl extends BaseXtextFile {

	public CommentAssociationTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, CommentAssociationTestLanguageLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return CommentAssociationTestLanguageFileType.INSTANCE;
	}

}
