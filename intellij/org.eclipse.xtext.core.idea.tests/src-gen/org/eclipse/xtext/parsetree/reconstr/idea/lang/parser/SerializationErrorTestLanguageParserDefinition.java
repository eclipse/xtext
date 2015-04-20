package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SerializationErrorTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class SerializationErrorTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private SerializationErrorTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new SerializationErrorTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		return super.createElement(node);
	}

}
