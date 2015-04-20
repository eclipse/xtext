package org.eclipse.xtext.generator.ecore.idea.lang.parser;

import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageElementTypeProvider;
import org.eclipse.xtext.generator.ecore.idea.lang.psi.impl.SubTestLanguageFileImpl;
import org.eclipse.xtext.generator.ecore.idea.lang.parser.SuperTestLanguageParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class SubTestLanguageParserDefinition extends SuperTestLanguageParserDefinition {

	@Inject 
	private SubTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new SubTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getSubMain_AnotherAnotherSuperMainParserRuleCall_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getAnotherSuperMain_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		return super.createElement(node);
	}

}
