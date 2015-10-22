package org.eclipse.xtext.linking.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.Bug287988TestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class Bug287988TestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private Bug287988TestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new Bug287988TestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getModel_AttributesBaseAttributeParserRuleCall_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getBaseAttribute_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_AttributesActionAttributeParserRuleCall_5_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getActionAttribute_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getActionAttribute_AttributeAction_0_0_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getActionAttribute_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getActionAttribute_MasterAction_0_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getActionAttribute_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_AttributesSimpleAttributeParserRuleCall_1_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getSimpleAttribute_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getModel_AttributesRuleCallAttributeParserRuleCall_2_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getRuleCallAttribute_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getRuleCallAttribute2_CallMe2ParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getCallMe2_NameIDTerminalRuleCall_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getCallMe3_CallMe4ParserRuleCall_2ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getCallMe4_NameIDTerminalRuleCall_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
