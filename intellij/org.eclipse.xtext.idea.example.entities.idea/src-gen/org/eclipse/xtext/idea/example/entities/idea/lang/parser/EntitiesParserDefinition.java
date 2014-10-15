package org.eclipse.xtext.idea.example.entities.idea.lang.parser;

import org.eclipse.xtext.idea.lang.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.idea.example.entities.idea.lang.psi.impl.EntitiesFileImpl;

import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;

public class EntitiesParserDefinition extends AbstractXtextParserDefinition {

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new EntitiesFileImpl(viewProvider);
	}

}
