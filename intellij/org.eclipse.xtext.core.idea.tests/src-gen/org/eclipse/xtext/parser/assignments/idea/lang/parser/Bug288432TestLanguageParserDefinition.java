package org.eclipse.xtext.parser.assignments.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.lang.psi.impl.Bug288432TestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class Bug288432TestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private Bug288432TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new Bug288432TestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameter_NameIDTerminalRuleCall_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getBody_ParameterParameterParserRuleCall_0_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getParameter_NameIDTerminalRuleCall_0_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
