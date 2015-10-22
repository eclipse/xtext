package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.FowlerDslTestLanguageFileImpl;
import org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class FowlerDslTestLanguageParserDefinition extends AbstractXtextParserDefinition {

	@Inject 
	private FowlerDslTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new FowlerDslTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);
		if (hasSemanticElement != null && hasSemanticElement) {
			if (elementType == elementTypeProvider.getStatemachine_EventsEventParserRuleCall_1_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getEvent_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getStatemachine_CommandsCommandParserRuleCall_4_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getCommand_NameIDTerminalRuleCall_0_0ElementType()
				);
			}
			if (elementType == elementTypeProvider.getStatemachine_StatesStateParserRuleCall_6_0ElementType()) {
				return new PsiNamedEObjectImpl(node,
					elementTypeProvider.getState_NameIDTerminalRuleCall_1_0ElementType()
				);
			}
		}
		return super.createElement(node);
	}

}
