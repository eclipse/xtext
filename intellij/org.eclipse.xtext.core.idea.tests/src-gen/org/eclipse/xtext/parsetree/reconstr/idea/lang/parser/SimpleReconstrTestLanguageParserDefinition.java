package org.eclipse.xtext.parsetree.reconstr.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SimpleReconstrTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class SimpleReconstrTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private SimpleReconstrTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new SimpleReconstrTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getTerm_AtomParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getAtom_NameIDTerminalRuleCall_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTerm_TypeParserRuleCall_3ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTerm_LoopBug285452ParserRuleCall_14ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getLoopBug285452_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getEmptyObjectItems_ListEmptyObjectItemParserRuleCall_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getEmptyObjectItem_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getEObjectRef_ObjEObjectElementParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getEObjectElement_NameIDTerminalRuleCall_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug305577_1_TypeBug1AParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug1A_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug1A_TypeBug1AAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug1A_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug305577_1_TypeBug1BParserRuleCall_1_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug1B_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug1B_TypeBug1BAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug1B_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug1AInh_TypeBug1BParserRuleCallElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug1B_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug305577_2_TypeBug2AParserRuleCall_1_1ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug2A_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug2A_TypeBug2AAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug2A_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug305577_2_TypeBug2BParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug2B_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug2B_TypeBug2BAction_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug2B_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTypeBug2AInh_TypeBug2BParserRuleCallElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getTypeBug2B_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getTerm_Bug305171ParserRuleCall_22ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getBug305171_NameIDTerminalRuleCall_2_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getCrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getCrossRefNamed_NameID1TerminalRuleCall_0_0ElementType(),
					elementTypeProvider.getCrossRefNamed_NameID2TerminalRuleCall_0_1ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
