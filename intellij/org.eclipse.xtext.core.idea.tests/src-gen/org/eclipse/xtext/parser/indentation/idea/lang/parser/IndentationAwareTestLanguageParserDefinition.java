package org.eclipse.xtext.parser.indentation.idea.lang.parser;

import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.indentation.idea.lang.psi.impl.IndentationAwareTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class IndentationAwareTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private IndentationAwareTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new IndentationAwareTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getTree_NodesTreeNodeParserRuleCall_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getTreeNode_NameIDTerminalRuleCall_0_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getTreeNode_ChildrenTreeNodeParserRuleCall_1_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getTreeNode_NameIDTerminalRuleCall_0_0ElementType()
			);
		}
		return super.createElement(node);
	}

}
