package org.eclipse.xtext.linking.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.Bug313089TestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class Bug313089TestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private Bug313089TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new Bug313089TestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getFoo_BarBarParserRuleCall_1_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getBar_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getBar_BarAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getBar_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getFoo_BazBazParserRuleCall_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getBaz_NameIDTerminalRuleCall_1_0ElementType(),
					elementTypeProvider.getBaz_NameIDTerminalRuleCall_2_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getBaz_BazChildAction_2_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getBaz_NameIDTerminalRuleCall_1_0ElementType(),
					elementTypeProvider.getBaz_NameIDTerminalRuleCall_2_2_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
