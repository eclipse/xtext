package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageFileType;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class RegionAccessTestLanguageFileImpl extends BaseXtextFile {

	public RegionAccessTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, RegionAccessTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return RegionAccessTestLanguageFileType.INSTANCE;
	}

}
