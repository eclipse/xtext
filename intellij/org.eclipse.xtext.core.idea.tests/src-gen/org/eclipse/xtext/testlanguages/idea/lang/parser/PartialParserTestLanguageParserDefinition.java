package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.PartialParserTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class PartialParserTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private PartialParserTestLanguageElementTypeProvider elementTypeProvider;

	public PsiFile createFile(FileViewProvider viewProvider) {
		return new PartialParserTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getNested_NestedSomeContainerParserRuleCall_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getSomeContainer_NameIDTerminalRuleCall_1_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getChild_ValueNamedParserRuleCall_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getNamed_NameIDTerminalRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFirstConcrete_ValueNamedParserRuleCall_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getNamed_NameIDTerminalRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSecondConcrete_ValueNamedParserRuleCall_4_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getNamed_NameIDTerminalRuleCall_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getSecondConcrete_ReferencedChildrenChildCrossReference_5_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
