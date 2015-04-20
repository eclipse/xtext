package org.eclipse.xtext.testlanguages.idea.lang.parser;

import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.ReferenceGrammarTestLanguageFileImpl;
import org.eclipse.xtext.common.idea.lang.parser.TerminalsParserDefinition;
import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

public class ReferenceGrammarTestLanguageParserDefinition extends TerminalsParserDefinition {

	@Inject 
	private ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider;

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new ReferenceGrammarTestLanguageFileImpl(viewProvider);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PsiElement createElement(ASTNode node) {
		IElementType elementType = node.getElementType();
		if (elementType == elementTypeProvider.getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPerson_KindParserRuleCall_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getPerson_ErwachsenerParserRuleCall_1ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getSpielzeug_NameIDTerminalRuleCall_2_0ElementType()
			);
		}
		if (elementType == elementTypeProvider.getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType()) {
			return new PsiNamedEObjectImpl(node,
				elementTypeProvider.getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType(),
				elementTypeProvider.getFamilie_NameIDTerminalRuleCall_2_0_2ElementType()
			);
		}
		if (elementType == elementTypeProvider.getFamilie_MutterErwachsenerCrossReference_3_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getFamilie_VaterErwachsenerCrossReference_4_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getFamilie_KinderKindCrossReference_5_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		if (elementType == elementTypeProvider.getFamilie_KinderKindCrossReference_6_1_0ElementType()) {
			return new PsiEObjectReference(node);
		}
		return super.createElement(node);
	}

}
