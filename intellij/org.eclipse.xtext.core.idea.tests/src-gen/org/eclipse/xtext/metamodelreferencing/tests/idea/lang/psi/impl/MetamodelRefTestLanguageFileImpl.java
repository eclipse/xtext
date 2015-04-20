package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageFileType;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class MetamodelRefTestLanguageFileImpl extends BaseXtextFile {

	public MetamodelRefTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, MetamodelRefTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return MetamodelRefTestLanguageFileType.INSTANCE;
	}

}
