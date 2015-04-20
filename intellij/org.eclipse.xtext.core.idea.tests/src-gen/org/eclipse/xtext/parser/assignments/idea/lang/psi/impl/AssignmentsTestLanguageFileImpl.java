package org.eclipse.xtext.parser.assignments.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class AssignmentsTestLanguageFileImpl extends BaseXtextFile {

	public AssignmentsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, AssignmentsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return AssignmentsTestLanguageFileType.INSTANCE;
	}

}
