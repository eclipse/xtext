package org.eclipse.xtext.linking.lazy.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageFileType;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class LazyLinkingTestLanguageFileImpl extends BaseXtextFile {

	public LazyLinkingTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, LazyLinkingTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return LazyLinkingTestLanguageFileType.INSTANCE;
	}

}
