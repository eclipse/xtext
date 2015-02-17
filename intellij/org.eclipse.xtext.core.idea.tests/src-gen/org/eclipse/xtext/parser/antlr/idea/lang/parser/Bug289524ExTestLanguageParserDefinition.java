package org.eclipse.xtext.parser.antlr.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug289524ExTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class Bug289524ExTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private Bug289524ExTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new Bug289524ExTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getModelElement_ContainmentsContainedParserRuleCall_1_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getContained_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getModelElement_RefsContainedCrossReference_1_1_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getModelElement_RefsContainedCrossReference_1_1_2_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
