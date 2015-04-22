package org.eclipse.xtext.parsetree.impl.idea.lang.parser;

import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397ElementTypeProvider;
import org.eclipse.xtext.parsetree.impl.idea.lang.psi.impl.Bug305397FileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class Bug305397ParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private Bug305397ElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new Bug305397FileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		return super.createElement(node);
	}

}
